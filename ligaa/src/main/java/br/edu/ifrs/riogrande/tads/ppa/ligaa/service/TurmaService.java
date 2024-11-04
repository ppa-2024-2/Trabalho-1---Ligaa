package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Turma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.DadosMatricula;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Matricula;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.TurmaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorInexistenteException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoInexistenteException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaInexistenteException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.TurmaInexistenteException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoAprovadoException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.VagasPreenchidasException;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final ProfessorRepository professorRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final AlunoRepository alunoRepository;

    public TurmaService(TurmaRepository turmaRepository, DisciplinaRepository disciplinaRepository,
            ProfessorRepository professorRepository, AlunoRepository alunoRepository) {
        this.turmaRepository = turmaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
    }

    public void cadastrarTurma(NovaTurma novaTurma) {

        if (turmaRepository.codeNameExists(novaTurma.getCodeName())) {
            throw new IllegalStateException("Turma já existe: " + novaTurma.getCodeName());
        }

        Professor professor = new Professor();
        Disciplina disciplina = new Disciplina();

        String siape = novaTurma.getSiape();
        String disciplinaCodeName = novaTurma.getDisciplinaCodeName();

        if (professorRepository.findBySiape(siape) != null) {
            professor = professorRepository.findBySiape(siape);
        } else {
            throw new ProfessorInexistenteException();
        }

        if (disciplinaRepository.findByName(disciplinaCodeName) != null) {
            disciplina = disciplinaRepository.findByName(disciplinaCodeName);
        } else {
            throw new DisciplinaInexistenteException();
        }

        Turma turma = new Turma();

        turma.setCodeName(novaTurma.getCodeName());
        turma.setDisciplina(disciplina);
        turma.setProfessor(professor);
        turma.setSemestre(novaTurma.getSemestre());
        turma.setSala(novaTurma.getSala());
        turma.setVagas(novaTurma.getVagas());
        turma.setDiaSemana(novaTurma.getDiaSemana());
        turma.setHoraInicio(novaTurma.getHoraInicio());
        turma.setHoraFim(novaTurma.getHoraFim());
        turma.setMatriculados(new ArrayList<>());

        turmaRepository.save(turma);
    }

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public void matricularAluno(DadosMatricula dadosMatricula) {
        Turma turma = new Turma();
        Aluno aluno = new Aluno();

        if (turmaRepository.findByName(dadosMatricula.getTurmaCodeName()) != null) {
            turma = turmaRepository.findByName(dadosMatricula.getTurmaCodeName());
        } else {
            throw new TurmaInexistenteException();
        }

        if (alunoRepository.findByCpf(dadosMatricula.getCpf()) != null) {
            aluno = alunoRepository.findByCpf(dadosMatricula.getCpf());
        } else {
            throw new AlunoInexistenteException();
        }

        ArrayList<Matricula> matriculas = turma.getMatriculados();

        String numMatricula = aluno.getCpf() + "" + UUID.randomUUID();

        if (matriculas.size() > 0) {
            for (Matricula matricula : matriculas) {
                if (matricula.getAluno().getCpf().equals(aluno.getCpf())) {
                    if (matricula.isEstaAprovado()) {
                        throw new AlunoAprovadoException();
                    } else {
                        break;
                    }
                } else {
                    if (matriculas.size() >= turma.getVagas()) {
                        throw new VagasPreenchidasException();
                    }
                }
            }

            Matricula m = gerarMatricula(numMatricula, aluno);
            matriculas.add(m);
        } else {
            if (matriculas.size() >= turma.getVagas()) {
                throw new VagasPreenchidasException();
            } else {
                Matricula m = gerarMatricula(numMatricula, aluno);
                matriculas.add(m);
            }
        }
    }

    private Matricula gerarMatricula(String numero, Aluno aluno) {
        Matricula matricula = new Matricula();

        matricula.setAluno(aluno);
        matricula.setNumero(numero);

        return matricula;
    }

    public void setAprovado(DadosMatricula dadosMatricula) {
        Turma turma = new Turma();
        Aluno aluno = new Aluno();

        if (turmaRepository.findByName(dadosMatricula.getTurmaCodeName()) != null) {
            turma = turmaRepository.findByName(dadosMatricula.getTurmaCodeName());
        } else {
            throw new TurmaInexistenteException();
        }

        if (alunoRepository.findByCpf(dadosMatricula.getCpf()) != null) {
            aluno = alunoRepository.findByCpf(dadosMatricula.getCpf());
        } else {
            throw new AlunoInexistenteException();
        }

        ArrayList<Matricula> matriculas = turma.getMatriculados();

        for (Matricula matricula : matriculas) {
            if (matricula.getAluno().getCpf().equals(aluno.getCpf())) {
                matricula.setEstaAprovado(true);
            }
        }
    }
}
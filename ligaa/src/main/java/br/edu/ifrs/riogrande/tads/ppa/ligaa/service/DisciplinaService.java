package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.PreRequisitoInexistenteException;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public void cadastrarDisciplina(NovaDisciplina novaDisciplina) {

        if (disciplinaRepository.codeNameExists(novaDisciplina.getCodeName())) {
            throw new IllegalStateException("Disciplina já existe: " + novaDisciplina.getCodeName());
        }

        ArrayList<String> codeNames = novaDisciplina.getPreRequisito();
        ArrayList<Disciplina> preRequisitos = new ArrayList<>();

        if (codeNames.size() > 0) {
            for (String codeName : codeNames) {
                if (disciplinaRepository.findByName(codeName) != null) {
                    Disciplina disc = disciplinaRepository.findByName(codeName);
                    preRequisitos.add(disc);
                } else {
                    throw new PreRequisitoInexistenteException();
                }
            }
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setEmenta(novaDisciplina.getEmenta());
        disciplina.setNome(novaDisciplina.getNome());
        disciplina.setCargaHoraria(novaDisciplina.getCargaHoraria());
        disciplina.setCodeName(novaDisciplina.getCodeName());
        disciplina.setPreRequisito(preRequisitos);
        disciplina.setAulaSemanais(novaDisciplina.getAulaSemanais());

        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }
}
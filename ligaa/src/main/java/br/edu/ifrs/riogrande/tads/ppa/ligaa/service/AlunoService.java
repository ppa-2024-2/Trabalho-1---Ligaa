package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;
//new AlunoSevice();

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
// import java.time.LocalDateTime;
// import java.util.UUID;
import java.util.List;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoRepository;

@Service // Qualificando o objeto como um serviço
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void cadastrarAluno(NovoAluno novoAluno) {

        if (alunoRepository.cpfExists(novoAluno.getCpf())) {
            throw new IllegalStateException("Cpf já existe: " + novoAluno.getCpf());
        }

        // Onde ficam as regras de domínio
        Aluno aluno = new Aluno();

        // BeanUtils.copyProperties(novoAluno, aluno); // Para copiar de um para o outro
        // mas tendo os mesmos campos;

        aluno.setCpf(novoAluno.getCpf());
        aluno.setNome(novoAluno.getNome());
        aluno.setLogin(novoAluno.getEmail());
        aluno.setEmail(novoAluno.getEmail());

        // LocalDateTime agora = LocalDateTime.now();

        // aluno.setDataHoraCriacao(agora);
        // aluno.setDataHoraAlteracao(agora);

        // aluno.setDesativado(false);
        // aluno.setId(UUID.randomUUID());//Foi para o Repository

        // Padrões de abstração de Persistência:
        // - Active Record (Registro Ativo): O próprio objeto representa um registro e
        // lida com a sua percistência;
        // - Repository (Repositório - "Daozinho" - Data Acess Object): um container
        // representa o objeto persistente como estiveesse na memória;

        // Active Record (objeto se salva, uma instância de aluno é ao mesmo tempo um
        // registro no Banco)
        // aluno.save();

        // DAO
        // AlunoDAO dao=new alunoDAO();
        // dao.save(aluno);
        // Aluno a = dao.findByCpf("123457676");

        alunoRepository.save(aluno);
    }

    public Aluno buscarAluno(@NonNull String cpf) {
        // return Aluno.buscaCpf(cpf).orElseThrow(() -> new NullPointerException("Aluno
        // não Encontrado"));

        // Aluno a = new Aluno();
        // a.setCpf(cpf);
        // a.load();

        // return new Aluno();

        return alunoRepository.findByCpf(cpf);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
}
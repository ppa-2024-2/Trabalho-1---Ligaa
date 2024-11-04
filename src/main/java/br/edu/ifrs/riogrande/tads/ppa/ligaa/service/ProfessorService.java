package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorRepository;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void cadastrarProfessor(NovoProfessor novoProfessor) {

        if (professorRepository.siapeExists(novoProfessor.getSiape())) {
            throw new IllegalStateException("SIAPE já existe: " + novoProfessor.getSiape());
        }

        Professor professor = new Professor();

        professor.setNome(novoProfessor.getNome());
        professor.setSiape(novoProfessor.getSiape());
        professor.setFormacao(novoProfessor.getFormacao());

        professorRepository.save(professor);
    }
}
package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;

@Repository
public class ProfessorRepository implements IRepository<Professor> {

    private Map<UUID, Professor> mapa = new HashMap<>();

    @Override
    public Professor save(Professor professor) {
        LocalDateTime agora = LocalDateTime.now();

        if (professor.getId() == null) {// não é persistente
            professor.setId(UUID.randomUUID()); // Atribuir um ID
            professor.setDataHoraCriacao(agora);
            professor.setDesativado(false);
        }

        if (professor.isDesativado() || (mapa.containsKey(
                professor.getId()) && mapa.get(professor.getId()).isDesativado())) {
            // bloquear
            throw new EntidadeInativadaException();
        }

        professor.setDataHoraAlteracao(agora);

        mapa.put(professor.getId(), professor);
        return professor;
    }

    public boolean siapeExists(String siape) {
        // anyMach => qualquer um coincide o CPF?
        return mapa.values().stream().anyMatch(professor -> siape.equals(professor.getSiape()));
    }

    @Override
    public boolean delete(Professor entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Professor> findAll() {
        return new ArrayList<Professor>(mapa.values());
    }
}
package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;

@Repository
public class DisciplinaRepository implements IRepository<Disciplina> {
    private Map<UUID, Disciplina> mapa = new HashMap<>();

    @Override
    public Disciplina save(Disciplina disciplina) {
        LocalDateTime agora = LocalDateTime.now();

        if (disciplina.getId() == null) {
            disciplina.setId(UUID.randomUUID());
            disciplina.setDataHoraCriacao(agora);
            disciplina.setDesativado(false);
        }

        if (disciplina.isDesativado()
                || (mapa.containsKey(disciplina.getId()) && mapa.get(disciplina.getId()).isDesativado())) {
            // bloquear
            throw new EntidadeInativadaException();
        }

        disciplina.setDataHoraAlteracao(agora);

        mapa.put(disciplina.getId(), disciplina);
        return disciplina;
    }

    @Override
    public List<Disciplina> findAll() {
        return new ArrayList<Disciplina>(mapa.values());
    }

    public Disciplina findByName(String codeNome) {
        return mapa.values().stream().filter(d -> d.getCodeName().equals(codeNome)).findFirst().orElse(null);
    }

    public boolean codeNameExists(String codeName) {
        return mapa.values().stream().anyMatch(disciplina -> codeName.equals(disciplina.getCodeName()));
    }

    @Override
    public boolean delete(Disciplina entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
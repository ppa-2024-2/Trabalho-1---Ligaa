package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Turma;

@Repository
public class TurmaRepository implements IRepository<Turma> {

    private Map<UUID, Turma> mapa = new HashMap<>();

    @Override
    public Turma save(Turma turma) {
        LocalDateTime agora = LocalDateTime.now();

        // ID (lógica da infraestrutura e não do domínio)
        if (turma.getId() == null) {// não é persistente
            turma.setId(UUID.randomUUID()); // Atribuir um ID
            turma.setDataHoraCriacao(agora);
            turma.setDesativado(false);
        }

        if (turma.isDesativado() || (mapa.containsKey(turma.getId()) && mapa.get(turma.getId()).isDesativado())) {
            // bloquear
            throw new EntidadeInativadaException();
        }

        turma.setDataHoraAlteracao(agora);

        mapa.put(turma.getId(), turma);
        return turma;
    }

    @Override
    public boolean delete(Turma entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Turma> findAll() {
        return new ArrayList<Turma>(mapa.values());
    }

    public Turma findByName(String codeNome) {
        return mapa.values().stream().filter(t -> t.getCodeName().equals(codeNome)).findFirst().orElse(null);
    }

    public boolean codeNameExists(String codeName) {
        return mapa.values().stream().anyMatch(turma -> codeName.equals(turma.getCodeName()));
    }
}

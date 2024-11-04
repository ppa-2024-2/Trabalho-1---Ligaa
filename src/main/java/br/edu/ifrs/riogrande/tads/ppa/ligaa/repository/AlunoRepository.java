package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;

@Repository
public class AlunoRepository implements IRepository<Aluno> {

    private Map<UUID, Aluno> mapa = new HashMap<>();

    @Override
    public Aluno save(Aluno aluno) {
        LocalDateTime agora = LocalDateTime.now();

        // ID (lógica da infraestrutura e não do domínio)
        if (aluno.getId() == null) {// não é persistente
            aluno.setId(UUID.randomUUID()); // Atribuir um ID
            aluno.setDataHoraCriacao(agora);
            aluno.setDesativado(false);
        }

        if (aluno.isDesativado() || (mapa.containsKey(aluno.getId()) && mapa.get(aluno.getId()).isDesativado())) {
            // bloquear
            throw new EntidadeInativadaException();
        }

        aluno.setDataHoraAlteracao(agora);

        mapa.put(aluno.getId(), aluno);
        return aluno;
    }

    public boolean cpfExists(String cpf) {
        // anyMach => qualquer um coincide o CPF?
        return mapa.values().stream().anyMatch(aluno -> cpf.equals(aluno.getCpf()));
    }

    @Override
    public boolean delete(Aluno entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Aluno> findAll() {
        return new ArrayList<Aluno>(mapa.values());
    }
}
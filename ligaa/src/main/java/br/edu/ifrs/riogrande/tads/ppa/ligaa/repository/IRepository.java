package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.util.List;

public interface IRepository<ENTIDADE> { // Generics

    public ENTIDADE save(ENTIDADE entidade);

    /**
     * Exclui uma determinada Entidade;
     * 
     * @param e a Entidade aser excluída
     * @return true se foi excluída e false caso não
     */

    public boolean delete(ENTIDADE entidade);

    public List<ENTIDADE> findAll();
}
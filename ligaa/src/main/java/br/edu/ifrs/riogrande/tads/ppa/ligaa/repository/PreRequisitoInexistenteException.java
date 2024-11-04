package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class PreRequisitoInexistenteException extends RuntimeException {

    public PreRequisitoInexistenteException() {
        super("A disciplina de pré requisito não foi encontrada");
    }
}
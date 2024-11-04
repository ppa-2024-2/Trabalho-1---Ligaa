package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class EntidadeInativadaException extends RuntimeException {

    public EntidadeInativadaException() {
        super("A entidade não pode ser operacionalizada porque está inativa");
    }
}
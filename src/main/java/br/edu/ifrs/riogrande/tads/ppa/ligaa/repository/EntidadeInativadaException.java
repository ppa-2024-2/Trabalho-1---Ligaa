package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class EntidadeInativadaException extends RuntimeException {

    public EntidadeInativadaException() {
        super("A entidade não podeser operacionalizada porue está inativa");
    }
}
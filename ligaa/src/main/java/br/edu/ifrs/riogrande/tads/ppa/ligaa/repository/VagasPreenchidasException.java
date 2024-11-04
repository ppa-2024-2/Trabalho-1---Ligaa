package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class VagasPreenchidasException extends RuntimeException {

    public VagasPreenchidasException() {
        super("A turma não tem mais vagas para novos alunos");
    }
}
package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class AlunoAprovadoException extends RuntimeException {

    public AlunoAprovadoException() {
        super("O Aluno não pode se matricular nessa 'Turma', pois já foi aprovado anteriormente");
    }
}

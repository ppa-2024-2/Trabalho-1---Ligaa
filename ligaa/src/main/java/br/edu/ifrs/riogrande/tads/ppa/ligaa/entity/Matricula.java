package br.edu.ifrs.riogrande.tads.ppa.ligaa.entity;

public class Matricula {
    private boolean estaAprovado;
    private Aluno aluno;
    private String numero;

    public boolean isEstaAprovado() {
        return estaAprovado;
    }

    public void setEstaAprovado(boolean estaAprovado) {
        this.estaAprovado = estaAprovado;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Matricula [estaAprovado=" + estaAprovado + ", aluno=" + aluno + ", numero=" + numero + "]";
    }
}
package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import java.util.ArrayList;

public class NovaDisciplina {

    private String nome;
    private String ementa;
    private int cargaHoraria;
    private ArrayList<String> preRequisito;
    private int aulaSemanais;
    private String codeName;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<String> getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(ArrayList<String> preRequisito) {
        this.preRequisito = preRequisito;
    }

    public int getAulaSemanais() {
        return aulaSemanais;
    }

    public void setAulaSemanais(int aulaSemanais) {
        this.aulaSemanais = aulaSemanais;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public String toString() {
        return "NovaDisciplina [nome=" + nome + ", ementa=" + ementa + ", cargaHoraria=" + cargaHoraria
                + ", preRequisito=" + preRequisito + ", aulaSemanais=" + aulaSemanais + ", codeName=" + codeName + "]";
    }
}
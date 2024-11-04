package br.edu.ifrs.riogrande.tads.ppa.ligaa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Disciplina {

    private String nome;
    private String ementa;
    private int cargaHoraria;
    private ArrayList<Disciplina> preRequisito;
    private int aulaSemanais;
    private String codeName;

    // Campos de controle
    private UUID id;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private boolean desativado; // false

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

    public ArrayList<Disciplina> getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(ArrayList<Disciplina> preRequisito) {
        this.preRequisito = preRequisito;
    }

    public int getAulaSemanais() {
        return aulaSemanais;
    }

    public void setAulaSemanais(int aulaSemanais) {
        this.aulaSemanais = aulaSemanais;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public boolean isDesativado() {
        return desativado;
    }

    public void setDesativado(boolean desativado) {
        this.desativado = desativado;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public String toString() {
        return "Disciplina [nome=" + nome + ", ementa=" + ementa + ", cargaHoraria=" + cargaHoraria + ", preRequisito="
                + preRequisito + ", aulaSemanais=" + aulaSemanais + ", codeName=" + codeName + ", id=" + id
                + ", dataHoraCriacao=" + dataHoraCriacao + ", dataHoraAlteracao=" + dataHoraAlteracao + ", desativado="
                + desativado + "]";
    }
}
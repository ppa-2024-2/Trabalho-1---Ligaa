package br.edu.ifrs.riogrande.tads.ppa.ligaa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Turma {
    private String codeName;
    private Disciplina disciplina;
    private Professor professor;
    private String semestre;
    private String sala;
    private int vagas;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;
    private ArrayList<Matricula> matriculados;

    private UUID id;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private boolean desativado; // false

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public ArrayList<Matricula> getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(ArrayList<Matricula> matriculados) {
        this.matriculados = matriculados;
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

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    @Override
    public String toString() {
        return "Turma [codeName=" + codeName + ", disciplina=" + disciplina + ", professor=" + professor + ", semestre="
                + semestre + ", sala=" + sala + ", vagas=" + vagas + ", diaSemana=" + diaSemana + ", horaInicio="
                + horaInicio + ", horaFim=" + horaFim + ", matriculados=" + matriculados + ", id=" + id
                + ", dataHoraCriacao=" + dataHoraCriacao + ", dataHoraAlteracao=" + dataHoraAlteracao + ", desativado="
                + desativado + "]";
    }
}
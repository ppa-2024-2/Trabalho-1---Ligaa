package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

public class NovaTurma {
    private String codeName;
    private String disciplinaCodeName;
    private String siape;
    private String semestre;
    private String sala;
    private int vagas;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getDisciplinaCodeName() {
        return disciplinaCodeName;
    }

    public void setDisciplinaCodeName(String disciplinaCodeName) {
        this.disciplinaCodeName = disciplinaCodeName;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
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

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    @Override
    public String toString() {
        return "NovaTurma [codeName=" + codeName + ", disciplinaCodeName=" + disciplinaCodeName + ", siape=" + siape
                + ", semestre=" + semestre + ", sala=" + sala + ", vagas=" + vagas + ", diaSemana=" + diaSemana
                + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + "]";
    }
}
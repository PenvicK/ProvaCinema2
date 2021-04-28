package com.cienema.ProvaCinema.model;

import java.sql.Time;
import java.sql.Date;

public class Sessao {
    private int idSessao;
    private Date dataSessao;
    private Time horario;
    private Filme filme;
    private Sala sala;
    private double valorIngresso;

    public Sessao(int idSessao, Date dataSessao, Time horario, Filme filme, Sala sala, double valorIngresso){
        this.setIdSessao(idSessao);
        this.setDataSessao(dataSessao);
        this.setHorario(horario);
        this.setFilme(filme);
        this.setSala(sala);
        this.setValorIngresso(valorIngresso);

    }

    public Sessao(){

    }

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public Date getDataSessao() {
        return dataSessao;
    }

    public void setDataSessao(Date dataSessao) {
        this.dataSessao = dataSessao;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }
}

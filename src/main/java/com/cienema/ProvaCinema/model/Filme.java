package com.cienema.ProvaCinema.model;

import java.sql.Time;

public class Filme {
    private int idFilme;
    private String nome;
    private String genero;
    private String idadePermitida;
    private String idioma;
    private Time duracao;
    private String descricao;

    public Filme(int idFilme, String nome, String genero, String idadePermitida, String idioma, Time duracao, String descricao){
        this.setIdFilme(idFilme);
        this.setNome(nome);
        this.setGenero(genero);
        this.setIdadePermitida(idadePermitida);
        this.setIdioma(idioma);
        this.setDuracao(duracao);
        this.setDescricao(descricao);
    }

    public Filme(){

    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdadePermitida() {
        return idadePermitida;
    }

    public void setIdadePermitida(String idadePermitida) {
        this.idadePermitida = idadePermitida;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

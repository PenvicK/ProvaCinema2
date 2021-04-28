package com.cienema.ProvaCinema.model;

public class Sala {
    private int idSala;
    private int sala;
    private int capacidade;

    public Sala(int idSala, int sala, int capacidade){
        this.setIdSala(idSala);
        this.setSala(sala);
        this.setCapacidade(capacidade);
    }

    public Sala(){

    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}

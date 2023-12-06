package com.example.projetofinal.Modelo;

public class Aparelho {
    private int id;
    private String nome;
    private String modelo;
    private String marca;
    private String numeroSerie;

    public Aparelho() {
    }

    public Aparelho( String nome, String modelo, String marca, String numeroSerie) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Aparelho{" +

                ", nome='" + nome + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                '}';
    }
}
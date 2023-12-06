package com.example.projetofinal.Modelo;

public class Servico {
    private  int id;
    private String nome;
    private String descricao;
    private String valor;

    public Servico(int id, String nome, String descricao, String valor) {
        this.id= id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Servico() {

    }

    // Métodos setters para os atributos
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    // Métodos getters podem ser implementados se necessário
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Servico{" +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

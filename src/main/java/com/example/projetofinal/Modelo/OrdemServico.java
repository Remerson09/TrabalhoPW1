package com.example.projetofinal.Modelo;

public class OrdemServico {
    private int id_cliente;
    private String nomecliente;
    private String dataEntrada;
    private String dateSaida;
    private Double valorTotal;
    private String descServico;

    public OrdemServico(int id_cliente, String nomecliente, String dataEntrada, String dateSaida, Double valorTotal, String descServico) {
        this.id_cliente = id_cliente;
        this.nomecliente = nomecliente;
        this.dataEntrada = dataEntrada;
        this.dateSaida = dateSaida;
        this.valorTotal = valorTotal;
        this.descServico = descServico;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDateSaida() {
        return dateSaida;
    }

    public void setDateSaida(String dateSaida) {
        this.dateSaida = dateSaida;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescServico() {
        return descServico;
    }

    public void setDescServico(String descServico) {
        this.descServico = descServico;
    }

    @Override
    public String toString() {
        return "OrdemServico{" +
                "id_cliente=" + id_cliente +
                ", nomecliente='" + nomecliente + '\'' +
                ", dataEntrada='" + dataEntrada + '\'' +
                ", dateSaida='" + dateSaida + '\'' +
                ", valorTotal=" + valorTotal +
                ", descServico='" + descServico + '\'' +
                '}';
    }
}

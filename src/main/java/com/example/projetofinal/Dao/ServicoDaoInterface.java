package com.example.projetofinal.Dao;

import com.example.projetofinal.Modelo.Servico;

import java.util.Set;

public interface ServicoDaoInterface extends AutoCloseable{
    void inserir(Servico servico) throws ErroDao;
    void editar(Servico servico) throws ErroDao;

    boolean verificarIdExistente(int id);

    int gerarNovoId();

    Set<Servico> buscarTodos() throws ErroDao;


    void deletar(int id) throws ErroDao;
}

package com.example.projetofinal.Dao;

import com.example.projetofinal.Modelo.Cliente;

import java.util.List;
import java.util.Set;

public interface ClienteDaoInterface extends AutoCloseable {
    void inserir(Cliente cliente) throws Exception;
    void editar(Cliente cliente) throws Exception;
    void deletar(Cliente cliente) throws Exception;
    Cliente buscarPorId(int id) throws Exception;
    Set<Cliente> buscarTodos() throws Exception;
}

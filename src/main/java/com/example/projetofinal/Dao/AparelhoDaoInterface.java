package com.example.projetofinal.Dao;

import com.example.projetofinal.Modelo.Aparelho;
import com.example.projetofinal.Modelo.Cliente;

import java.sql.SQLException;
import java.util.Set;

public interface AparelhoDaoInterface extends AutoCloseable{
    void inserir(Aparelho aparelho) throws Exception;

    boolean verificarIdExistente(int id) throws SQLException;

    void editar(Aparelho aparelho) throws Exception;
    void deletar(Aparelho aparelho) throws Exception;
    Aparelho buscarPorId(int id) throws Exception;
    Set<Aparelho> buscarTodos() throws Exception;
}

package com.example.projetofinal.Dao;

import com.example.projetofinal.Modelo.Cliente;
import com.example.projetofinal.Modelo.Usuario;

import java.util.List;

public interface UsuarioDaoInterface extends  AutoCloseable{

    void inserir(Usuario usuario) throws Exception;

    Usuario buscarPorLogin(String login) throws ErroDao;

    Usuario buscarPorId(int id) throws ErroDao;

}
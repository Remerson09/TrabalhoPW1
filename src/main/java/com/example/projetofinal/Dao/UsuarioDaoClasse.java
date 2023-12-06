package com.example.projetofinal.Dao;

import com.example.projetofinal.Modelo.Cliente;
import com.example.projetofinal.Modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoClasse implements  UsuarioDaoInterface{
private Connection con;
   public  UsuarioDaoClasse() throws ErroDao{
       con= FabricaConexao.pegaConexao();
   }

    public void inserir(Usuario usuario) throws Exception {
        String query = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate o erro conforme necessário, como lançar uma exceção personalizada ou logar o erro
        }
    }

    @Override
    public Usuario buscar(String login, String senha) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, login);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Se o usuário existir, cria um objeto Usuario com os dados do ResultSet
                    usuario = new Usuario(rs.getString("login"), rs.getString("senha"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate o erro conforme necessário, como lançar uma exceção personalizada ou logar o erro
        }

        return usuario;
    }

    @Override
    public Usuario buscarPorLogin(String login) {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE login = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, login);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Se o usuário com o login fornecido existir, cria um objeto Usuario com os dados do ResultSet
                    usuario = new Usuario(rs.getString("login"), rs.getString("senha"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate o erro conforme necessário, como lançar uma exceção personalizada ou logar o erro
        }

        return usuario;
    }


    @Override
    public void close() throws Exception {

    }


}
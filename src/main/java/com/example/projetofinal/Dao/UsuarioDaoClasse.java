package com.example.projetofinal.Dao;


import com.example.projetofinal.Modelo.Usuario;

import java.sql.*;


public class UsuarioDaoClasse implements  UsuarioDaoInterface{
private Connection con;
   public  UsuarioDaoClasse() throws ErroDao{
       con= FabricaConexao.pegaConexao();
   }

    public void inserir(Usuario usuario) throws ErroDao {
        String query = "INSERT INTO usuarios (nome, login, senha) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.executeUpdate();

            // Obtendo o ID gerado pelo banco de dados
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    usuario.setId(id); // Definir o ID gerado no objeto Usuario
                }
            }
        } catch (SQLException e) {
            throw new ErroDao("Erro ao inserir usuário no banco de dados", e);
        }
    }

    @Override
    public Usuario buscarPorLogin(String login) throws ErroDao {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE login = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, login);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("login"),
                            rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {
            throw new ErroDao("Erro ao buscar usuário por login no banco de dados", e);
        }

        return usuario;
    }

    public Usuario buscarPorId(int id) throws ErroDao {
        Usuario usuario = null;
        String query = "SELECT * FROM usuarios WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("login"),
                            rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {
            throw new ErroDao("Erro ao buscar usuário por ID no banco de dados", e);
        }

        return usuario;
    }

    @Override
    public void close() throws Exception {

    }


}
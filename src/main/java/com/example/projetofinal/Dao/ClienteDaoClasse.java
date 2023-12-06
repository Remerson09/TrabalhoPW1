package com.example.projetofinal.Dao;



import com.example.projetofinal.Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ClienteDaoClasse implements ClienteDaoInterface{
    private Connection con;

    public ClienteDaoClasse() throws ErroDao {
        con = FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(Cliente cliente) throws Exception {
        try {
            PreparedStatement stm = con.prepareStatement(
                    "INSERT INTO cliente (nome, endereco, telefone) VALUES (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getEndereco());
            stm.setString(3, cliente.getTelefone());

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Inserção falhou, nenhum registro foi adicionado.");
            }

            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                cliente.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Falha ao obter ID gerado para o cliente.");
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }



    @Override
    public void deletar(Cliente cliente) throws Exception {
        try {
            String sql = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            int rowsDeleted = stmt.executeUpdate();
            stmt.close();

            if (rowsDeleted > 0) {
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Nenhum cliente foi deletado. Verifique se o ID é válido.");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao deletar cliente no banco de dados: " + e.getMessage());
        }
    }
    @Override
    public Cliente buscarPorId(int id) throws Exception {
        try {
            String sql = "SELECT * FROM cliente WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Cliente cliente = null;
            if (rs.next()) {
                cliente = new Cliente(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
            }

            rs.close();
            stmt.close();
            return cliente;
        } catch (Exception e) {
            throw new Exception("Erro ao buscar cliente por ID no banco de dados: " + e.getMessage());
        }
    }

    @Override
    public Set<Cliente> buscarTodos() throws Exception {
        Set<Cliente> clientes = new HashSet<>();

        try (PreparedStatement stm = con.prepareStatement("SELECT * FROM cliente");
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");

                Cliente cliente = new Cliente(id);
                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setTelefone(telefone);

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }

        return clientes;
    }

    @Override
    public void editar(Cliente cliente) throws Exception {
        try {
            String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId());
            int rowsUpdated = stmt.executeUpdate();
            stmt.close();

            if (rowsUpdated == 0) {
                throw new SQLException("Falha ao editar o cliente. Nenhum registro atualizado.");
            }

            System.out.println("Cliente editado com sucesso!");
        } catch (SQLException e) {
            throw new Exception("Erro ao editar cliente no banco de dados: " + e.getMessage());
        }
    }
    @Override
    public void close() throws Exception {
        if (con != null) {
            con.close();
        }
    }
}


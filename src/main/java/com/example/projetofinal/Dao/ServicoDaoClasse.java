package com.example.projetofinal.Dao;

import com.example.projetofinal.Modelo.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ServicoDaoClasse implements ServicoDaoInterface{
    private Connection con;
    public ServicoDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }

    @Override
    public void close() throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
            System.out.println("Conexão fechada com sucesso!");
        }
    }

    @Override
    public void inserir(Servico servico) throws ErroDao {
        try {
            if (!verificarIdExistente(servico.getId())) {
                PreparedStatement stm = con.prepareStatement(
                        "INSERT INTO servico (id, nome, descricao, valor) VALUES (?, ?, ?, ?)"
                );
                stm.setInt(1, servico.getId());
                stm.setString(2, servico.getNome());
                stm.setString(3, servico.getDescricao());
                stm.setString(4, servico.getValor());

                stm.executeUpdate();
            } else {
                throw new ErroDao("ID já existente: " + servico.getId());
            }
        } catch (SQLException e) {
            throw new ErroDao("Erro ao inserir serviço: " + e.getMessage());
        }
    }
    @Override
    public void editar(Servico servico) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE servico SET nome=?, descricao=?, valor=? WHERE id=?");
            stm.setString(1, servico.getNome());
            stm.setString(2, servico.getDescricao());
            stm.setString(3, servico.getValor());
            stm.setInt(4, servico.getId());

            int linhasAfetadas = stm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao editar o serviço. Nenhuma linha afetada para o ID: " + servico.getId());
            }
        } catch (SQLException e) {
            throw new ErroDao("Erro ao editar o serviço: " + e.getMessage());
        }
    }

    @Override
    public boolean verificarIdExistente(int id) {
        try {
            PreparedStatement stm = con.prepareStatement("SELECT COUNT(*) FROM servico WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Se o count for maior que zero, o ID existe
            }
        } catch (SQLException e) {
            // Trate a exceção de acordo com a lógica do seu aplicativo
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int gerarNovoId() {
        try {
            PreparedStatement stm = con.prepareStatement("SELECT MAX(id) FROM servico");
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt(1);
                return maxId + 1; // Gere um novo ID incrementando o máximo existente
            }
        } catch (SQLException e) {
            // Trate a exceção de acordo com a lógica do seu aplicativo
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public Set<Servico> buscarTodos() throws ErroDao {
        Set<Servico> servicos = new HashSet<>();

        try (PreparedStatement stm = con.prepareStatement("SELECT * FROM servico");
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String valor = rs.getString("valor");

                Servico servico = new Servico(id, nome, descricao, valor);
                servicos.add(servico);
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }

        return servicos;
    }

    @Override
    public void deletar(int id) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement("DELETE FROM servico WHERE id = ?");
            stm.setInt(1, id);

            int linhasAfetadas = stm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao deletar o serviço.");
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
}

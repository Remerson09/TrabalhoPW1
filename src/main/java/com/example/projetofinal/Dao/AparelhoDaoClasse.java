package com.example.projetofinal.Dao;

import com.example.projetofinal.Modelo.Aparelho;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AparelhoDaoClasse implements AparelhoDaoInterface {

    private Connection con;
    public AparelhoDaoClasse() throws ErroDao {
        con = FabricaConexao.pegaConexao();
    }
    @Override
    public void close() throws Exception {

    }

    @Override
    public void inserir(Aparelho aparelho) throws SQLException, ErroDao {
        try {
            if (!verificarIdExistente(aparelho.getId())) {
                PreparedStatement statement = con.prepareStatement(
                        "INSERT INTO aparelhos (nome, modelo, marca, numero_serie) VALUES (?, ?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);

                statement.setString(1, aparelho.getNome());
                statement.setString(2, aparelho.getModelo());
                statement.setString(3, aparelho.getMarca());
                statement.setString(4, aparelho.getNumeroSerie());

                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    aparelho.setId(id);
                }
            } else {
                throw new ErroDao("ID já existente: " + aparelho.getId());
            }
        } catch (SQLException | ErroDao e) {
            throw new ErroDao("Erro ao inserir aparelho: " + e.getMessage());
        }
    }

    @Override
    public boolean verificarIdExistente(int id) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement("SELECT COUNT(*) FROM aparelhos WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Se o count for maior que zero, o ID existe
            }
        }
        return false;
    }

    @Override
    public void editar(Aparelho aparelho) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(
                "UPDATE aparelhos SET nome=?, modelo=?, marca=?, numero_serie=? WHERE id=?")) {

            statement.setString(1, aparelho.getNome());
            statement.setString(2, aparelho.getModelo());
            statement.setString(3, aparelho.getMarca());
            statement.setString(4, aparelho.getNumeroSerie());
            statement.setInt(5, aparelho.getId());

            statement.executeUpdate();
        }
    }

    @Override
    public void deletar(Aparelho aparelho) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(
                "DELETE FROM aparelhos WHERE id = ?")) {

            statement.setInt(1, aparelho.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public Aparelho buscarPorId(int id) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(
                "SELECT * FROM aparelhos WHERE id = ?")) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Aparelho aparelho = new Aparelho(
                        resultSet.getString("nome"),
                        resultSet.getString("modelo"),
                        resultSet.getString("marca"),
                        resultSet.getString("numero_serie"));

                aparelho.setId(resultSet.getInt("id"));
                return aparelho;
            }
        }
        return null;
    }

    @Override
    public Set<Aparelho> buscarTodos() throws SQLException {
        Set<Aparelho> aparelhos = new HashSet<>();
        try (PreparedStatement statement = con.prepareStatement("SELECT * FROM aparelhos")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Aparelho aparelho = new Aparelho(

                        resultSet.getString("nome"),
                        resultSet.getString("modelo"),
                        resultSet.getString("marca"),
                        resultSet.getString("numero_serie"));

                aparelho.setId(resultSet.getInt("id"));
                aparelhos.add(aparelho);
            }
        }
        return aparelhos;
    }
}
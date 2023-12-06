package com.example.projetofinal.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    public static Connection pegaConexao() throws ErroDao{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false","root","aluno");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ErroDao(e);
        }
    }
}

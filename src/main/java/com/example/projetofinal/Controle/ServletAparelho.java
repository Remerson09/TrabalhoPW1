package com.example.projetofinal.Controle;


import com.example.projetofinal.Dao.AparelhoDaoClasse;
import com.example.projetofinal.Dao.ErroDao;
import com.example.projetofinal.Modelo.Aparelho;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/aparelho")
public class ServletAparelho extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String modelo = request.getParameter("modelo");
        String marca = request.getParameter("marca");
        String numeroSerie = request.getParameter("numeroSerie");

        Aparelho aparelho = new Aparelho(nome, modelo, marca, numeroSerie);

        try {
            AparelhoDaoClasse dao = new AparelhoDaoClasse();
            dao.inserir(aparelho); // Insere o aparelho no banco
            response.sendRedirect("listaaparelho.jsp");
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
            // Tratar o erro de acordo com sua necessidade
        }
    }
}
package com.example.projetofinal.Controle;

import com.example.projetofinal.Dao.AparelhoDaoClasse;
import com.example.projetofinal.Dao.AparelhoDaoInterface;
import com.example.projetofinal.Modelo.Aparelho;
import com.example.projetofinal.Util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deletaraparelho")
public class DeletarAparelho extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String aparelhoIdParam = request.getParameter("aparelhoId");

            if (Validador.temConteudo(aparelhoIdParam)) {
                int aparelhoId = Integer.parseInt(aparelhoIdParam);
                AparelhoDaoInterface dao = new AparelhoDaoClasse();
                Aparelho aparelho = dao.buscarPorId(aparelhoId);

                if (aparelho != null) {
                    dao.deletar(aparelho);
                    response.sendRedirect("listaaparelho?mensagem=Deletado-sucesso");
                } else {
                    response.sendRedirect("erro.jsp?mensagem=AparelhoNaoEncontrado");
                }
            } else {
                response.sendRedirect("listaaparelho?mensagem=DadosIncompletos");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("listaaparelho?mensagem=ErroGeral");
        }
    }
}
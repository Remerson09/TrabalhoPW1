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

@WebServlet("/editaraparelho")
public class EditarAparelho extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String aparelhoIdParam = request.getParameter("aparelhoId");
            String novoNome = request.getParameter("nome");
            String novoModelo = request.getParameter("modelo");
            String novaMarca = request.getParameter("marca");
            String novoNumeroSerie = request.getParameter("numeroSerie");

            if (Validador.temConteudo(aparelhoIdParam) && Validador.temConteudo(novoNome) &&
                    Validador.temConteudo(novoModelo) && Validador.temConteudo(novaMarca) &&
                    Validador.temConteudo(novoNumeroSerie)) {

                int aparelhoId = Integer.parseInt(aparelhoIdParam);
                AparelhoDaoInterface dao = new AparelhoDaoClasse();
                Aparelho aparelho = dao.buscarPorId(aparelhoId);

                if (aparelho != null) {
                    aparelho.setNome(novoNome);
                    aparelho.setModelo(novoModelo);
                    aparelho.setMarca(novaMarca);
                    aparelho.setNumeroSerie(novoNumeroSerie);

                    dao.editar(aparelho);

                    response.sendRedirect("listaaparelho?mensagem=Editado-sucesso");
                } else {
                    response.sendRedirect("erro.jsp?mensagem=AparelhoNaoEncontrado");
                }
            } else {
                response.sendRedirect("editaraparelho.jsp?mensagem=DadosIncompletos");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("editaraparelho.jsp?mensagem=ErroGeral");
        }
    }
}
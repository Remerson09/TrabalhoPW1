package com.example.projetofinal.Controle;


import com.example.projetofinal.Dao.ErroDao;
import com.example.projetofinal.Dao.ServicoDaoClasse;
import com.example.projetofinal.Dao.ServicoDaoInterface;
import com.example.projetofinal.Modelo.Servico;
import com.example.projetofinal.Util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editarservico")
public class EditarServico extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servicoId = request.getParameter("servicoId");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");

        if (Validador.temConteudo(servicoId) && Validador.temConteudo(nome) && Validador.temConteudo(descricao) && Validador.temConteudo(valor)) {
            ServicoDaoInterface dao = null;
            try {
                dao = new ServicoDaoClasse();
                int id = Integer.parseInt(servicoId);
                Servico servico = new Servico(id, nome, descricao, valor);
                dao.editar(servico);
                response.sendRedirect("listaservico?mensagem=Servico_Atualizado");
            } catch (NumberFormatException | ErroDao e) {
                response.sendRedirect("pagina_de_erro.jsp?mensagem=" + e.getMessage());
            } finally {
                if (dao != null) {
                    try {
                        dao.close();
                    } catch (Exception ignored) {
                    }
                }
            }
        } else {
            response.sendRedirect("pagina_de_erro.jsp?mensagem=Dados_Invalidos");
        }
    }
}
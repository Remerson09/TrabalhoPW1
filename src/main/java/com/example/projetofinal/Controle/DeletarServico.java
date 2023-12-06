package com.example.projetofinal.Controle;


import com.example.projetofinal.Dao.ErroDao;
import com.example.projetofinal.Dao.ServicoDaoClasse;
import com.example.projetofinal.Dao.ServicoDaoInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deletarservico")
public class DeletarServico extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servicoId = request.getParameter("id");
        if (servicoId != null && !servicoId.isEmpty()) {
            int id = Integer.parseInt(servicoId);

            ServicoDaoInterface dao = null;
            try {
                dao = new ServicoDaoClasse();
                dao.deletar(id);

                response.sendRedirect("listaservico?mensagem=Servico_Deletado");
                // Redireciona para a página de sucesso após a exclusão do serviço
            } catch (ErroDao e) {
                e.printStackTrace(); // Ajuste conforme tratamento de erro desejado
                response.sendRedirect("pagina_de_erro.jsp?mensagem=" + e.getMessage());
                // Redireciona para uma página de erro em caso de falha
            } finally {
                if (dao != null) {
                    try {
                        dao.close(); // Fecha a conexão se estiver aberta
                    } catch (Exception ignored) {
                        // Lida com o erro de fechamento da conexão
                    }
                }
            }
        } else {
            response.sendRedirect("pagina_de_erro.jsp?mensagem=ID_Nao_Fornecido");
            // Redireciona para uma página informando que o ID não foi fornecido
        }
    }
}
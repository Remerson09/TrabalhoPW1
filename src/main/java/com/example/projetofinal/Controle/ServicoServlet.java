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

@WebServlet("/servico")
public class ServicoServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String idString = request.getParameter("id");
        int id = (idString != null && !idString.isEmpty()) ? Integer.parseInt(idString) : 0;
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");

        if (Validador.temConteudo(nome) && Validador.temConteudo(descricao) && Validador.temConteudo(valor)) {
            try (ServicoDaoInterface dao = new ServicoDaoClasse()) {
                if (id != 0 && dao.verificarIdExistente(id)) {
                    id = dao.gerarNovoId();
                }

                Servico servico = new Servico(id, nome, descricao, valor);
                dao.inserir(servico);

                response.sendRedirect("listaservico?mensagem=servico_cadastrado");
            } catch (ErroDao e) {
                response.sendRedirect("pagina_erro.jsp?mensagem=erro_bd");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            response.sendRedirect("pagina_erro.jsp?mensagem=falta_parametros");
        }
    }
}

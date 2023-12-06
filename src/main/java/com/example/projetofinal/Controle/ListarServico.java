package com.example.projetofinal.Controle;


import com.example.projetofinal.Dao.ErroDao;
import com.example.projetofinal.Dao.ServicoDaoClasse;
import com.example.projetofinal.Dao.ServicoDaoInterface;
import com.example.projetofinal.Modelo.Servico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet("/listaservico")
public class ListarServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (ServicoDaoInterface dao = new ServicoDaoClasse()) {
            Set<Servico> servicos = dao.buscarTodos();
            request.setAttribute("servicos", servicos);
            request.getRequestDispatcher("/listaservico.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("pagina_erro.jsp?mensagem=erro_ao_listar_servicos");
        }
    }
}
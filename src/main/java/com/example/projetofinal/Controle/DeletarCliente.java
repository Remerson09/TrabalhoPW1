package com.example.projetofinal.Controle;


import com.example.projetofinal.Dao.ClienteDaoClasse;
import com.example.projetofinal.Dao.ClienteDaoInterface;
import com.example.projetofinal.Dao.ErroDao;
import com.example.projetofinal.Modelo.Cliente;
import com.example.projetofinal.Util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Set;

@WebServlet("/deletarcliente")
public class DeletarCliente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clienteIdParam = request.getParameter("clienteId");

        if (clienteIdParam != null && !clienteIdParam.isEmpty()) {
            try {
                int clienteId = Integer.parseInt(clienteIdParam);
                ClienteDaoInterface dao = new ClienteDaoClasse();
                Cliente cliente = dao.buscarPorId(clienteId);
                if (cliente != null) {
                    dao.deletar(cliente);
                    response.sendRedirect("listarcliente?mensagem=Cliente-deletado-sucesso");
                } else {
                    response.sendRedirect("erro.jsp?mensagem=ClienteNaoEncontrado");
                }
            } catch (Exception e) {
                throw new ServletException("Erro ao deletar o cliente", e);
            }
        } else {
            response.sendRedirect("erro.jsp?mensagem=ParametrosInvalidos");
        }
    }
}
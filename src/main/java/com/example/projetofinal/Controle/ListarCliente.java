package com.example.projetofinal.Controle;

import com.example.projetofinal.Dao.ClienteDaoClasse;
import com.example.projetofinal.Dao.ClienteDaoInterface;
import com.example.projetofinal.Modelo.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet("/listarcliente")
public class ListarCliente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (ClienteDaoInterface clienteDao = new ClienteDaoClasse()) {
            Set<Cliente> clientes = clienteDao.buscarTodos();
            request.setAttribute("clientes", clientes);
            request.getRequestDispatcher("listarcliente.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?mensagem=erroaotentarlistarclientes");
        }
    }
}
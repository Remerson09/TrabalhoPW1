package com.example.projetofinal.Controle;

import com.example.projetofinal.Dao.ClienteDaoClasse;
import com.example.projetofinal.Dao.ClienteDaoInterface;

import com.example.projetofinal.Modelo.Cliente;
import com.example.projetofinal.Util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editarcliente")
public class EditarCliente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String clienteIdParam = request.getParameter("clienteId");
            String novoNome = request.getParameter("nome");
            String novoEndereco = request.getParameter("endereco");
            String novoTelefone = request.getParameter("telefone");

            if (Validador.temConteudo(clienteIdParam) && Validador.temConteudo(novoNome) &&
                    Validador.temConteudo(novoEndereco) && Validador.temConteudo(novoTelefone)) {

                int clienteId = Integer.parseInt(clienteIdParam);
                ClienteDaoInterface dao = new ClienteDaoClasse();
                Cliente cliente = dao.buscarPorId(clienteId);

                if (cliente != null) {
                    cliente.setNome(novoNome);
                    cliente.setEndereco(novoEndereco);
                    cliente.setTelefone(novoTelefone);

                    dao.editar(cliente);

                    response.sendRedirect("listarcliente?mensagem=Editado-sucesso");
                } else {
                    response.sendRedirect("erro.jsp?mensagem=ClienteNaoEncontrado");
                }
            } else {
                response.sendRedirect("editarcliente.jsp?mensagem=DadosIncompletos");
            }
        } catch (NumberFormatException ex) {
            response.sendRedirect("erro.jsp?mensagem=IDInvalido");
        } catch (Exception ex) {
            ex.printStackTrace(); // Aqui você pode logar o erro para depuração
            response.sendRedirect("editarcliente.jsp?mensagem=ErroGeral");
        }
    }
}



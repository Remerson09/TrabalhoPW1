package com.example.projetofinal.Controle;

import com.example.projetofinal.Dao.ClienteDaoClasse;
import com.example.projetofinal.Dao.ClienteDaoInterface;
import com.example.projetofinal.Dao.ErroDao;
import com.example.projetofinal.Modelo.Cliente;
import com.example.projetofinal.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/cadastrar")
public class CadastrarCliente  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");

            if (Validador.temConteudo(nome) && Validador.temConteudo(endereco) && Validador.temConteudo(telefone)) {
                try (ClienteDaoInterface clienteDao = new ClienteDaoClasse()) {
                    Cliente cliente = new Cliente(nome, endereco, telefone);
                    clienteDao.inserir(cliente);
                    response.sendRedirect("listarcliente"); // Redireciona para a listagem de clientes após o cadastro
                } catch (ErroDao e) {
                    response.sendRedirect("index.jsp?mensagem=falhaaotentarcadastrar");
                } catch (Exception e) {
                    response.sendRedirect("index.jsp?mensagem=falhaaotentarcadastrar");
                }
            } else {
                response.sendRedirect("index.jsp?mensagem=faltaparametros");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("index.jsp?mensagem=errogeral");
        }
    }

}


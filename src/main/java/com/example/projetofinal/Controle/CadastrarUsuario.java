package com.example.projetofinal.Controle;

import com.example.projetofinal.Dao.UsuarioDaoClasse;
import com.example.projetofinal.Dao.UsuarioDaoInterface;
import com.example.projetofinal.Modelo.Usuario;
import com.example.projetofinal.Util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if (Validador.temConteudo(login) && Validador.temConteudo(senha)) {
            try {
                Usuario usuario = new Usuario(login, senha);
                UsuarioDaoInterface usuarioDao = new UsuarioDaoClasse();
                usuarioDao.inserir(usuario);
                response.sendRedirect("index.jsp?mensagem=Cadastrado-comSucesso");
            } catch (Exception e) {
                response.sendRedirect("index.jsp?mensagem=falhaaotentarcadastrar");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=faltaparametros");
        }
    }
}
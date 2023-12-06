package com.example.projetofinal.Controle;

import com.example.projetofinal.Dao.UsuarioDaoClasse;
import com.example.projetofinal.Dao.UsuarioDaoInterface;
import com.example.projetofinal.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/teste")
public class teste extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if (login != null && senha != null) {
            try (UsuarioDaoInterface dao = new UsuarioDaoClasse()) {
                Usuario u = new Usuario(login, senha);
                dao.inserir(u);
                response.getWriter().println("Usuário inserido com sucesso: " + u);
            } catch (Exception e) {
                response.getWriter().println(e);
            }
        } else {
            response.getWriter().println("Os parâmetros 'login' e 'senha' são necessários para inserir um usuário.");
        }
    }
}

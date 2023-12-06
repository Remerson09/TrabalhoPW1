package com.example.projetofinal.Controle;


import com.example.projetofinal.Dao.ErroDao;
import com.example.projetofinal.Dao.UsuarioDaoClasse;
import com.example.projetofinal.Dao.UsuarioDaoInterface;
import com.example.projetofinal.Modelo.Usuario;
import com.example.projetofinal.Util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logar")
public class Logar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if (Validador.temConteudo(login) && Validador.temConteudo(senha)) {
            try (UsuarioDaoInterface dao = new UsuarioDaoClasse()) {
                Usuario usuario = dao.buscarPorLogin(login);

                if (usuario != null && usuario.getSenha().equals(senha)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", usuario);
                    response.sendRedirect("cadastrar.jsp?mensagem=logadocomsucesso");
                } else {
                    response.sendRedirect("index.jsp?mensagem=loginousenhaincorretos");
                }
            } catch (Exception e) {
                response.sendRedirect("index.jsp?mensagem=erroaotentarlogar");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=faltaparametros");
        }
    }
}
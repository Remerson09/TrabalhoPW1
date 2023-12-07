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
        String nome =request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if (Validador.temConteudo(login) && Validador.temConteudo(senha)) {
            try (UsuarioDaoInterface dao = new UsuarioDaoClasse()) {
                // Verificar se o usuário existe no banco de dados
                Usuario usuario = dao.buscarPorLogin(login);

                if (usuario != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuarioLogado", usuario.getLogin());
                    response.sendRedirect("index.jsp");
                } else {
                    // Redirecionar para a página de erro caso as credenciais sejam inválidas
                    response.sendRedirect("erro.jsp?mensagem=CredenciaisInvalidas");
                }
            } catch (Exception e) {
                // Lidar com exceções ou erros de forma apropriada
                response.sendRedirect("erro.jsp?mensagem=ErroGeral");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=FaltamParametros");
        }
    }
}
package com.example.projetofinal.Controle;

import com.example.projetofinal.Dao.AparelhoDaoClasse;
import com.example.projetofinal.Dao.AparelhoDaoInterface;
import com.example.projetofinal.Dao.ErroDao;
import com.example.projetofinal.Modelo.Aparelho;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet("/listaaparelho")
public class ListaAparelho extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AparelhoDaoInterface dao = new AparelhoDaoClasse();
            Set<Aparelho> aparelhos = dao.buscarTodos();

            request.getRequestDispatcher("listaaparelho.jsp").forward(request, response);
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?mensagem=erroaotentarlistaraparelhos");
        }
    }
}

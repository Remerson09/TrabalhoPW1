package com.example.projetofinal.Controle;


import com.example.projetofinal.Dao.ErroDao;
import com.example.projetofinal.Dao.ServicoDaoClasse;
import com.example.projetofinal.Dao.ServicoDaoInterface;
import com.example.projetofinal.Modelo.Servico;
import com.example.projetofinal.Util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editarservico")
public class EditarServico extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Recupera os dados do formulário
        int id = Integer.parseInt(request.getParameter("servicoId"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");

        // Verifica se os dados recebidos são válidos
        if (Validador.temConteudo(nome) && Validador.temConteudo(descricao) && Validador.temConteudo(valor)) {
            // Cria um novo objeto Servico com os dados atualizados
            Servico servico = new Servico(id, nome, descricao, valor);

            ServicoDaoInterface dao = null;
            try {
                // Inicializa o DAO e executa a operação de edição
                dao = new ServicoDaoClasse();
                dao.editar(servico);

                // Redireciona para a página de listagem após a edição bem-sucedida
                response.sendRedirect("listaservico?mensagem=Servico_Atualizado");
            } catch (ErroDao e) {
                e.printStackTrace();
                // Em caso de erro, redireciona para a página de erro exibindo a mensagem do erro
                response.sendRedirect("pagina_de_erro.jsp?mensagem=" + e.getMessage());
            } finally {
                // Fecha o DAO após o uso, garantindo a liberação de recursos
                if (dao != null) {
                    try {
                        dao.close();
                    } catch (Exception ignored) {
                        // Trate o erro de fechamento da conexão, se necessário
                    }
                }
            }
        } else {
            // Redireciona para a página de erro se os dados forem inválidos
            response.sendRedirect("pagina_de_erro.jsp?mensagem=Dados_Invalidos");
        }
    }
}

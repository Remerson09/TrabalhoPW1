
<%@ page import="java.util.Set" %>
<%@ page import="com.example.projetofinal.Dao.AparelhoDaoClasse" %>
<%@ page import="com.example.projetofinal.Modelo.Aparelho" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>
<%@ page pageEncoding="utf-8" %>
<main>
   <h1>Lista de Aparelhos</h1>
   <%
      try {
         AparelhoDaoClasse dao = new AparelhoDaoClasse();
         Set<Aparelho> aparelhos = dao.buscarTodos();
   %>
   <table>
      <thead>
      <tr>
         <th>ID</th>
         <th>Nome</th>
         <th>Modelo</th>
         <th>Marca</th>
         <th>Número de Série</th>
      </tr>
      </thead>
      <tbody>
      <% for (Aparelho aparelho : aparelhos) { %>
      <tr>
         <td><%= aparelho.getId() %></td>
         <td><%= aparelho.getNome() %></td>
         <td><%= aparelho.getModelo() %></td>
         <td><%= aparelho.getMarca() %></td>
         <td><%= aparelho.getNumeroSerie() %></td>
         <td><a href="editaraparelho.jsp?id=<%= aparelho.getId() %>">Editar</a></td>
         <td><a href="deletaraparelho?id=<%= aparelho.getId() %>">Deletar</a></td>
      </tr>
      <% } %>
      </tbody>
   </table>
   <%
         dao.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   %>
</main>

<%@ include file="WEB-INF/rodape.jsp" %>
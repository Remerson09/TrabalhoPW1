<%@ page import="com.example.projetofinal.Modelo.Servico" %>
<%@ page import="java.util.Set" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>
<%@page pageEncoding="utf-8" %>
<main>
<h1>Listagem de Serviços</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Valor</th>
        <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <%
        Set<Servico> servicos = (Set<Servico>) request.getAttribute("servicos");
        for (Servico servico : servicos) {
    %>
    <tr>
        <td><%= servico.getId() %></td>
        <td><%= servico.getNome() %></td>
        <td><%= servico.getDescricao() %></td>
        <td><%= servico.getValor() %></td>
        <td>
            <a href="editarservico.jsp?servicoId=<%= servico.getId() %>">Editar</a>
            <form action="deletarservico" method="POST" style="display: inline;">
                <input type="hidden" name="id" value="<%= servico.getId() %>">
                <button type="submit">Deletar</button>
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</main>
<%@include file="WEB-INF/rodape.jsp"%>

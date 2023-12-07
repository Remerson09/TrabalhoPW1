<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.projetofinal.Modelo.Servico" %>
<%@ page import="java.util.Set" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>
<%@ page pageEncoding="utf-8" %>
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
        <c:forEach var="servico" items="${servicos}">
            <tr>
                <td><c:out value="${servico.id}" /></td>
                <td><c:out value="${servico.nome}" /></td>
                <td><c:out value="${servico.descricao}" /></td>
                <td><c:out value="${servico.valor}" /></td>
                <td>
                    <a href="editarservico.jsp?servicoId=${servico.id}">Editar</a>
                    <form action="deletarservico" method="POST" style="display: inline;">
                        <input type="hidden" name="id" value="${servico.id}">
                        <button type="submit">Deletar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<%@ include file="WEB-INF/rodape.jsp" %>
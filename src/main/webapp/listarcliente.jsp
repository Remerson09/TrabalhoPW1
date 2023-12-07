<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.projetofinal.Modelo.Cliente" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>
<%@ page pageEncoding="utf-8" %>
<main>
    <table>
        <thead>
        <tr>
            <th>Identificação</th>
            <th>Nome</th>
            <th>Endereço</th>
            <th>Telefone</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cliente" items="${clientes}">
            <tr>
                <td><c:out value="${cliente.id}" /></td>
                <td><c:out value="${cliente.nome}" /></td>
                <td><c:out value="${cliente.endereco}" /></td>
                <td><c:out value="${cliente.telefone}" /></td>
                <td>
                    <a href="editarcliente.jsp?clienteId=${cliente.id}">Editar</a>
                    <form action="deletarcliente" method="POST" style="display: inline;">
                        <input type="hidden" name="clienteId" value="${cliente.id}">
                        <button type="submit">Deletar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>

<%@ include file="WEB-INF/rodape.jsp" %>
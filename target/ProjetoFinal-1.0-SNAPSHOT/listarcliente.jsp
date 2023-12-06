<%@ page import="com.example.projetofinal.Modelo.Cliente" %>
<%@ page import="java.util.Set" %>
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
        <%
            Set<Cliente> clientes = (Set<Cliente>) request.getAttribute("clientes");
            for (Cliente cliente : clientes) {
        %>
        <tr>
            <td><%= cliente.getId() %></td>
            <td><%= cliente.getNome() %></td>
            <td><%= cliente.getEndereco() %></td>
            <td><%= cliente.getTelefone() %></td>
            <td>
                <a href="editarcliente.jsp?clienteId=<%= cliente.getId() %>">Editar</a>
                <form action="deletarcliente" method="POST" style="display: inline;">
                    <input type="hidden" name="clienteId" value="<%= cliente.getId() %>">
                    <button type="submit">Deletar</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</main>


<%@ include file="WEB-INF/rodape.jsp" %>
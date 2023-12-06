
<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<main>
    <form action="editarcliente" method="POST">
        ID do Cliente: <input type="text" name="clienteId" value="<%= (request.getParameter("clienteId") != null) ? request.getParameter("clienteId") : "" %>"><br><br>
        <input type="hidden" name="clienteId" value="<%= (request.getParameter("clienteId") != null) ? request.getParameter("clienteId") : "" %>">
        Nome: <input type="text" name="nome" value="<%= (request.getParameter("nome") != null) ? request.getParameter("nome") : "" %>"><br><br>
        Endereço: <input type="text" name="endereco" value="<%= (request.getParameter("endereco") != null) ? request.getParameter("endereco") : "" %>"><br><br>
        Telefone: <input type="text" name="telefone" value="<%= (request.getParameter("telefone") != null) ? request.getParameter("telefone") : "" %>"><br><br>

        <!-- Outros campos de edição, se necessário -->

        <input type="submit" value="Salvar">
    </form>
</main>
<%@include file="WEB-INF/rodape.jsp"%>


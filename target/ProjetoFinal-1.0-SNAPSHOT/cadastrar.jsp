<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>

<main>
    <h2>Cadastro de Cliente</h2>

    <form action="cadastrar" method="post">
        <label>Nome:
            <input type="text" name="nome" placeholder="nome">
        </label>
        <label>Endereço:
            <input type="text" name="endereco" placeholder="Endereço">
        </label>
        <label>Telefone:
            <input type="text" name="telefone" placeholder="Telefone">
        </label>
        <input type="submit" value="Cadastrar">
    </form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>
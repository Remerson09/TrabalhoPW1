<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<main>
    <h1>Cadastro de Serviço</h1>
    <form action="servico" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id"><br><br>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome"><br><br>

        <label for="descricao">Descrição:</label>
        <input type="text" id="descricao" name="descricao"><br><br>

        <label for="valor">Valor:</label>
        <input type="text" id="valor" name="valor"><br><br>

        <input type="submit" value="Enviar">
    </form>
</main>
<%@include file="WEB-INF/rodape.jsp"%>

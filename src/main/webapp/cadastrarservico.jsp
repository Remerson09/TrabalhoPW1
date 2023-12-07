<%@ page pageEncoding="utf-8" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>
<main>
    <h1> Serviços</h1>
    <form action="servico" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome"><br><br>

        <label for="descricao">Descrição:</label>
        <input type="text" id="descricao" name="descricao"><br><br>

        <label for="valor">Valor:</label>
        <input type="text" id="valor" name="valor"><br><br>

        <input type="submit" value="Enviar">
    </form>
</main>
<%@ include file="WEB-INF/rodape.jsp" %>
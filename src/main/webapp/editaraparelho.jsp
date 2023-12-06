
<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<main>
<h1>Editar Aparelho</h1>

<%-- Recuperando mensagens, se houver --%>
<c:if test="${not empty param.mensagem}">
    <p>${param.mensagem}</p>
</c:if>

<%-- Formulário para editar aparelho --%>
<form method="post" action="editaraparelho">
    <label for="aparelhoId">ID do Aparelho:</label>
    <input type="text" id="aparelhoId" name="aparelhoId" required><br><br>

    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required><br><br>

    <label for="modelo">Modelo:</label>
    <input type="text" id="modelo" name="modelo" required><br><br>

    <label for="marca">Marca:</label>
    <input type="text" id="marca" name="marca" required><br><br>

    <label for="numeroSerie">Número de Série:</label>
    <input type="text" id="numeroSerie" name="numeroSerie" required><br><br>

    <input type="submit" value="Editar">
</form>
</main>

<%@include file="WEB-INF/rodape.jsp"%>
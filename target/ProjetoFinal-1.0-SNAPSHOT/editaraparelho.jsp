<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>
<main>
    <c:if test="${not empty param.aparelhoId}">
        <%-- Importando o AparelhoDaoClasse e buscando o aparelho por ID --%>
        <jsp:useBean id="aparelhoDao" class="com.example.projetofinal.Dao.AparelhoDaoClasse" />
        <jsp:useBean id="aparelho" class="com.example.projetofinal.Modelo.Aparelho" />

        <%-- Buscando o aparelho pelo ID --%>
        <c:set var="aparelhoId" value="${param.aparelhoId}" />
        <c:set var="aparelho" value="${aparelhoDao.buscarPorId(aparelhoId)}" />

        <c:if test="${aparelho ne null}">
            <h2>Editar Aparelho</h2>
            <form action="editaraparelho" method="POST">
                ID do Aparelho: ${aparelho.id}<br> <!-- Mostra o ID do aparelho de forma estática -->
                <input type="hidden" name="aparelhoId" value="${aparelho.id}"><br> <!-- Envia o ID como hidden -->
                Nome: <input type="text" name="nome" value="${aparelho.nome}"><br><br>
                Modelo: <input type="text" name="modelo" value="${aparelho.modelo}"><br><br>
                Marca: <input type="text" name="marca" value="${aparelho.marca}"><br><br>
                Número de Série: <input type="text" name="numeroSerie" value="${aparelho.numeroSerie}"><br><br>
                <input type="submit" value="Salvar">
            </form>
        </c:if>
    </c:if>
</main>
<%@ include file="WEB-INF/rodape.jsp" %>
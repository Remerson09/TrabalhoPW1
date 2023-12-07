<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>
<main>
    <c:if test="${not empty param.clienteId}">
        <%-- Importando o ClienteDaoClasse e buscando o cliente por ID --%>
        <jsp:useBean id="clienteDao" class="com.example.projetofinal.Dao.ClienteDaoClasse" />
        <jsp:useBean id="cliente" class="com.example.projetofinal.Modelo.Cliente" />

        <%-- Buscando o cliente pelo ID --%>
        <c:set var="clienteId" value="${param.clienteId}" />
        <c:set var="cliente" value="${clienteDao.buscarPorId(clienteId)}" />

        <c:if test="${cliente ne null}">
            <h2>Editar Cliente</h2>
            <form action="editarcliente" method="POST">
                ID do Cliente: ${cliente.id}<br> <!-- Mostra o ID do cliente de forma estática -->
                <input type="hidden" name="clienteId" value="${cliente.id}"><br> <!-- Envia o ID como hidden -->
                Nome: <input type="text" name="nome" value="${cliente.nome}"><br><br>
                Endereço: <input type="text" name="endereco" value="${cliente.endereco}"><br><br>
                Telefone: <input type="text" name="telefone" value="${cliente.telefone}"><br><br>
                <input type="submit" value="Salvar">
            </form>
        </c:if>
    </c:if>
</main>
<%@ include file="WEB-INF/rodape.jsp" %>
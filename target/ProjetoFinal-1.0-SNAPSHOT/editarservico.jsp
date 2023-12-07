<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>
<main>
   <c:if test="${not empty param.servicoId}">
      <jsp:useBean id="servicoDao" class="com.example.projetofinal.Dao.ServicoDaoClasse" />
      <c:set var="servicoId" value="${param.servicoId}" />
      <c:set var="servico" value="${servicoDao.buscarPorId(servicoId)}" />

      <c:if test="${not empty servico}">
         <h1>Editar Serviço</h1>
         <form action="editarservico" method="post">
            ID do Serviço: <c:out value="${servico.id}" /><br>
            <input type="hidden" name="servicoId" value="${servico.id}"><br>
            Nome: <input type="text" name="nome" value="${servico.nome}"><br><br>
            Descrição: <textarea name="descricao">${servico.descricao}</textarea><br><br>
            Valor: <input type="text" name="valor" value="${servico.valor}"><br><br>
            <input type="submit" value="Salvar">
         </form>
      </c:if>
   </c:if>
</main>
<%@ include file="WEB-INF/rodape.jsp" %>
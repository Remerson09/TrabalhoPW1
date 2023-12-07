<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.example.projetofinal.Dao.AparelhoDaoClasse" %>
<%@ page import="com.example.projetofinal.Modelo.Aparelho" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>
<%@ page pageEncoding="utf-8" %>
<main>
   <h1>Lista de Aparelhos</h1>
   <%-- Criando uma instância do DAO --%>
   <c:set var="aparelhoDao" value="<%= new com.example.projetofinal.Dao.AparelhoDaoClasse() %>" />
   <%-- Chamando o método do DAO para obter a lista de aparelhos --%>
   <c:set var="aparelhos" value="${aparelhoDao.buscarTodos()}" />
   <c:if test="${not empty aparelhos}">
      <table>
         <thead>
         <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Modelo</th>
            <th>Marca</th>
            <th>Número de Série</th>
            <th>Ações</th>
         </tr>
         </thead>
         <tbody>
         <c:forEach var="aparelho" items="${aparelhos}">
            <tr>
               <td><c:out value="${aparelho.id}" /></td>
               <td><c:out value="${aparelho.nome}" /></td>
               <td><c:out value="${aparelho.modelo}" /></td>
               <td><c:out value="${aparelho.marca}" /></td>
               <td><c:out value="${aparelho.numeroSerie}" /></td>
               <td>
                  <a href="editaraparelho.jsp?aparelhoId=${aparelho.id}">Editar</a>
                  <a href="deletaraparelho?id=${aparelho.id}">Deletar</a>
               </td>
            </tr>
         </c:forEach>
         </tbody>
      </table>
   </c:if>
   <%-- Lembre-se de limpar a variável do DAO depois de usá-la --%>
   <c:set var="aparelhoDao" value="" />
</main>

<%@ include file="WEB-INF/rodape.jsp" %>
<%@ include file="WEB-INF/cabecalho.jsp"%>
<%@page pageEncoding="utf-8" %>
<main>
   <h1>Editar Serviço</h1>
   <form action="editarservico" method="post">
      <label for="servicoId">ID do Serviço:</label>
      <input type="text" id="servicoId" name="servicoId" placeholder="Informe o ID do Serviço"><br><br>
      <label for="nome">Nome:</label>
      <input type="text" id="nome" name="nome" value="<%= request.getParameter("nome") != null ? request.getParameter("nome") : "" %>"><br><br>
      <label for="descricao">Descrição:</label>
      <textarea id="descricao" name="descricao"><%= request.getParameter("descricao") != null ? request.getParameter("descricao") : "" %></textarea><br><br>
      <label for="valor">Valor:</label>
      <input type="text" id="valor" name="valor" value="<%= request.getParameter("valor") != null ? request.getParameter("valor") : "" %>"><br><br>
      <input type="submit" value="Salvar">
   </form>
</main>
<%@ include file="WEB-INF/rodape.jsp"%>
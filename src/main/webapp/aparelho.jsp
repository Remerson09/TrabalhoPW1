<%@page pageEncoding="utf-8" %>
<%@include file="WEB-INF/cabecalho.jsp"%>
<main>
   <h1>Cadastro de Aparelho</h1>
   <form action="aparelho" method="post">
      <label for="id">ID:</label>
      <input type="text" id="id" name="id"><br><br>
      <label for="nome">Nome:</label>
      <input type="text" id="nome" name="nome"><br><br>

      <label for="modelo">Modelo:</label>
      <input type="text" id="modelo" name="modelo"><br><br>

      <label for="marca">Marca:</label>
      <input type="text" id="marca" name="marca"><br><br>

      <label for="numeroSerie">Número de Série:</label>
      <input type="text" id="numeroSerie" name="numeroSerie"><br><br>

      <input type="submit" value="Enviar">
   </form>
</main>
<%@include file="WEB-INF/rodape.jsp"%>

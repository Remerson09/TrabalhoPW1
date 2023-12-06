<%@ page pageEncoding="utf-8" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>

<main>
    <h2>Login</h2>
    <form action="cadastrarUsuario" method="post">
        <label>Login:
            <input type="text" name="login" placeholder="Login">
        </label>
        <label>Senha:
            <input type="password" name="senha" placeholder="Senha">
        </label>
        <input type="submit" value="Entrar">
    </form>
</main>

<%@ include file="WEB-INF/rodape.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="WEB-INF/cabecalho.jsp" %>

<main>
    <h2>Login</h2>
    <!-- Se houver um usuário logado na sessão, exibe a saudação -->
    <c:choose>
        <c:when test="${not empty sessionScope.usuarioLogado}">
            <p>Bem-vindo, ${sessionScope.usuarioLogado}</p>
        </c:when>
        <c:otherwise>
            <!-- Formulário de login -->
            <form action="cadastrarUsuario" method="post">
                <label>Nome:
                    <input type="text" name="nome" placeholder="Seu Nome">
                </label>
                <label>Login:
                    <input type="text" name="login" placeholder="Login">
                </label>
                <label>Senha:
                    <input type="password" name="senha" placeholder="Senha">
                </label>
                <input type="submit" value="Entrar">
            </form>
        </c:otherwise>
    </c:choose>
</main>

<%@ include file="WEB-INF/rodape.jsp" %>
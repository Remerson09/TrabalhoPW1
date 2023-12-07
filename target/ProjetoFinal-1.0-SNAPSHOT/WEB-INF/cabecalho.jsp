<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
<header>
    <h1>Sistema de Cadastro de Usuários</h1>
    <c:choose>
        <c:when test="${not empty sessionScope.usuario}">
            <c:set var="usuarioLogado" value="${sessionScope.usuario}" />
            <c:if test="${not empty usuarioLogado.login}">
                <p>Olá ${usuarioLogado.login}</p>
            </c:if>
        </c:when>
    </c:choose>
</header>
<div class="mensagem">
    <c:choose>
        <c:when test="${param.mensagem eq 'cadastradocomsucesso'}">
            <p>Cadastrado com sucesso</p>
        </c:when>
        <c:when test="${param.mensagem eq 'falhaaotentarcadastrar'}">
            <p>Falha ao tentar cadastrar</p>
        </c:when>
        <c:when test="${param.mensagem eq 'faltaparametros'}">
            <p>Falta informar os parâmetros</p>
        </c:when>
        <c:when test="${param.mensagem eq 'loginousenhaincorretos'}">
            <p>Login ou senha incorretos</p>
        </c:when>
        <c:when test="${param.mensagem eq 'tchau'}">
            <p>Tchau</p>
        </c:when>
        <c:when test="${param.mensagem eq 'sempermissao'}">
            <p>Você não tem permissão. Faça o login.</p>
        </c:when>
        <c:when test="${param.mensagem eq 'Acesso_negado'}">
            <p>Você não tem permissão para deletar este usuário</p>
        </c:when>
        <c:when test="${param.mensagem eq 'ID_nao_fornecido'}">
            <p>É preciso logar primeiro ou se cadastrar</p>
        </c:when>
        <c:when test="${param.mensagem eq 'ErroAoEditarUsuario'}">
            <p>Informe o usuário a ser trocado</p>
        </c:when>
        <c:when test="${param.mensagem eq 'pagina_de_erro'}">
            <p>O ID informado não existe ou está cadastrado</p>
        </c:when>
    </c:choose>
</div>
<jsp:include page="WEB-INF/menu.jsp"/>
</body>
</html>
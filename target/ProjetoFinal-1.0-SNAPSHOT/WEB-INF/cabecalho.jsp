<%@ page import="com.example.projetofinal.Modelo.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
    <header>
        <h1>Sistema de Cadastro de Usuários</h1>
        <%
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            if (usuarioLogado != null) {
                String loginUsuario = usuarioLogado.getLogin();
                if (loginUsuario != null && !loginUsuario.isEmpty()) {
                    out.print("<p>Olá " + usuarioLogado.getLogin() + "</p>");
                }
            }
        %>
    </header>
    <div class="mensagem">
        <%
            String mensagem=request.getParameter("mensagem");
            if("cadastradocomsucesso".equals(mensagem))
                out.print("Cadastrado com sucesso");
            if("falhaaotentarcadastrar".equals(mensagem))
                out.print("Falha ao tentar cadastrar");
            if("faltaparametros".equals(mensagem))
                out.print("Falta informar os parâmetros");
            if("loginousenhaincorretos".equals(mensagem))
                out.print("Login ou senha incorretos");
            if("tchau".equals(mensagem))
                out.print("Tchau");
            if("sempermissao".equals(mensagem))
                out.print("Você não tem permissão. Faça o login.");
            if ("Acesso_negado".equals(mensagem))
                out.print("Você nao tem permisão para deletar este usuario");
            if ("ID_nao_fornecido".equals(mensagem))
                out.print("É preciso logar primeiro ou se cadastrar");
            if("ErroAoEditarUsuario".equals(mensagem))
                out.print("Informe o usuario a ser trocado");
            if ("pagina_de_erro".equals((mensagem)))
                out.print("O ID informado nao exite ou ta cadastrado");
        %>
    </div>
    <%@include file="menu.jsp"%>

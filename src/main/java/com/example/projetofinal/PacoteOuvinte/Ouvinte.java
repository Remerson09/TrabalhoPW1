package com.example.projetofinal.PacoteOuvinte;


import com.example.projetofinal.Modelo.Usuario;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.HashSet;
import java.util.Set;

@WebListener
public class Ouvinte implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent evento) {

        ServletContext aplicacao=evento.getServletContext();
        Set<Usuario> usuarios=new HashSet();

        aplicacao.setAttribute("usuarios",usuarios);
        aplicacao.setAttribute("serial",2);

    }
}

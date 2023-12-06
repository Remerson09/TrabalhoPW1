package com.example.projetofinal.Util;

import jakarta.servlet.ServletContext;

public class Serial {
    public static int Proximo(ServletContext aplicacao){
        int serial=(Integer) aplicacao.getAttribute("serial");
        serial++;
        aplicacao.setAttribute("serial",serial);
        return serial;
    }
}

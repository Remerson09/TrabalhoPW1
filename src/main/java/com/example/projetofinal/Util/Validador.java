package com.example.projetofinal.Util;

public class Validador {
    public static boolean temConteudo(String texto)
    {
        if(texto!=null && !texto.isBlank())
            return true;
        else
            return false;
    }
}

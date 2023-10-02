package com.example.Banco_YC.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class S_GeradorConta {
    public static String gerarConta() {

        final char[] CARACTERES_NUMERICOS = "0123456789".toCharArray();
        String senha = "";
        Random rand = new Random();

        for(int i = 0; i < 8; i++){
            senha += CARACTERES_NUMERICOS[rand.nextInt(0, CARACTERES_NUMERICOS.length)];
        }

        return senha;
    }
}
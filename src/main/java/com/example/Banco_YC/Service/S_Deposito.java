package com.example.Banco_YC.Service;

import com.example.Banco_YC.Model.M_Usuario;
import com.example.Banco_YC.R_Pessoa.R_Deposito;
import com.example.Banco_YC.R_Pessoa.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;

public class S_Deposito {

    private static R_Deposito r_deposito;

    public static String enviarDeposito(float saldo){
        boolean podeSalvar = true;
        String mensagem = "";


        if(podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setSaldo((m_usuario.getSaldo() + saldo));

            try{
                r_deposito.save(m_usuario);
                mensagem += "Deu Bom";
            }catch (DataIntegrityViolationException e){
                mensagem += "Deu Ruim";
            }
        }
        return mensagem;
    }
}

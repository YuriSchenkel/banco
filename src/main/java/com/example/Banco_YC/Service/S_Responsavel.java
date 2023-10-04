package com.example.Banco_YC.Service;

import com.example.Banco_YC.Model.M_Responsavel;
import com.example.Banco_YC.Model.M_Usuario;
import com.example.Banco_YC.R_Pessoa.R_Responsavel;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
@Service
public class S_Responsavel {
    private static R_Responsavel r_responsavel;

    public S_Responsavel(R_Responsavel r_responsavel) {
        this.r_responsavel =  r_responsavel;
    }

    public static String cadastrarResponsavel(String nome, String cpf, String idade,String telefone, String email){
        boolean podeSalvar = true;
        String mensagem = "";

        if(S_Generico.textoEstaVazio(nome)){
            podeSalvar = false;
            mensagem += "O nome precisa ser preenchido!";
        }
        if(S_Generico.textoEstaVazio(email)){
            podeSalvar = false;
            mensagem += "O e-mail precisa ser preenchido!";
        }
        if(!S_Generico.validarEmail(email)){
            podeSalvar = false;
            mensagem += "E-Mail inválido!";
        }
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(telefone))){
            podeSalvar = false;
            mensagem += "O telefone precisa ser informado!";
        }
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(cpf))){
            podeSalvar = false;
            mensagem += "O cpf precisa ser informado!";
        }
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(idade))){
            podeSalvar = false;
            mensagem += "A idade precisa ser informada!";
        }

        if(podeSalvar){
            M_Usuario mu = new M_Usuario();
            M_Responsavel m_responsavel = new M_Responsavel();

            m_responsavel.setUsuario_id(m_responsavel.getUsuario_id());
            m_responsavel.setNome(nome);
            m_responsavel.setIdade(Integer.parseInt(idade));
            m_responsavel.setEmail(email);
            m_responsavel.setTelefone(Long.parseLong(telefone));
            m_responsavel.setCpf(Long.parseLong(cpf));

            try{
                r_responsavel.save(m_responsavel);
                mensagem += "Deu Bom";
            }catch (DataIntegrityViolationException e){
                mensagem += "Deu Ruim";
            }
        }
        return mensagem;
    }
}


package com.example.Banco_YC.Service;

import com.example.Banco_YC.Model.M_Responsavel;
import com.example.Banco_YC.Model.M_Usuario;
import com.example.Banco_YC.R_Pessoa.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Usuario {
    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        this.r_usuario =  r_usuario;
    }

    public static M_Usuario verificarLogin(String cpf, String senha){
        boolean dadosValidos = true;
        cpf = S_Generico.limparNumero(cpf);

        if(S_Generico.textoEstaVazio(cpf)){
            return null;
        } else if(S_Generico.textoEstaVazio(senha)){
            return null;
        }
        return r_usuario.buscarPorCpfSenha(Long.parseLong(cpf),senha);
    }


    public static String cadastrarUsuario(String nome, String cpf, String idade, String cep, String senha,String telefone, String email){
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
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(cep))){
            podeSalvar = false;
            mensagem += "O cep precisa ser informada!";
        }
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(senha))){
            podeSalvar = false;
            mensagem += "A senha precisa ser informada!";
        }

        if(podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            M_Responsavel mr = new M_Responsavel();

            m_usuario.setNome(nome);
            m_usuario.setIdade(Integer.parseInt(idade));
            m_usuario.setEmail(email);
            m_usuario.setTelefone(Long.parseLong(telefone));
            m_usuario.setCpf(Long.parseLong(cpf));
            m_usuario.setCep(Long.parseLong(cep));
            m_usuario.setSenha(senha);
            m_usuario.setAgencia(29902);
            m_usuario.setnconta(S_GeradorConta.gerarConta());
            m_usuario.setSaldo(0.00f);


            try{
                r_usuario.save(m_usuario);
                mensagem += "Deu Bom";
            }catch (DataIntegrityViolationException e){
                mensagem += "Deu Ruim";
            }
        }
        return mensagem;
    }

}
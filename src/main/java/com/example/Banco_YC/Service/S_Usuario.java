package com.example.Banco_YC.Service;

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

    public static String cadastrarUsuario(String nome, String cpf, String idade, String cep, String senha,String telefone, String email){
        boolean podeSalvar = true;
        String mensagem = "";

        if(S_Generico.textoEstaVazio(nome)){
            podeSalvar = false;
            mensagem += "O nome precisa ser preenchido!";
        }
        if(!S_Generico.textoEstaVazio(email)){
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
            m_usuario.setNome(nome);
            m_usuario.setEmail(email);
            m_usuario.setTelefone(Long.parseLong(telefone));
            m_usuario.setCpf(Long.parseLong(cpf));
            m_usuario.setIdade(Integer.parseInt(idade));
            m_usuario.setCpf(Long.parseLong(cpf));
            m_usuario.setCep(Long.parseLong(cep));
            m_usuario.setSenha(Integer.parseInt(senha));
            m_usuario.setnConta(S_GeradorConta.gerarConta());
            m_usuario.setAgencia(29902);

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
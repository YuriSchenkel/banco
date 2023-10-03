package com.example.Banco_YC.Controller;

import com.example.Banco_YC.Service.S_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Usuario {

    @GetMapping("/cadastro")
    public String getCadastro(){
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("telefone") String telefone,
                                   @RequestParam("cpf") String cpf,
                                   @RequestParam("idade") String idade,
                                   @RequestParam("cep") String cep,
                                   @RequestParam("senha") String senha){
        S_Usuario.cadastrarUsuario(nome, cpf, idade, cep, senha, telefone, email);
        return "cadastro";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "index";
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin(@RequestParam("cpf") String cpf,
                             @RequestParam("senha") String senha,
                             HttpSession session){

        session.setAttribute("usuario", S_Usuario.verificarLogin(cpf, senha));
        if(session.getAttribute("usuario") == null){
            return false;
        } else{
            return true;
        }
    }

}
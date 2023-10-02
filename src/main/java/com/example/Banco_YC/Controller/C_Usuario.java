package com.example.Banco_YC.Controller;

import com.example.Banco_YC.Service.S_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Usuario {

    @GetMapping("/cadastro")
    public String getCadastro(){
        return "usuario/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("telefone") String telefone,
                                   @RequestParam("cpf") String cpf,
                                   @RequestParam("idade") String idade,
                                   @RequestParam("cep") String cep,
                                   @RequestParam("senha") String senha){
        S_Usuario.cadastrarUsuario(nome,email,telefone,cpf,senha,idade,cep);
        return "usuario/cadastro";
    }
}
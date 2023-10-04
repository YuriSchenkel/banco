package com.example.Banco_YC.Controller;

import com.example.Banco_YC.Model.M_Usuario;
import com.example.Banco_YC.Service.S_Deposito;
import com.example.Banco_YC.Service.S_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Home {
    @GetMapping("/home")
    public String getHome(HttpSession session,
                          Model model) {
        if (session.getAttribute("usuario") != null) {
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "home";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/perfil")
    public String getPerfil(){
        return"perfil";
    }

    @GetMapping("/transferencia")
    public String getTransferencia(){
        return"transferencia";
    }

    @GetMapping("/deposito")
    public String getDeposito(Model model){
        M_Usuario m_usuario = new M_Usuario();
        model.addAttribute("saldo", m_usuario.getSaldo());
        return"deposito";
    }

    @PostMapping("/deposito")
    public String enviarDeposito(@RequestParam("saldo") float saldo){
        S_Deposito.enviarDeposito(saldo);
        return"deposito";
    }
}


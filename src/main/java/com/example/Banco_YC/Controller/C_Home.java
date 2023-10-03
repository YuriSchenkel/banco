package com.example.Banco_YC.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
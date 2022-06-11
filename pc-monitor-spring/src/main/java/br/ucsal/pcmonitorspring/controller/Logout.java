package br.ucsal.pcmonitorspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Logout {

    @GetMapping("/logout")
    public String logout(){
        //Remover a sessão aqui
        return "/login";
    }
}

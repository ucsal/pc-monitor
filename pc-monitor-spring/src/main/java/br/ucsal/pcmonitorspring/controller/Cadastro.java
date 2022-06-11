package br.ucsal.pcmonitorspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Cadastro {

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        return "cadastro";
    }

}

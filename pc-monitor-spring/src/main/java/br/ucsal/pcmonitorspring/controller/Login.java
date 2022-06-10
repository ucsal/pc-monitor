package br.ucsal.pcmonitorspring.controller;

import br.ucsal.pcmonitorspring.repositories.PcRepository;
import br.ucsal.pcmonitorspring.services.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Login {

    @Autowired
    private WebUserService service;

    @Autowired
    PcRepository pcRepository;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("pcs", pcRepository.findAll());
        return "login";
    }

    @PostMapping("/login")
    public String validate(Model model) {
        if (service.isRegistered((String) model.getAttribute("login"))){
            return "/dashboard/ambientes";
        }
        else {
            model.addAttribute("erro", "Usuário Inválido");
            return "/login";
        }
    }
}

package br.ucsal.pcmonitorspring.controller;


import br.ucsal.pcmonitorspring.services.WebUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Login {

    private WebUserService service = new WebUserService();

    @GetMapping("/login")
    public String login(Model model){
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
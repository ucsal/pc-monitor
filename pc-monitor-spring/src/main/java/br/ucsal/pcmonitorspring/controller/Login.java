package br.ucsal.pcmonitorspring.controller;

import br.ucsal.pcmonitorspring.model.WebUserModel;
import br.ucsal.pcmonitorspring.services.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Login {

    @Autowired
    private WebUserService webUserService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("webUser", new WebUserModel());
        return "login";
    }

    @PostMapping("/login")
    public String validate(@ModelAttribute("webUser") WebUserModel webUser, Model model) {
        if (webUserService.isRegistered(webUser.getLogin())){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("login", webUser.getLogin());

            return "/home";
        }
        else {
//            model.addAttribute("erro", "Usuário Inválido");
            return "/login";
        }
    }

}
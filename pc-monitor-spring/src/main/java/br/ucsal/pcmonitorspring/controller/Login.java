package br.ucsal.pcmonitorspring.controller;

import br.ucsal.pcmonitorspring.model.WebUserModel;
import br.ucsal.pcmonitorspring.services.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Login {
    @Autowired
    private WebUserService webUserService;
    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("webUser", new WebUserModel());
        String erro = (String) session.getAttribute("erro");
        if (erro != null)
            model.addAttribute("erro", session.getAttribute("erro"));
        return "login";
    }

    @PostMapping("/login")
    public RedirectView validate(@ModelAttribute("webUser") WebUserModel webUser, Model model) {

        if (webUserService.isRegistered(webUser.getLogin())){
            if (session.getAttribute("erro") != null)
                session.removeAttribute("erro");
            session.setAttribute("login", webUser.getLogin());
            return new RedirectView("/dashboard/home");
        }
        else {
            session.setAttribute("erro", "Usuário Inválido");
            return new RedirectView("/login");
        }
    }

}
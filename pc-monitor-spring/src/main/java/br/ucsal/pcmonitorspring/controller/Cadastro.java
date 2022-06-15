package br.ucsal.pcmonitorspring.controller;

import br.ucsal.pcmonitorspring.entities.WebUser;
import br.ucsal.pcmonitorspring.exceptions.WebUserException;
import br.ucsal.pcmonitorspring.model.WebUserDTO;
import br.ucsal.pcmonitorspring.services.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Cadastro {

    @Autowired
    WebUserService webUserService;

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("userModel", new WebUserDTO());

        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String register(@ModelAttribute("userModel") WebUserDTO userModel, Model model) {

        try {
            webUserService.save(new WebUser(userModel.getLogin(), userModel.getPassword(), userModel.getRole()));
            model.addAttribute("success", "Cadastro realizado");
        } catch (WebUserException e) {
            model.addAttribute("failed", e.getMessage());
        }

        return "cadastro";
    }
}


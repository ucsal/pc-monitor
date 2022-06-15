package br.ucsal.pcmonitorspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class Logout {

    @Autowired
    HttpSession session;

    @GetMapping("/logout")
    public RedirectView logout(){
        session.invalidate();
        return new RedirectView("/login");
    }
}

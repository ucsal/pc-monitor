package br.ucsal.pcmonitorspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Logout {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/logout")
    public RedirectView logout(){
        request.getSession().invalidate();
        return new RedirectView("/login");
    }
}

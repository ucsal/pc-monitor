package br.ucsal.pcmonitorspring.controller;

import br.ucsal.pcmonitorspring.entities.Pc;
import br.ucsal.pcmonitorspring.repositories.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Dashboard {

    @Autowired
    PcRepository pcRepository;

    @GetMapping("/dashboard/ambientes")
    public String dashboard(Model model){
        List<Pc> pcs = pcRepository.findAll();
        model.addAttribute(pcs);
        return "ambientes";
    }
}

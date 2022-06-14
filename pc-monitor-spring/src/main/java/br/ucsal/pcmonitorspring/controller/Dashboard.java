package br.ucsal.pcmonitorspring.controller;

import br.ucsal.pcmonitorspring.entities.Pc;
import br.ucsal.pcmonitorspring.repositories.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class Dashboard {

    @Autowired
    PcRepository pcRepository;

    @GetMapping("/home")
    public String dashboard(Model model){
        List<Pc> pcs = pcRepository.findAll();
        model.addAttribute("pcs", pcs);
        return "home";
    }


    @GetMapping("/metrics")
    public String metrics(@RequestParam String pcCode, Model model){
        model.addAttribute("metrics",pcRepository.findByCode(pcCode).getMetrics());
        model.addAttribute("pcCode", pcCode);
        System.out.println(pcCode);

        return("metrics");

    }
}

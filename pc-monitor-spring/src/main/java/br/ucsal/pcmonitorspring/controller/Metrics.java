package br.ucsal.pcmonitorspring.controller;

import br.ucsal.pcmonitorspring.repositories.PcMetricsRepository;
import br.ucsal.pcmonitorspring.repositories.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Metrics {


	@Autowired
	PcRepository pcRepository;



	@GetMapping("/metrics")
	public String metrics(@RequestParam String pcCode, Model model){
		model.addAttribute("metrics",pcRepository.findByCode(pcCode).getMetrics());
		model.addAttribute("pcCode", pcCode);
		System.out.println(pcCode);

		return("metrics");

	}
}

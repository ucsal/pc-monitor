package br.ucsal.pcmonitorspring.api;

import br.ucsal.pcmonitorspring.entities.Pc;
import br.ucsal.pcmonitorspring.entities.PcMetrics;
import br.ucsal.pcmonitorspring.model.PcRequest;
import br.ucsal.pcmonitorspring.repositories.PcMetricsRepository;
import br.ucsal.pcmonitorspring.repositories.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Api {
	
    @Autowired
    private PcRepository pcRepository;
    
    @Autowired
    private PcMetricsRepository metricsRepository;

    @PostMapping(value ="/pcMetrics", consumes = "application/json", produces = "application/json")
    public ResponseEntity pcMetrics(@RequestBody PcMetrics metrics) {
//    	Pc pc = pcRepository.findByIdentifierCod(metrics.getPc().getIdentifierCod())
//    	metrics.getPc().setId(pc.getId());
//    	metricsRepository.save(metrics);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(value ="/pc", consumes = "application/json", produces = "application/json")
    public ResponseEntity pc(@RequestBody Pc pc) {

        pcRepository.save(pc);

        System.out.println(pcRepository.findAll());

        return ResponseEntity.ok(HttpStatus.OK);
    }

}

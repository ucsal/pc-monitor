package br.ucsal.pcmonitorspring.api;

import br.ucsal.pcmonitorspring.entities.Pc;
import br.ucsal.pcmonitorspring.entities.PcMetrics;
import br.ucsal.pcmonitorspring.model.PcMetricsDTO;
import br.ucsal.pcmonitorspring.repositories.PcMetricsRepository;
import br.ucsal.pcmonitorspring.repositories.PcRepository;
import br.ucsal.pcmonitorspring.services.PcMetricsService;
import br.ucsal.pcmonitorspring.services.PcService;
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
    private PcService pcService;

    @Autowired
    private PcMetricsService pcMetricsService;

    /*
     * Usando essa rota, o cliente deve especificar três métricas de PcMetrics:
     * - cpuUse;
     * - freeMemory;
     * - username;
     * Adicionalmente, deve-se inserir também código ("code", atributo que faz referência ao nome do Pc),
     * de um Pc previamente inserido no banco. Caso não haja um Pc cadastrado associado ao código passado
     * no Json, a API retorna HttpStatus NOT_FOUND.
     * */
    @PostMapping(value = "/pcMetrics", consumes = "application/json", produces = "application/json")
    public ResponseEntity pcMetrics(@RequestBody PcMetricsDTO metricsDTO) {
        HttpStatus response = pcMetricsService.save(metricsDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/pc", consumes = "application/json", produces = "application/json")
    public ResponseEntity pc(@RequestBody Pc pc) {
        HttpStatus response = pcService.save(pc);
        return ResponseEntity.ok(response);
    }

}
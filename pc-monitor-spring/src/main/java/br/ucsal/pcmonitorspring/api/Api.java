package br.ucsal.pcmonitorspring.api;

import br.ucsal.pcmonitorspring.entities.PcMetrics;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Api {

    @GetMapping ("/pcMetrics")
    public void pcMetrics() throws JsonProcessingException {
        String jsonTeste = "{\"nome\":\"PC de Teste\"}";
        ObjectMapper mapper = new ObjectMapper();
        PcMetrics metrics = mapper.readValue(jsonTeste, PcMetrics.class);
        System.out.println(metrics);
    }
}

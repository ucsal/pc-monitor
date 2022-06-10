package br.ucsal.pcmonitorspring.api;

import br.ucsal.pcmonitorspring.entities.Pc;
import br.ucsal.pcmonitorspring.entities.PcMetrics;
import br.ucsal.pcmonitorspring.entities.PcUser;
import br.ucsal.pcmonitorspring.entities.User;
import br.ucsal.pcmonitorspring.model.PcRequest;
import br.ucsal.pcmonitorspring.repositories.PcMetricsRepository;
import br.ucsal.pcmonitorspring.repositories.PcRepository;
import br.ucsal.pcmonitorspring.repositories.PcUserRepository;
import br.ucsal.pcmonitorspring.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PcUserRepository pcUserRepository;

    @PostMapping(value ="/pcMetrics", consumes = "application/json", produces = "application/json")
    public ResponseEntity pcMetrics(@RequestBody PcMetrics metrics) {
        metricsRepository.save(metrics);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**Recebe da aplicação Desktop um Json contendo dados do PC e Usuário logado,
     * Converte em pojos e persiste no banco de dados
     */
    @PostMapping(value ="/pc", consumes = "application/json", produces = "application/json")
    public ResponseEntity pc(@RequestBody PcRequest req) {

        Pc pc = new Pc(req.getIdentifierCod(), req.getJavaVersion(), req.getTotalMemory(), req.getOs());
        pcRepository.save(pc);

        User user = new User(req.getLogin());
        userRepository.save(user);

        PcUser pcUser = new PcUser(pc, user);

        pcUserRepository.save(pcUser);

        System.out.println(pcRepository.findAll());
        System.out.println(userRepository.findAll());
        System.out.println(pcUserRepository.findAll());

        return ResponseEntity.ok(HttpStatus.OK);
    }

}

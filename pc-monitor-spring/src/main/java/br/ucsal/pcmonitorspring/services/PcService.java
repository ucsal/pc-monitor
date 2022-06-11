package br.ucsal.pcmonitorspring.services;

import br.ucsal.pcmonitorspring.entities.Pc;
import br.ucsal.pcmonitorspring.entities.PcMetrics;
import br.ucsal.pcmonitorspring.repositories.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PcService {

    PcRepository pcRepository;

    @Autowired
    public PcService(PcRepository pcRepository){
        this.pcRepository = pcRepository;
    }

    public Pc findByCode(String code){
        return pcRepository.findByCode(code);
    }

    public HttpStatus save(Pc pc) {
        pcRepository.save(pc);
        return HttpStatus.OK;
    }
}

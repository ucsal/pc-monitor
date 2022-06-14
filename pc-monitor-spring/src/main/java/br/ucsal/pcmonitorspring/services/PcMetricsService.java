package br.ucsal.pcmonitorspring.services;

import br.ucsal.pcmonitorspring.entities.Pc;
import br.ucsal.pcmonitorspring.model.PcMetricsDTO;
import br.ucsal.pcmonitorspring.repositories.PcMetricsRepository;
import br.ucsal.pcmonitorspring.repositories.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PcMetricsService {

    PcMetricsRepository pcMetricsRepository;

    PcRepository pcRepository;



    @Autowired

    public PcMetricsService(PcMetricsRepository pcMetricsRepository, PcRepository pcRepository) {
        this.pcMetricsRepository = pcMetricsRepository;
        this.pcRepository = pcRepository;
    }


    public HttpStatus save(PcMetricsDTO metricsDTO) {
        Pc pc = pcRepository.findByCode(metricsDTO.getPcCode());
        if (pc == null)
            return HttpStatus.NOT_FOUND;
        pcMetricsRepository.create(metricsDTO.getCpuUse(), metricsDTO.getFreeMemory(), metricsDTO.getUsername(), pc);
                return HttpStatus.OK;
    }
}

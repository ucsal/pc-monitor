package br.ucsal.pcmonitorspring.services;

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
        if (pcRepository.findByCode(metricsDTO.getPcCode()) == null)
            return HttpStatus.NOT_FOUND;
        pcMetricsRepository.create(metricsDTO.getCpuUse(), metricsDTO.getFreeMemory(), metricsDTO.getUsername(), pcRepository.findByCode(metricsDTO.getPcCode()));
        return HttpStatus.OK;
    }
}

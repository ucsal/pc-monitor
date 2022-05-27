package br.ucsal.pcmonitorspring.repositories;

import br.ucsal.pcmonitorspring.entities.PcMetrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcMetricsRepository extends JpaRepository<PcMetrics, Long> {

    public PcMetrics findByName(String name);
}

package br.ucsal.pcmonitorspring.repositories;

import br.ucsal.pcmonitorspring.entities.Pc;
import br.ucsal.pcmonitorspring.entities.PcMetrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcMetricsRepository extends JpaRepository<PcMetrics, Long> {

    public default void create(String cpuUse, String freeMemory, String username, Pc pc){
        save(new PcMetrics(cpuUse, freeMemory, username, pc));
    }

}

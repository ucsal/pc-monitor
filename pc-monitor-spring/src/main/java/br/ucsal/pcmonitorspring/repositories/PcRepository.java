package br.ucsal.pcmonitorspring.repositories;

import br.ucsal.pcmonitorspring.entities.Pc;
import br.ucsal.pcmonitorspring.entities.PcMetrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcRepository extends JpaRepository<Pc, Long> {
    public Pc findByCode(String code);


}

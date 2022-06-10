package br.ucsal.pcmonitorspring.repositories;

import br.ucsal.pcmonitorspring.entities.PcUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcUserRepository extends JpaRepository<PcUser, Long> { }

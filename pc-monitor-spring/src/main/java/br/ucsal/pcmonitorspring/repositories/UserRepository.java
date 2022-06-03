package br.ucsal.pcmonitorspring.repositories;

import br.ucsal.pcmonitorspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
package br.ucsal.pcmonitorspring.repositories;

import br.ucsal.pcmonitorspring.entities.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    public WebUser findByLogin(String login);
}
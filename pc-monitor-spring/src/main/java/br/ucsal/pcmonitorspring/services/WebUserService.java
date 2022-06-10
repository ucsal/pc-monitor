package br.ucsal.pcmonitorspring.services;

import br.ucsal.pcmonitorspring.entities.WebUser;
import br.ucsal.pcmonitorspring.repositories.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUserService {

    WebUserRepository repository;

    @Autowired
    public WebUserService(WebUserRepository repository) {
        this.repository = repository;
    }

    public boolean isRegistered(String login) {
        WebUser user = repository.findByLogin(login);
        if (user == null)
            return false;
        return true;
    }

}

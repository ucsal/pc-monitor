package br.ucsal.pcmonitorspring.services;

import br.ucsal.pcmonitorspring.entities.WebUser;
import br.ucsal.pcmonitorspring.exceptions.WebUserException;
import br.ucsal.pcmonitorspring.repositories.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUserService {

    WebUserRepository webUserRepository;

    @Autowired
    public WebUserService(WebUserRepository repository) {
        this.webUserRepository = repository;
    }

    public boolean isRegistered(String login) {
        WebUser user = webUserRepository.findByLogin(login);
        return user != null;
    }

    public void save(WebUser webUser) throws WebUserException{
        if(webUser.getLogin() == null || webUser.getPassword() == null || webUser.getRole() == null) {
            throw new WebUserException("Preencha todos os campos");
        }

        if (!isRegistered(webUser.getLogin())){
            webUserRepository.save(webUser);
        } else {
            throw new WebUserException("Já existe um usuário cadastrado com esse login");
        }
    }

    public String getWebUserRole(String login) {
        return  webUserRepository.findByLogin(login).getRole();
    }
}

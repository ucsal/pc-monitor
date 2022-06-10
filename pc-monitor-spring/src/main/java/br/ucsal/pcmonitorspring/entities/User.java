package br.ucsal.pcmonitorspring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @ManyToMany
    @Column(name = "pc_ids", nullable = false)
    private List<Pc> pcIds;

    public User(Long id, String login, Pc pc_id) {
        this.id = id;
        this.login = login;
        this.pcIds.add(pc_id);
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Pc> getPcIds() {
        return pcIds;
    }

    public void setPcIds(List<Pc> pcIds) {
        this.pcIds = pcIds;
    }
}

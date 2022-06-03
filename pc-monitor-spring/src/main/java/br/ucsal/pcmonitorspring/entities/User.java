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
    private List<Pc> pc_ids;

    public User(Long id, String login, Pc pc_id) {
        this.id = id;
        this.login = login;
        this.pc_ids.add(pc_id);
    }

    public User() {

    }
}

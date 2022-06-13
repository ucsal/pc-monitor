package br.ucsal.pcmonitorspring.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
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
}

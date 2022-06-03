package br.ucsal.pcmonitorspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "web_user")
public class WebUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String user;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String role;
}

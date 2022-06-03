package br.ucsal.pcmonitorspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    private String password;
}

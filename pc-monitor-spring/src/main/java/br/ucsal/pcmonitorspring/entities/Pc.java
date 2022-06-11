package br.ucsal.pcmonitorspring.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "pc")
public class Pc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "identifier_cod", nullable = false)
    private String identifierCod;
=======
    @Column(name = "code", nullable = false)
    private String code;
>>>>>>> lucas-moreno

    @Column(name = "java_version", nullable = false)
    private String javaVersion;

    @Column(name = "total_memory", nullable = false)
    private String totalMemory;

    @Column(name = "os", nullable = false)
    private String os;

<<<<<<< HEAD
    @ManyToMany
    @Column(nullable = false)
    private List<User> users;
=======
    @OneToMany(mappedBy = "pc")
    private List<PcMetrics> metrics;
>>>>>>> lucas-moreno

    public Pc() {}

    public Pc(String identifierCod, String javaVersion, String totalMemory, String os) {
        this.code = identifierCod;
        this.javaVersion = javaVersion;
        this.totalMemory = totalMemory;
        this.os = os;
    }
}

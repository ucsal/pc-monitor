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

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "java_version", nullable = false)
    private String javaVersion;

    @Column(name = "total_memory", nullable = false)
    private String totalMemory;

    @Column(name = "os", nullable = false)
    private String os;

    @OneToMany(mappedBy = "pc")
    private List<PcMetrics> metrics;

    public Pc() {}

    public Pc(String identifierCod, String javaVersion, String totalMemory, String os) {
        this.code = identifierCod;
        this.javaVersion = javaVersion;
        this.totalMemory = totalMemory;
        this.os = os;
    }
}
package br.ucsal.pcmonitorspring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pc")
public class Pc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identifier_cod", nullable = false)
    private String identifierCod;

    @Column(name = "java_version", nullable = false)
    private String javaVersion;

    @Column(name = "total_memory", nullable = false)
    private String totalMemory;

    @Column(name = "os", nullable = false)
    private String os;

    @ManyToMany
    @Column(nullable = false)
    private List<User> users;

    public Pc() {}

    public Pc(String identifierCod, String javaVersion, String totalMemory, String os, List<User> users) {
        this.identifierCod = identifierCod;
        this.javaVersion = javaVersion;
        this.totalMemory = totalMemory;
        this.os = os;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifierCod() {
        return identifierCod;
    }

    public void setIdentifierCod(String identifierCod) {
        this.identifierCod = identifierCod;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(String totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

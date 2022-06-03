package br.ucsal.pcmonitorspring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pc")
public class Pc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identifier_cod;
    private String java_version;

    private String total_memory;

    private String os;

    @ManyToMany
    private List<User> users;

    public Pc() {}

    public Pc(String identifier_cod, String java_version, User user) {
        this.identifier_cod = identifier_cod;
        this.java_version = java_version;
        this.users.add(user);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTotal_memory() {
        return total_memory;
    }

    public void setTotal_memory(String total_memory) {
        this.total_memory = total_memory;
    }

    public Long getId() {
        return id;
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

    public String getIdentifier_cod() {
        return identifier_cod;
    }

    public void setIdentifier_cod(String identifier_cod) {
        this.identifier_cod = identifier_cod;
    }

    public String getJava_version() {
        return java_version;
    }

    public void setJava_version(String java_version) {
        this.java_version = java_version;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "id=" + id +
                ", identifier_cod='" + identifier_cod + '\'' +
                ", java_version='" + java_version + '\'' +
                '}';
    }
}

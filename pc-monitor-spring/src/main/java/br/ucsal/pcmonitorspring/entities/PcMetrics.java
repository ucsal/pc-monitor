package br.ucsal.pcmonitorspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties({"id_pc", "register_time", "cpu_use", "internet_status", "gpu_use", "memory_use", "disc_use", "temperature"})
@Entity
@Table(name = "pc_metrics")
public class PcMetrics {
    @Id
    @Column(name = "id_pc", nullable = false)
    private Long id_pc;
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "register_time", length = 30, nullable = false)
    private String register_time;

    @Column(name = "cpu_use", length = 30, nullable = false)
    private String cpu_use;

    @Column(name = "internet_status", length = 30, nullable = false)
    private String internet_status;

    @Column(name = "gpu_use", length = 30, nullable = false)
    private String gpu_use;

    @Column(name = "memory_use", length = 30, nullable = false)
    private String memory_use;

    @Column(name = "disc_use", length = 30, nullable = false)
    private String disc_use;

    @Column(name = "temperature", length = 30, nullable = false)
    private String temperature;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PcMetrics() {}
    public PcMetrics(String nome){
        this.name = nome;
    }

    public Long getId_pc() {
        return id_pc;
    }

    public void setId_pc(Long id_pc) {
        this.id_pc = id_pc;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    @Override
    public String toString() {
        return "PcMetrics{" +
                "nome='" + name + '\'' +
                '}';
    }
}

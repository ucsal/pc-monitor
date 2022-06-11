package br.ucsal.pcmonitorspring.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "pc_metrics")
public class PcMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_metrics_id")
    private Long id;
    
    //@json
    //criar objeto dto

    @ManyToOne
    @JoinColumn(nullable = false, name = "pc")
    private Pc pc;

    @Column(name = "cpu_use", nullable = false)
    private String cpuUse;

    @Column(name = "free_memory", nullable = false)
    private String freeMemory;

    private String username;
    
    //adicionar o timestamping

    public PcMetrics() {}

    public PcMetrics(String cpuUse, String freeMemory, String username, Pc pc) {
        this.cpuUse = cpuUse;
        this.freeMemory = freeMemory;
        this.username = username;
        this.pc = pc;
    }
}

package br.ucsal.pcmonitorspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "pc_metrics")
public class PcMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_metrics_id")
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false, name = "pc")
    private Pc pc;

    @Column(name = "cpu_use")
    private String cpuUse;

    @Column(name = "free_memory")
    private String freeMemory;

    public PcMetrics() {}
    
    public PcMetrics(String cpuUse, String freeMemory) {
    	this.cpuUse = cpuUse;
    	this.freeMemory = freeMemory;
    }

    public Pc getPc() {
        return pc;
    }

    public Long getId() {
        return id;
    }

    public void setPc(Pc pc) {
        this.pc = pc;
    }

    public String getCpuUse() {
        return cpuUse;
    }

    public void setCpuUse(String cpuUse) {
        this.cpuUse = cpuUse;
    }

    public String getFree_memory() {
        return freeMemory;
    }

    public void setFree_memory(String free_memory) {
        this.freeMemory = free_memory;
    }
}

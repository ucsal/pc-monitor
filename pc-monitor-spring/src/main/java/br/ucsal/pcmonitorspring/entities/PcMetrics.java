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
    private String cpuUSe;

    @Column(name = "memory_use")
    private String memoryUse;

    public PcMetrics() {}

    public Pc getPc() {
        return pc;
    }

    public Long getId() {
        return id;
    }

    public void setPc(Pc pc) {
        this.pc = pc;
    }

    public String getCpuUSe() {
        return cpuUSe;
    }

    public void setCpuUSe(String cpuUSe) {
        this.cpuUSe = cpuUSe;
    }

    public String getMemoryUse() {
        return memoryUse;
    }

    public void setMemoryUse(String memoryUse) {
        this.memoryUse = memoryUse;
    }
}

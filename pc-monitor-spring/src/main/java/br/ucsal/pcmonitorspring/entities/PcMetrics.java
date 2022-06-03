package br.ucsal.pcmonitorspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "pc_metrics")
public class PcMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pc_metrics_id;

    @OneToOne
    @JoinColumn(nullable = false)
    private Pc pc_id;

    private String cpu_use;

    private String memory_use;

    public PcMetrics() {}

    public Pc getPc_id() {
        return pc_id;
    }

    public Long getPc_metrics_id() {
        return pc_metrics_id;
    }

    public void setPc_id(Pc pc_id) {
        this.pc_id = pc_id;
    }

    public String getCpu_use() {
        return cpu_use;
    }

    public void setCpu_use(String cpu_use) {
        this.cpu_use = cpu_use;
    }

    public String getMemory_use() {
        return memory_use;
    }

    public void setMemory_use(String memory_use) {
        this.memory_use = memory_use;
    }
}

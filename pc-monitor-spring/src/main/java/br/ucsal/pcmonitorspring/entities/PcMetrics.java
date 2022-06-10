package br.ucsal.pcmonitorspring.entities;

import javax.persistence.*;

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

    @Column(name = "cpu_use")
    private String cpuUse;

    @Column(name = "free_memory")
    private String freeMemory;
    
    private String username;
    
    //adicionar o timestamping

    public PcMetrics() {}

    public Pc getPc() {
        return pc;
    }
    
    

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

    public String getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(String freeMemory) {
        this.freeMemory = freeMemory;
    }
}

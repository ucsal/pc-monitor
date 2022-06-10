package br.ucsal.pcmonitorspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PcMetricsDTO {

    private String cpuUse;

    private String freeMemory;

    private String username;

    private String pcCode;
}

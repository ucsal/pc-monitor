package com.pcobserver.models;

public class Metrics {
	
	String cpuUse;
	String freeMemory;
	
	
	public Metrics(String cpuUsagePercentage, String freeRamMemory) {
		super();
		this.cpuUse = cpuUsagePercentage;
		this.freeMemory = freeRamMemory;
	}

}

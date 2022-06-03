package com.pcobserver.models;

public class Metrics {
	
	String cpuUsagePercentage;
	String FreeRamMemory;
	
	
	public Metrics(String cpuUsagePercentage, String freeRamMemory) {
		super();
		this.cpuUsagePercentage = cpuUsagePercentage;
		this.FreeRamMemory = freeRamMemory;
	}

}

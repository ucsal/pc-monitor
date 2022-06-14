package com.pcobserver.models;

public class Metrics {
	String pcCode;
	String cpuUse;
	String freeMemory;
	String username;
	
	
	public Metrics(String pcCode,String cpuUsagePercentage, String freeRamMemory, String username) {
		super();
		this.pcCode = pcCode;
		this.cpuUse = cpuUsagePercentage;
		this.freeMemory = freeRamMemory;
		this.username = username;
	}

}

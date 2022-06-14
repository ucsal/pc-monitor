package com.pcobserver.models;

public class Metrics {
	
	String cpuUse;
	String freeMemory;
	String username;
	
	
	public Metrics(String cpuUsagePercentage, String freeRamMemory, String username) {
		super();
		this.cpuUse = cpuUsagePercentage;
		this.freeMemory = freeRamMemory;
		this.username = username;
	}

}

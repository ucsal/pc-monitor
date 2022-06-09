package com.pcobserver.models;

public class PC {
	
	String idenfierCod;
	String javaVersion;
	String os;
	String totalMemory;
	
	public PC(String hostname, String javaVersion) {
		super();
		this.idenfierCod = hostname;
		this.javaVersion = javaVersion;
	}
	
	
}

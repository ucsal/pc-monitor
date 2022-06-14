package com.pcobserver.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class getData {
	public static String getOsName() {
		return System.getProperty("os.name");
	}

	public static String getJavaVersion() {
		return System.getProperty("java.version");
	}	

	public static String getUserName() {
		return System.getProperty("user.name");
	}
	
	private static String getFromTerminal(String command) throws IOException {
		Process process = Runtime.getRuntime().exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String[] arr = command.split(" ");
		String ignore = arr[arr.length-1];
	    while (true) {
	    	String str = reader.readLine();
			if(str==null){
				return "-1";
			}
	    	if(!str.trim().equalsIgnoreCase(ignore) && !str.isBlank()) {
	    		return str.trim();
	    	}
	    }
	}
	/**
	 * run a command in terminal to retrieve CPU usage percentage data
	 * 
	 * @return CPU usage percentage 
	 * **/
	public static Integer getCpuUsagePercent() throws IOException {
		 return  Integer.valueOf(getFromTerminal("wmic cpu get loadpercentage"));

	}
	/**
	 * run a command in terminal to retrieve free memory ram data
	 * @return free memory RAM in Megabyte
	 * **/
	public static Integer getFreeRamMemory() throws IOException {
	   return  Integer.valueOf(getFromTerminal("wmic os get freephysicalmemory"))/1024/1024;
	}
	/**run a command in terminal to retrieve total memory ram data
	 * @return total memory RAM in Megabyte
	 * **/
	public static Long getTotalRamMemory() throws IOException {
		 return  Long.valueOf(getFromTerminal("wmic ComputerSystem get TotalPhysicalMemory"))/1024/1024/1024;
	}
	
	
	
	public static String getHostName() throws UnknownHostException {

		 return InetAddress.getLocalHost().getHostName();
		
	}
	
	
}

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

	public static String getCpuUsage() throws IOException {
		Process process;
		

		process = Runtime.getRuntime().exec("wmic cpu get loadpercentage");
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		String line = "";
	    while ((line = reader.readLine()) != null) {
	        System.out.println(line);
	        if(!line.contains("LoadPercentage")) return line;
	    }

		return null;
	}
	
	
	public static String getHostName() throws UnknownHostException {

		 return InetAddress.getLocalHost().getHostName();
		
	}
	
	
}

package com.pcobserver.utils;

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
}

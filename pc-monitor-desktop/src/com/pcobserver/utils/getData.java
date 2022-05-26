package com.pcobserver.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	
	public static String getHostName() throws UnknownHostException {

		 return InetAddress.getLocalHost().getHostName();
		
	}
	
	
}

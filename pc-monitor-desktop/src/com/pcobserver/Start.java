package com.pcobserver;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

import com.google.gson.Gson;
import com.pcobserver.models.Metrics;
import com.pcobserver.models.PC;
import com.pcobserver.utils.getData;
import com.pcobserver.utils.sendRequest;
import com.pcobserver.utils.getData;


public class Start {

	public static void main(String[] args) {

		
		new Start();

		try {
			String json ="";

			json = new Gson().toJson(new PC(getData.getHostName(),getData.getJavaVersion(),getData.getOsName(),String.valueOf(getData.getTotalRamMemory()) ));
			System.out.println(json);
			sendRequest.executePost("http://localhost:8080/api/pc",json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
		  @Override
		  public void run() {
				
				try {
					String json ="";
					json = new Gson().toJson(new Metrics(String.valueOf(getData.getCpuUsagePercent()) ,String.valueOf(getData.getFreeRamMemory()), getData.getUserName()) );
					System.out.println(json);
					sendRequest.executePost("http://localhost:8080/api/pcMetrics",json);
				} catch (IOException e1) {

					e1.printStackTrace();
				}

		  }
		}, 0, 5*(1000*60));
		

	}
	
	public Start() {
		TrayIcon trayIcon = null;
		if (SystemTray.isSupported()) {
			
			SystemTray tray = SystemTray.getSystemTray();
			
			final URL pngComputador = getClass().getResource("ICON.png");
			Image image = Toolkit.getDefaultToolkit().createImage(pngComputador);
			ActionListener exitListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Encerrado");
					System.exit(0);
				}
			};

			PopupMenu popup = new PopupMenu();
	
			MenuItem defaultItem = new MenuItem("Encerrar");
			defaultItem.addActionListener(exitListener);
			popup.add(defaultItem);

			trayIcon = new TrayIcon(image, "PC Observer", popup);
			trayIcon.setImageAutoSize(true);

			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println(e);
			}
			
		}
	}

}

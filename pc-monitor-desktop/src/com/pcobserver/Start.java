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

		
			
		
		try {
			String json ="";
			json = new Gson().toJson(new PC(getData.getHostName(),getData.getJavaVersion()));
			sendRequest.executePost("http://localhost:8080/api",json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
		  @Override
		  public void run() {
				
				try {
					String json ="";
					json = new Gson().toJson(new Metrics(String.valueOf(getData.getCpuUsagePercent()) ,String.valueOf(getData.getFreeRamMemory())) );
					sendRequest.executePost("http://localhost:8080/api",json);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		  }
		}, 0, 5*(1000*60));
		new Start();

	}
	
	public Start() {
		TrayIcon trayIcon = null;
		if (SystemTray.isSupported()) {
			// get the SystemTray instance
			SystemTray tray = SystemTray.getSystemTray();
			// load an image
			final URL pngComputador = getClass().getResource("computador.png");
			Image image = Toolkit.getDefaultToolkit().createImage(pngComputador);
			ActionListener exitListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// execute default action of the application
					System.out.println("Encerrado");
					System.exit(0);
				}
			};
			//	         // create a popup menu
			PopupMenu popup = new PopupMenu();
			//	         // create menu item for the default action
			MenuItem defaultItem = new MenuItem("Encerrar");
			defaultItem.addActionListener(exitListener);
			popup.add(defaultItem);
			/// ... add other items
			// construct a TrayIcon
			trayIcon = new TrayIcon(image, "PC Observer", popup);
			trayIcon.setImageAutoSize(true);
			// set the TrayIcon properties
			//	         trayIcon.addActionListener(listener);
			// ...
			// add the tray image
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println(e);
			}
			// ...
		} else {
			// disable tray option in your application or
			// perform other actions
		}
	}

}

package com.pcobserver;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;

import com.pcobserver.utils.getData;


public class Start {

	public static void main(String[] args) {
		
		try {
			System.out.println(getData.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

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

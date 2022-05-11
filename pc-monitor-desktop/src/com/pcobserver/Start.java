package com.pcobserver;

import java.awt.*;
import java.awt.event.*;


public class Start {

	public static void main(String[] args) {
		new Start();
	}
	public Start() {
		TrayIcon trayIcon = null;
	     if (SystemTray.isSupported()) {
	         // get the SystemTray instance
	         SystemTray tray = SystemTray.getSystemTray();
	         // load an image
	         Image image = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("computador.png"));
	         ActionListener listener = new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	                 // execute default action of the application
	                 // ...
	             }
	         };
	         // create a popup menu
	         PopupMenu popup = new PopupMenu();
	         // create menu item for the default action
	         MenuItem defaultItem = new MenuItem();
	         defaultItem.addActionListener(listener);
	         popup.add(defaultItem);
	         /// ... add other items
	         // construct a TrayIcon
	         trayIcon = new TrayIcon(image, "PC Observer", popup);
	         // set the TrayIcon properties
	         trayIcon.addActionListener(listener);
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

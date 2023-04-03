package javaapplication1;

import java.awt.*;
import javax.swing.*;
public class TestJWindow {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//On crée une nouvelle instance de notre JWindow
				JWindow window = new JWindow();
				window.setSize(300, 200);//On lui donne une taille pour qu'on puisse la voir
				window.setVisible(true);//On la rend visible
			}
		});
                try { 
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
 
		System.exit(0);
		
	}
}
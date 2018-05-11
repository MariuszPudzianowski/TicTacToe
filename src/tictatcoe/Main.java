package tictatcoe;

import java.awt.EventQueue;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Engine engine = new Engine(); // Presenter
			}
		});
	}
	
}
/* 
 * TODO:
 * - change the score field to indicate players
 */
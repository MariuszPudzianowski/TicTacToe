package src;

import java.awt.EventQueue;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Engine engine = new Engine(); // Presentation
			}
		});
	}
	
}
/* 
 * TODO:
 * - handle draws
 * - if game didn't end, don't switch players on restart
 */
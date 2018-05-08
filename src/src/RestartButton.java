package src;

import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;

public class RestartButton extends JButton {
	
	public RestartButton(Engine engine) {
		super("Restart");
		setMaximumSize(new Dimension(100, 50));
		setAlignmentX(Component.CENTER_ALIGNMENT);
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.onRestartButtonClick();
			}
		});
	}

}

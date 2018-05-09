package tictatcoe;

import javax.swing.*;
import java.awt.event.*;

public class XOButton extends JButton {
	
	public XOButton(Engine engine) {
		addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.onXOButtonClick(e);
			}
		});
	}
	
}

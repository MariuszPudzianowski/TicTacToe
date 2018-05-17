package tictatcoe;

import java.awt.*;
import javax.swing.*;

public class ScorePanel extends JPanel{
	
	private JTextField scoreField;
	private JTextField xField, oField;
	
	class ScorePanelElement extends JTextField {
		private ScorePanelElement (String text, int x, int y, Font f, Color color) {
			super(text);
			setMaximumSize(new Dimension(x, y));
			setAlignmentX(Component.CENTER_ALIGNMENT);
			
			setFont(f);
			setForeground(color);
			setHorizontalAlignment(JTextField.CENTER);
			
			setEditable(false);
			setHighlighter(null);
		}
	}
	
	public ScorePanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		Font f = new Font(Font.DIALOG, Font.PLAIN, 40);
		
		xField = new ScorePanelElement("X", 40, 50, f, Color.BLUE);
		add(xField);
		
		scoreField = new ScorePanelElement("0-0", 80, 50, f, Color.BLACK);
		add(scoreField);
		
		oField =  new ScorePanelElement("O", 40, 50, f, Color.RED);
		add(oField);
	}
	
	public void resizeScoreField() {
		scoreField.setMaximumSize(new Dimension(120, 50));
	}
	
	public void updateScore(int scoreX, int scoreO) {
		String scoreString = "" + scoreX + '-' + scoreO;
		scoreField.setText(scoreString);
	}
}

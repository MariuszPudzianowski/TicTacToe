package tictatcoe;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GameWindow extends JFrame {
	private JSplitPane splitPane;
	
	private JPanel boardPanel;
	private XOButton[][] boardButtons;
	private ImageIcon x, o;
	
	private JPanel userPanel;
	private JTextField scoreField;
	private RestartButton restartButton;
	
	public GameWindow(Engine engine) {
		super("TicTacToe");
		setSize(600, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		boardButtons = new XOButton[3][3];
		x = new ImageIcon("img/x.png");
		o = new ImageIcon("img/o.png");
		
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(400);
        splitPane.setEnabled(false);

		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boardButtons[i][j] = new XOButton(engine);
				boardPanel.add(boardButtons[i][j]);
			}
		}
		
		userPanel = new JPanel();
		userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.PAGE_AXIS));
		
		scoreField = new JTextField("0-0");
		scoreField.setMaximumSize(new Dimension(100, 50));
		scoreField.setAlignmentX(Component.CENTER_ALIGNMENT);
		Font f = new Font(Font.DIALOG, Font.PLAIN, 40);
		scoreField.setFont(f);
		scoreField.setHorizontalAlignment(JTextField.CENTER);
		scoreField.setEditable(false);
		userPanel.add(scoreField);
		
		userPanel.add(Box.createRigidArea(new Dimension(100, 30)));
		
		restartButton = new RestartButton(engine);
		userPanel.add(restartButton);
		
        splitPane.setLeftComponent(boardPanel);
        splitPane.setRightComponent(userPanel);
		add(splitPane);
		
		setVisible(true);
	}
	
	public void disableBoardButtons() {
		for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
		    	boardButtons[i][j].setEnabled(false);
		    }
		}
	}
	
	public void restartBoardButtons() {
		for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
		    	boardButtons[i][j].setIcon(null);
		    	boardButtons[i][j].setDisabledIcon(null);
		    	boardButtons[i][j].setEnabled(true);
		    }
		}
	}
	
	public int[] findSourceIndices(ActionEvent e) {
		int[] indices = new int[2];
		for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
				if (boardButtons[i][j] == e.getSource()) {
					indices[0] = i;
					indices[1] = j;
				}
		    }
		}
		return indices;
	}
	
	public void setBoardIconAt(int[] indices, char currentSymbol) {
		int r = indices[0];
		int c = indices[1];
		
		switch(currentSymbol) {
		case 'x':
			boardButtons[r][c].setIcon(x);
			boardButtons[r][c].setDisabledIcon(x);
			break;
		case 'o':
			boardButtons[r][c].setIcon(o);
			boardButtons[r][c].setDisabledIcon(o);
			break;
		}
		boardButtons[r][c].setEnabled(false);
	}
	
	public void updateScore(int scoreX, int scoreO) {
		String scoreString = "" + scoreX + '-' + scoreO;
		scoreField.setText(scoreString);
	}
	
	public void showEndGameDialog(Player currentPlayer) {
		String endGameString = "Player '" + currentPlayer.getSymbol() + "' won!";
		JOptionPane.showMessageDialog(this, endGameString);
	}
	
	public void showDrawGameDialog() {
		JOptionPane.showMessageDialog(this, "Game drawn!");
	}
	
}

package tictatcoe;

public class Board {
	private char[][] boardState = new char[3][3];
	
	public char[][] getBoardState() {
		return boardState;
	}
	
	public void setValueAt(int i, int j, char currentSymbol) {
		boardState[i][j] = currentSymbol;
	}
	
	public boolean isFilled() {
		for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
		    	if (boardState[i][j] != 'x' && boardState[i][j] != 'o')
		    		return false;
		    }
		}
		return true;
	}
	
}

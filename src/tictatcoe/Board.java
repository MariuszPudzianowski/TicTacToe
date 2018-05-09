package tictatcoe;

public class Board {
	private char[][] boardState = new char[3][3];
	
	public void restartBoardState() {
		for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
		    	boardState[i][j] = 'n'; // neither 'x' nor 'o'
		    }
		}
	}
	
	public char[][] getBoardState() {
		return boardState;
	}
	
	public void setBoardStateAt(int i, int j, char currentSymbol) {
		boardState[i][j] = currentSymbol;
	}
	
}

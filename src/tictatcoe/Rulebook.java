package tictatcoe;

public class Rulebook {

	public boolean gameWon(char[][] boardState, char symbol) {
		for (int i=0; i < 3; i++) {
			if (boardState[i][0] == symbol && boardState[i][1] == symbol && boardState[i][2] == symbol) {
				return true;
			}
			if (boardState[0][i] == symbol && boardState[1][i] == symbol && boardState[2][i] == symbol) {
				return true;
			}
		}
		if (boardState[0][0] == symbol && boardState[1][1] == symbol && boardState[2][2] == symbol) {
			return true;
		}
		if (boardState[2][0] == symbol && boardState[1][1] == symbol && boardState[0][2] == symbol) {
			return true;
		}
		return false;
	}
	
	public boolean gameDrawn(Board board) {
		return board.isFilled();
			
	}
	
}

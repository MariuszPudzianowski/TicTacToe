package tictatcoe;

public class Player {
	private char symbol;
	private int score;
	
	public Player(char symbol) {
		this.symbol = symbol;
		score = 0;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}

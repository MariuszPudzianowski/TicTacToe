package tictatcoe;

public class Game {
	private Engine engine;
	private Rulebook rulebook;
	private Board board;
	private Player playerX;
	private Player playerO;
	private final Player startingPlayer;
	private Player currentPlayer;
	
	private boolean ended;
	
	/// constructors, constructor-only methods, getters and setters ///
	{
		rulebook  = new Rulebook();
		board = new Board();
		
		ended = false;
	}
	
	public Game(Engine engine) {
		this.engine = engine;
		playerX = new Player('x');
		playerO = new Player('o');
		startingPlayer = playerX;
		currentPlayer = startingPlayer;
	}
	
	public Game(Engine engine, Game lastGame) {
		this.engine = engine;
		playerX = lastGame.playerX;
		playerO = lastGame.playerO;
		startingPlayer = findStartingPlayer(lastGame.didEnd(), lastGame.getStartingPlayer());
		currentPlayer = startingPlayer;
	}
	
	private Player findStartingPlayer(boolean lastEnded, Player lastStartingPlayer) {
		if (lastEnded) {
			if (lastStartingPlayer == playerX)
				return playerO;
			else
				return playerX;
		} else {
			return lastStartingPlayer;
		}
	}
	
	public Player getStartingPlayer() {
		return startingPlayer;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void setCurrentPlayer(Player player) {
		currentPlayer = player;
	}
	
	public boolean didEnd() {
		return ended;
	}
	
	/// other methods ///
	public void setBoardStateAt(int[] indices) {
		board.setValueAt(indices[0], indices[1], currentPlayer.getSymbol());
	}
	
	public void nextMove() {
		if (rulebook.gameWon(board.getBoardState(), currentPlayer.getSymbol()))
			end();
		else if (rulebook.gameDrawn(board))
			draw();
		else
			nextPlayer();
	}
	
	private void nextPlayer() {
		if (currentPlayer == playerX)
			currentPlayer = playerO;
		else
			currentPlayer = playerX;
	}
	
	private void end() {
		ended = true;
		currentPlayer.setScore(currentPlayer.getScore() + 1);
		engine.endGameViewUpdate(currentPlayer, playerX.getScore(), playerO.getScore());
	}
	
	private void draw() {
		engine.drawGameViewUpdate(playerX.getScore(), playerO.getScore());
	}
	
}

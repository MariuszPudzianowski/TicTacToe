package src;

public class Game {
	private Engine engine;
	private Rulebook rulebook;
	private Player playerX;
	private Player playerO;
	private Player startingPlayer;
	private Player currentPlayer;
	
	/// constructors, getters and setters ///
	public Game(Engine engine) {
		this.engine = engine;
		rulebook  = new Rulebook();
		playerX = new Player('x');
		playerO = new Player('o');
		startingPlayer = playerX;
		currentPlayer = startingPlayer;
	}
	
	public Game(Engine engine, Game lastGame) {
		this.engine = engine;
		rulebook  = new Rulebook();
		playerX = lastGame.playerX;
		playerO = lastGame.playerO;
		alterStartingPlayer(lastGame.getStartingPlayer());
		currentPlayer = startingPlayer;
	}
	
	public Player getStartingPlayer() {
		return startingPlayer;
	}
	
	private void alterStartingPlayer(Player lastStartingPlayer) {
		if (lastStartingPlayer == playerX)
			startingPlayer = playerO;
		else
			startingPlayer = playerX;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void setCurrentPlayer(Player player) {
		currentPlayer = player;
	}
	
	/// other methods ///
	public void nextMove(char[][] boardState) {
		if (!rulebook.playerWon(boardState, currentPlayer.getSymbol()))
			nextPlayer();
		else
			end();
	}
	
	private void nextPlayer() {
		if (currentPlayer == playerX)
			currentPlayer = playerO;
		else
			currentPlayer = playerX;
	}
	
	private void end() {
		currentPlayer.setScore(currentPlayer.getScore() + 1);
		engine.endGameViewUpdate(currentPlayer, playerX.getScore(), playerO.getScore());
	}
	
}

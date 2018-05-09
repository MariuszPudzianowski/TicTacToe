package tictatcoe;

import java.awt.event.ActionEvent;

public class Engine {
	private Game game; // Model
	private Board board; // Model
	private GameWindow wnd; // View
	
	public Engine() {
		game = new Game(this);
		board = new Board();
		wnd = new GameWindow(this);
	}
	
	public void onXOButtonClick(ActionEvent e) {
		Player currentPlayer = game.getCurrentPlayer();
		int[] indices = wnd.findSourceIndices(e);
		board.setBoardStateAt(indices[0], indices[1], currentPlayer.getSymbol());
		wnd.setBoardIconAt(indices[0], indices[1], currentPlayer.getSymbol());
		game.nextMove(board.getBoardState());
	}
	
	public void onRestartButtonClick() {
		board.restartBoardState();
		wnd.restartBoardButtons();
		game = new Game(this, game);
	}
	
	public void endGameViewUpdate(Player currentPlayer, int scoreX, int scoreO) {
		wnd.disableBoardButtons();
		wnd.updateScore(scoreX, scoreO);
		wnd.showEndGameDialog(currentPlayer);
	}
	
}

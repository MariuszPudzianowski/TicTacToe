package tictatcoe;

import java.awt.event.ActionEvent;

public class Engine {
	private Game game; // Model
	private GameWindow wnd; // View

	public Engine() {
		game = new Game(this);
		wnd = new GameWindow(this);
	}
	
	public void onXOButtonClick(ActionEvent e) {
		int[] indices = wnd.findSourceIndices(e);
		game.setBoardStateAt(indices);
		wnd.setBoardIconAt(indices, game.getCurrentPlayer().getSymbol());
		game.nextMove();
	}
	
	public void onRestartButtonClick() {
<<<<<<< HEAD
		board.resetBoardState();
		wnd.resetBoardButtons();
=======
		wnd.restartBoardButtons();
>>>>>>> new
		game = new Game(this, game);
	}
	
	public void endGameViewUpdate(Player currentPlayer, int scoreX, int scoreO) {
		wnd.disableBoardButtons();
		if ((scoreX == 10 && scoreO >= 10) || (scoreX >= 10 && scoreO == 10))
			wnd.resizeScoreField();
		wnd.updateScore(scoreX, scoreO);
		wnd.showEndGameDialog(currentPlayer);
	}
	
	public void drawGameViewUpdate(int scoreX, int scoreO) {
		wnd.showDrawGameDialog();
	}
	
}

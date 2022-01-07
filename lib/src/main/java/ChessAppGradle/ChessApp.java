package ChessAppGradle;


import domain.*;
import tools.BoardTextRenderer;


public class ChessApp {

	public static void main(String[] args) {
		
		//Create new Game
		Game currentGame = new Game();
		
		//Separate class to handle rendering of the game. Starting with text/console rendering for testing.
		BoardTextRenderer textRenderer = new BoardTextRenderer();
		
		//Display the game board.
		textRenderer.render(currentGame.getGameBoard());
		
	}

}

package domain;

/**
 * Class that can be used to create new game instances. Complete with board and game pieces.
 * 
 * @author JoshuaKnippel
 *
 */
public class Game {
	
	//================================================================================
	// Variables
	//================================================================================
	
	private BoardSpace[][] gameBoard = new BoardSpace[8][8];
	
	//================================================================================
	// Constructors
	//================================================================================
	
	/**
	 * Create a new {@link Game} instance.
	 */
	public Game() {
		this.assembleGameBoard();
		this.populateGameBoard();
	}
	
	//================================================================================
	// Methods
	//================================================================================
	
	//PUBLIC
	
	/**
	 * Sets the instances gameBoard reference value to that of the
	 * multidimensional BoardSpace array provided to the method.
	 * @param gameBoard
	 */
	public void setGameBoard(BoardSpace[][] gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	/**
	 * Returns a reference to the instances gameBoard member.
	 * @return
	 */
	public BoardSpace[][] getGameBoard() {
		return this.gameBoard;
	}
	
	/**
	 * Returns a reference to the {@link BoardSpace} at the grid 
	 * coordinate provided to the method as separate int's for row and column.
	 * @param r
	 * @param c
	 * @return
	 */
	public BoardSpace getBoardSpace(int r, int c) {
		return gameBoard[r][c];
	}

	//PRIVATE
	
	/*
	 * -Private
	 * Inserts references to new instances of {@link BoardSpace} into 
	 * the instances multidimensional BoardSpace array gameBoard.
	 */
	private void assembleGameBoard() {
		
		//create the multidimensional array of board spaces to model the game board
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				this.gameBoard[r][c] = new BoardSpace();
			}
		}		
	}
	
	/*
	 * -Private
	 * Sets all game pieces in their default starting place on gameBoard. 
	 * Directly accesses the multidimensional BoardSpace array gameBoard 
	 * which returns a BoardSpace reference. Use the BoardSpace object's 
	 * appropriate method to set the game piece 'on' the space.
	 */
	private void populateGameBoard() {
		
		//Chose to access the array directly to reduce method calls.
		this.gameBoard[0][0].setCurrentGamePiece(new Rooke());
		this.gameBoard[0][1].setCurrentGamePiece(new Knight());
		this.gameBoard[0][2].setCurrentGamePiece(new Bishop());
		this.gameBoard[0][3].setCurrentGamePiece(new Queen());
		this.gameBoard[0][4].setCurrentGamePiece(new King());
		this.gameBoard[0][5].setCurrentGamePiece(new Bishop());
		this.gameBoard[0][6].setCurrentGamePiece(new Knight());
		this.gameBoard[0][7].setCurrentGamePiece(new Rooke());
		this.gameBoard[1][0].setCurrentGamePiece(new Pawn());
		this.gameBoard[1][1].setCurrentGamePiece(new Pawn());
		this.gameBoard[1][2].setCurrentGamePiece(new Pawn());
		this.gameBoard[1][3].setCurrentGamePiece(new Pawn());
		this.gameBoard[1][4].setCurrentGamePiece(new Pawn());
		this.gameBoard[1][5].setCurrentGamePiece(new Pawn());
		this.gameBoard[1][6].setCurrentGamePiece(new Pawn());
		this.gameBoard[1][7].setCurrentGamePiece(new Pawn());		
		
		this.gameBoard[7][0].setCurrentGamePiece(new Rooke());
		this.gameBoard[7][1].setCurrentGamePiece(new Knight());
		this.gameBoard[7][2].setCurrentGamePiece(new Bishop());
		this.gameBoard[7][3].setCurrentGamePiece(new Queen());
		this.gameBoard[7][4].setCurrentGamePiece(new King());
		this.gameBoard[7][5].setCurrentGamePiece(new Bishop());
		this.gameBoard[7][6].setCurrentGamePiece(new Knight());
		this.gameBoard[7][7].setCurrentGamePiece(new Rooke());
		this.gameBoard[6][0].setCurrentGamePiece(new Pawn());
		this.gameBoard[6][1].setCurrentGamePiece(new Pawn());
		this.gameBoard[6][2].setCurrentGamePiece(new Pawn());
		this.gameBoard[6][3].setCurrentGamePiece(new Pawn());
		this.gameBoard[6][4].setCurrentGamePiece(new Pawn());
		this.gameBoard[6][5].setCurrentGamePiece(new Pawn());
		this.gameBoard[6][6].setCurrentGamePiece(new Pawn());
		this.gameBoard[6][7].setCurrentGamePiece(new Pawn());
	}
	

}

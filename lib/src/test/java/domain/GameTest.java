package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

/**
 * This is a junit test for the Game.java class.
 * 
 * @author JoshuaKnippel
 *
 */
@DisplayName("Test Game class")
public class GameTest {
	
	private Game game;
	
	/**
	 * Builds new {@link Game} instance before each test
	 */
	@BeforeEach
	public void beforeEach () {
		game = new Game();
	}
	
	/**
	 * Tests to make sure that all 64 indices of the gameBoad 
	 * array[8][8] contain a reference to a BoardSpace object. 
	 * Imports a .csv of gameBoard coordinates as an argument source.
	 * @param r
	 * @param c
	 */
	@ParameterizedTest(name = "{index}> c: {0},{1}")
	@CsvFileSource(resources = "/boardCoordinates.csv")
	@DisplayName("All indices of 8 x 8 gameboard array contain a BoardSpace object reference")
	public void testAssembleGameBoard(int r, int c) {
		assertEquals(game.getBoardSpace(r, c).getClass(), BoardSpace.class, "Not a BoardSpace.class object");		
	}
	
	/**
	 * Test to ensure get() returns correct gameBoard after a set()
	 */
	@Test
	@DisplayName ("gameBoard getter/setter returns correct value")
	public void testGetSetGameBoard( ) {
		BoardSpace[][] gameBoard = new BoardSpace[8][8];
		game.setGameBoard(gameBoard);
		assertEquals(gameBoard, game.getGameBoard());		
	}
	
	/**
	 * Tests to ensure get() returns the correct BoardSpace.
	 */
	@Test
	@DisplayName("BoardSpace getter returns correct value")
	public void testGetBoardSpace() {
		BoardSpace[][] gameBoard = new BoardSpace[8][8];
		gameBoard[0][0] = new BoardSpace();
		game.setGameBoard(gameBoard);
		assertEquals(gameBoard[0][0], game.getBoardSpace(0, 0));
	}
	
	/**
	 * Tests to ensure that the game board is populated with 
	 * the game pieces and that they are in the correct locations.
	 * 
	 * Uses a .csv file source for argument list. The .csv contains 
	 * a coordinate -> piece 'mapping'. Uses the {@link StringToClassConverter.class} 
	 * to prevent the need to add the package name in the csv.
	 * @param r
	 * @param c
	 * @param gp
	 */
	@ParameterizedTest(name = "{index}>	c: {0},{1} contains {2}")
	@CsvFileSource(resources = "/pieceStartingCoordinates.csv")
	@DisplayName("Game pieces placed in correct starting positiion")
	public void testPopulateGameBoard(int r, int c, @ConvertWith(StringToClassConverter.class) Class<? extends GamePiece> gp) {
		assertEquals(gp, game.getBoardSpace(r, c).getCurrentGamePiece().getClass());
	}
	

}

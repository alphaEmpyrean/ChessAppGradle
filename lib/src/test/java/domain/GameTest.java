package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

@DisplayName("Test Game Class")
public class GameTest {
	
	static Game game;
	
	@BeforeEach
	public void beforeEach () {
		game = new Game();
	}
	
	@ParameterizedTest(name = "{index}> c: {0},{1}")
	@CsvFileSource(resources = "/boardCoordinates.csv")
	@DisplayName("All indices of 8 x 8 gameboard array contain a BoardSpace object reference")
	public void testAssembleGameBoard(int r, int c) {
		assertEquals(game.getBoardSpace(r, c).getClass(), BoardSpace.class, "Not a BoardSpace.class object");		
	}
	
	@Test
	@DisplayName ("gameBoard getter/setter returns correct value")
	public void testGetSetGameBoard( ) {
		BoardSpace[][] gameBoard = new BoardSpace[8][8];
		game.setGameBoard(gameBoard);
		assertEquals(gameBoard, game.getGameBoard());		
	}
	
	@Test
	@DisplayName("BoardSpace getter returns correct value")
	public void testGetBoardSpace() {
		BoardSpace[][] gameBoard = new BoardSpace[8][8];
		gameBoard[0][0] = new BoardSpace();
		game.setGameBoard(gameBoard);
		assertEquals(gameBoard[0][0], game.getBoardSpace(0, 0));
	}
	
	@ParameterizedTest(name = "{index}>	c: {0},{1} contains {2}")
	@CsvFileSource(resources = "/pieceStartingCoordinates.csv")
	@DisplayName("Game pieces placed in correct starting positiion")
	public void testPopulateGameBoard(int r, int c, @ConvertWith(StringToClassConverter.class) Class<? extends GamePiece> gp) {
		assertEquals(gp, game.getBoardSpace(r, c).getCurrentGamePiece().getClass());
	}
	

}

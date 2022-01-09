package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This is a junit test for the BoardSpace.java class
 * 
 * @author JoshuaKnippel
 *
 */
@DisplayName("Test BoardSpace class")
public class BoardSpaceTest {

	private BoardSpace boardSpace;
	private GamePiece gamePiece;
	
	/**
	 * Builds new BoardSpace and GamePiece instance before each test
	 */
	@BeforeEach
	public void beforeEach() {
		boardSpace = new BoardSpace();
		gamePiece = new Queen();
	}
	
	/**
	 * Test to ensure that a get() returns the correct {@link GamePiece} after a set()
	 */
	@Test
	@DisplayName("currentGamePiece getter/setter returns correct value")
	public void testGetSetCurrentGamePiece() {
		boardSpace.setCurrentGamePiece(gamePiece);
		assertEquals(gamePiece, boardSpace.getCurrentGamePiece());
	}
	
	/**
	 * Test to make sure isOccupied() returns false when currentGamePiece is null
	 */
	@Test
	@DisplayName("isOccupied() returns false when currentGamePiece is null")
	public void testIsNotOccupied() {
		assertFalse(boardSpace.isOccupied());
	}
	
	/**
	 * Test to make sure isOccupied() returns true when currentGamePiece contains 
	 * a reference to a Class<? extends GamePiece>
	 */
	@Test
	@DisplayName("isOccuped() returns true when currentGamePiece contains a game piece")
	public void testIsOccupied() {
		boardSpace.setCurrentGamePiece(gamePiece);
		assertTrue(boardSpace.isOccupied());
	}
}

package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This is a junit test for the GamePiece.java class.
 * 
 * @author JoshuaKnippel
 *
 */
@DisplayName("Test GamePiece Class")
public class GamePieceTest {

	/**
	 * Tests to ensure get() returns the correct textRepresentation 
	 * reference after a set()
	 */
	@Test
	@DisplayName("textRepresentation getter returns correct value")
	public void testGetSetTextRepresentation() {
		GamePiece gamePiece = new Queen();
		String textRepresentation = "XX";
		gamePiece.setTextRepresentation(textRepresentation);
		assertEquals(textRepresentation, gamePiece.getTextRepresentation());
	}

}

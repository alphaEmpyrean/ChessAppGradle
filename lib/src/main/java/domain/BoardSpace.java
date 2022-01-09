package domain;

/**
 * Creates a {@link BoardSpace} instance.
 * 
 * @author JoshuaKnippel
 *
 */
public class BoardSpace {
	
	//================================================================================
	// Variables
	//================================================================================
	
	/**
	 * Models the behavior of a board space being 'occupied' by a game piece
	 */
	private GamePiece currentGamePiece = null;
	
	//================================================================================
	// Methods
	//================================================================================
	
	/**
	 * Returns a reference to the {@link GamePiece} that currently occupies the {@link BoardSpace}
	 * @return
	 */
	public GamePiece getCurrentGamePiece( ) {
		return this.currentGamePiece;
	}
	
	/**
	 * Sets the instances currentGamePiece reference value to that of the {@link GamePiece} provided to the method
	 * @param current
	 */
	public void setCurrentGamePiece(GamePiece current) {		
		this.currentGamePiece = current;
	}
	
	/**
	 * Checks if the BoardSpace is 'occupied'.
	 * Determined by whether the instances currentGamePiece member is null or not
	 * @return
	 */
	public boolean isOccupied() {
		if (this.currentGamePiece == null ) { 
			return false;
		}
		else {
			return true;
		}
	}

}

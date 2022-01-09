package domain;
/**
 * Abstract class that represents the concept of a game piece.
 * 
 * @author JoshuaKnippel
 *
 */
public abstract class GamePiece {
	
	//================================================================================
    // Variables
    //================================================================================
	
	protected String textRepresentation;
	
	//================================================================================
    // Methods
    //================================================================================
	
	/**
	 * Returns reference to the instances testRepresentation member.
	 * @return
	 */
	public String getTextRepresentation() { 
		return this.textRepresentation;
	}
}

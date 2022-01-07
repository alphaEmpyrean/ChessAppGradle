package domain;

public abstract class GamePiece {
	
	protected String textRepresentation;

	public GamePiece() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTextRepresentation() { 
		return this.textRepresentation;
	}
	
	public String toString() {
		return textRepresentation;
	}

}

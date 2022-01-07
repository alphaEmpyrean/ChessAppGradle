package domain;

public class BoardSpace {

	private GamePiece currentGamePiece = null;
	
	public BoardSpace() {
		// TODO Auto-generated constructor stub
	}
	
	public GamePiece getCurrentGamePiece( ) {
		return this.currentGamePiece;
	}
	
	public void setCurrentGamePiece(GamePiece current) {
		
		this.currentGamePiece = current;
	}
	
	public boolean isOccupied() {
		if (this.currentGamePiece == null ) { 
			return false;
		}
		else {
			return true;
		}
	}

}

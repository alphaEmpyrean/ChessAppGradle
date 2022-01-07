package tools;


import java.util.ArrayList;
import java.util.Arrays;

import domain.BoardSpace;

public class BoardTextRenderer {
	
	private ArrayList<String> capRowPattern = new ArrayList<String>(Arrays.asList("   ", "--------", " ", " "));
	private ArrayList<String> cellRowPattern = new ArrayList<String>(Arrays.asList("  |", "        ", "|", "|"));	
	private ArrayList<String> delimiterRowPattern = new ArrayList<String>(Arrays.asList("   ", "--------", "+", " "));
	
	
	private BoardSpace[][] gameBoard;
	
	public void render(BoardSpace[][] gameBoard) {
		
		//Copy the reference locally.
		this.gameBoard = gameBoard;
		
		//Start with a basic println to get some space between board and edge of terminal
		System.out.println();
		
		
		this.renderRow(capRowPattern);		

		this.renderRow(cellRowPattern);
		this.renderRow(7, cellRowPattern);
		this.renderRow(cellRowPattern);

		this.renderRow(delimiterRowPattern);
		
		this.renderRow(cellRowPattern);
		this.renderRow(6, cellRowPattern);
		this.renderRow(cellRowPattern);

		this.renderRow(delimiterRowPattern);
		
		this.renderRow(cellRowPattern);
		this.renderRow(5, cellRowPattern);
		this.renderRow(cellRowPattern);

		this.renderRow(delimiterRowPattern);
		
		this.renderRow(cellRowPattern);
		this.renderRow(4, cellRowPattern);
		this.renderRow(cellRowPattern);

		this.renderRow(delimiterRowPattern);
		
		this.renderRow(cellRowPattern);
		this.renderRow(3, cellRowPattern);
		this.renderRow(cellRowPattern);

		this.renderRow(delimiterRowPattern);
		
		this.renderRow(cellRowPattern);
		this.renderRow(2, cellRowPattern);
		this.renderRow(cellRowPattern);

		this.renderRow(delimiterRowPattern); 
		
		this.renderRow(cellRowPattern);
		this.renderRow(1, cellRowPattern);
		this.renderRow(cellRowPattern);

		this.renderRow(delimiterRowPattern);
		
		this.renderRow(cellRowPattern);
		this.renderRow(0, cellRowPattern);
		this.renderRow(cellRowPattern);

		this.renderRow(capRowPattern);
		
	}		
	
	//patterList should have 4 values in the following indices
	//0 - opening pattern
	//1 - main pattern
	//2 - main pattern delimiter
	//3 - closing pattern
	
	// will print in the following order
	// 0 1 2 1 2 1 2... 1 3
	
	
	//This will handle printing everything except for the rows that will actually display the chess pieces
	private void renderRow(ArrayList<String> patternList) {
		System.out.print(patternList.get(0));
		for (int c = 0; c < 7; c++) {
			System.out.print(patternList.get(1));
			System.out.print(patternList.get(2));
		}
		System.out.print(patternList.get(1));
		System.out.println(patternList.get(3));
	}	

	
	//Overloaded to render the rows that actually contain the game piece text representation
	//Same as the other renderRow() except this one uses a private function to insert game piece text representation if needed
	private void renderRow(int r, ArrayList<String> patternList) {		
		System.out.print(patternList.get(0));
		for (int c = 0; c < 7; c++) {			
			System.out.print(this.getOccupyingGamePieceText(r, c, patternList.get(1)));
			System.out.print(patternList.get(2));	
		}		
		//same check but for the last board space on the row
		System.out.print(this.getOccupyingGamePieceText(r, 7, patternList.get(1)));
		System.out.println(patternList.get(3));		 
	}
	
	
	//check to see if board space is occupied, if it is return the main pattern with 
	private String getOccupyingGamePieceText(int r, int c, String mainPattern) {		
		if (this.gameBoard[r][c].isOccupied() == false) {
			return mainPattern;
		}
		else {
			StringBuilder patternWithDataInsert = new StringBuilder(mainPattern);
			patternWithDataInsert.replace(3, 5, this.gameBoard[r][c].getCurrentGamePiece().getTextRepresentation());
			return patternWithDataInsert.toString();
		}	
	}

}

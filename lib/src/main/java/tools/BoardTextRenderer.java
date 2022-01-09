package tools;

import java.util.ArrayList;
import java.util.Arrays;

import domain.BoardSpace;

/**
 * Creates a {@link BoardTextRenderer} instance. This class is designed 
 * to render a text version of the chess game board for development testing.
 * 
 * With the default settings the text board will render as follows 
 * (no pieces on board):
 *  -------- -------- -------- -------- -------- -------- -------- -------- 
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 *  --------+--------+--------+--------+--------+--------+--------+-------- 
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 *  --------+--------+--------+--------+--------+--------+--------+-------- 
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 *  --------+--------+--------+--------+--------+--------+--------+-------- 
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 *  --------+--------+--------+--------+--------+--------+--------+-------- 
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 *  --------+--------+--------+--------+--------+--------+--------+-------- 
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 *  --------+--------+--------+--------+--------+--------+--------+-------- 
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 *  --------+--------+--------+--------+--------+--------+--------+-------- 
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 * |        |        |        |        |        |        |        |        |
 *  -------- -------- -------- -------- -------- -------- -------- --------  
 * 
 * @author JoshuaKnippel
 */
public class BoardTextRenderer {
		
	//================================================================================
    // Variables
    //================================================================================

	/**
	 * This pattern controls the design for the first and last row of the grid. 
	 */
	private ArrayList<String> capRowPattern = new ArrayList<String>(Arrays.asList("   ", "--------", " ", " "));
	
	/**
	 * This pattern controls the design of the cell rows.
	 * Basically controls what a data cells vertical 'lines' look like
	 */
	private ArrayList<String> cellRowPattern = new ArrayList<String>(Arrays.asList("  |", "        ", "|", "|"));
	
	/**
	 * This pattern controls the design of the cell delimiter rows.
	 * Basically controls what a data cells horizontal 'lines' look like
	 */
	private ArrayList<String> delimiterRowPattern = new ArrayList<String>(Arrays.asList("   ", "--------", "+", " "));
	
	//Local copy of game board reference
	private BoardSpace[][] gameBoard;
	
	//================================================================================
    // Methods
    //================================================================================
	
	//PUBLIC
	
	/**
	 * Renders the text game board along with the game {@link GamePiece}s. Piece location is 
	 * determined by the {@link BoardSpace} multidimensional array that is passed to the function
	 * @param gameBoard
	 */
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
	
	//PRIVATE
	
	/*
	 * -private
	 * Renders individual text rows based on the pattern list that is passed to the method.
	 * 
	 * The indices of the passed array list will be used as follows:
	 * 0 - opening pattern
	 * 1 - main pattern
	 * 2 - main pattern delimiter
	 * 3 - closing pattern
	 * 
	 * With the default configuration the method will print the strings with the following pattern
	 * 0  1  2  1  2  1  2  1  2  1  2  1  2  1  2  1  3
	 *   
	 * @param patternList
	 */
	private void renderRow(ArrayList<String> patternList) {
		System.out.print(patternList.get(0));
		for (int c = 0; c < 7; c++) {
			System.out.print(patternList.get(1));
			System.out.print(patternList.get(2));
		}
		System.out.print(patternList.get(1));
		System.out.println(patternList.get(3));
	}
	
	/*
	 * -private
	 * Renders individual text rows that contain the {@link GamePiece} text representations. 
	 * Render is based on the gameBoard row and pattern list that is passed to the method.
	 * 
	 * In this overloaded version we use a function to insert the game piece's text 
	 * representation into the main pattern (1) if needed.
	 * 
	 * Example Render (pieces in starting locations):
	 *  -------- -------- -------- -------- -------- -------- -------- -------- 
	 * |        |        |        |        |        |        |        |        |
	 * |   xR   |   xN   |   xB   |   xQ   |   xK   |   xB   |   xN   |   xR   |
	 * |        |        |        |        |        |        |        |        |
	 *  --------+--------+--------+--------+--------+--------+--------+-------- 
	 * |        |        |        |        |        |        |        |        |
	 * |   xP   |   xP   |   xP   |   xP   |   xP   |   xP   |   xP   |   xP   |
	 * |        |        |        |        |        |        |        |        |
	 *  --------+--------+--------+--------+--------+--------+--------+-------- 
	 * |        |        |        |        |        |        |        |        |
	 * |        |        |        |        |        |        |        |        |
	 * |        |        |        |        |        |        |        |        |
	 *  --------+--------+--------+--------+--------+--------+--------+-------- 
	 * |        |        |        |        |        |        |        |        |
	 * |        |        |        |        |        |        |        |        |
	 * |        |        |        |        |        |        |        |        |
	 *  --------+--------+--------+--------+--------+--------+--------+-------- 
	 * |        |        |        |        |        |        |        |        |
	 * |        |        |        |        |        |        |        |        |
	 * |        |        |        |        |        |        |        |        |
	 *  --------+--------+--------+--------+--------+--------+--------+-------- 
	 * |        |        |        |        |        |        |        |        |
	 * |        |        |        |        |        |        |        |        |
	 * |        |        |        |        |        |        |        |        |
	 *  --------+--------+--------+--------+--------+--------+--------+-------- 
	 * |        |        |        |        |        |        |        |        |
	 * |   xP   |   xP   |   xP   |   xP   |   xP   |   xP   |   xP   |   xP   |
	 * |        |        |        |        |        |        |        |        |
	 *  --------+--------+--------+--------+--------+--------+--------+-------- 
	 * |        |        |        |        |        |        |        |        |
	 * |   xR   |   xN   |   xB   |   xQ   |   xK   |   xB   |   xN   |   xR   |
	 * |        |        |        |        |        |        |        |        |
	 *  -------- -------- -------- -------- -------- -------- -------- -------- 
	 * 
	 * @param r
	 * @param patternList
	 */
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
	
	/*
	 * -private
	 * Checks the {@link BoardSpace} at the coordinate provided to see if it is occupied. 
	 * If it is not occupied the provided string is returned unaltered. If the space is 
	 * occupied then it replaces the middle 2 characters of the passed string with a text 
	 * representation of the occupying game piece and returns that altered string to be printed.
	 * 
	 * @param r
	 * @param c
	 * @param mainPattern
	 * @return
	 */
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

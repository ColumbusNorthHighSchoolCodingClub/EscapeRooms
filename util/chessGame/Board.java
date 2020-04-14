package util.chessGame;

import java.util.ArrayList;

/**
 * Board class for managing piece positions, moves, and interactions in a
 * chess-like game.
 * 
 * @author 22raor
 * @author 22wangj
 * @author 22banerjeea
 */
public class Board {

	public static final int NUM_ROWS = 6;
	public static final int NUM_COLS = 6;

	public Piece[][] grid = new Piece[NUM_ROWS][NUM_COLS];
	private final Piece[] initialState;

	public Board(Piece... pieces) {
		initialState = new Piece[pieces.length];
		for (int i = 0; i < pieces.length; i++) {
			Piece p = pieces[i];
			grid[p.getRow()][p.getCol()] = p;
			initialState[i] = p.clone();
		}
	}

	/**
	 * Updates the board according to each piece's row and col
	 *
	 */
	public void update() {
		Piece[][] pieceCopy = new Piece[grid.length][];
		for (int i = 0; i < grid.length; i++) {
			pieceCopy[i] = grid[i].clone();
		}

		grid = new Piece[NUM_ROWS][NUM_COLS];
		for (int row = 0; row < NUM_ROWS; row++) {
			for (int col = 0; col < NUM_COLS; col++) {
				if (pieceCopy[row][col] != null && pieceCopy[row][col].isDead()==false ) {
					grid[pieceCopy[row][col].getRow()][pieceCopy[row][col].getCol()] = pieceCopy[row][col];
     
				}
			}
		}
    




	}
	public boolean isGameOver() {
		int c = 0;
		
		for (int row = 0; row < NUM_ROWS; row++) {
			for (int col = 0; col < NUM_COLS; col++) {
				if (grid[row][col] != null  ) {
					if(grid[row][col].getClass().getName().contains("Key") && !grid[row][col].isDead()) {
						c++;
						
					}
     
				}
				
			
				
				
			}}
		
			if(c!=2) {
				return true;
			}
			return false;
		
	}
	

	/**
	 * Checks if it is a possible for a {@code Piece} to make a move to a specific
	 * {@code Location}
	 * 
	 * @param p   the {@code Piece} to be moved
	 * @param loc the goal {@code Location}
	 * @return whether the move is valid
	 */
	public boolean isValidMove(Piece p, Location loc) {

		if (!p.canMoveTo(loc)) {
			//System.out.println("piece cant move there :" + loc);
			return false;
		}

		for (Location middleLoc : locsBetween(p.getLocation(), loc)) {
			if (grid[middleLoc.getRow()][middleLoc.getCol()] != null) {
				//System.out.println("thing between");
				return false;
			}
		}

		if (grid[loc.getRow()][loc.getCol()] == null) {
			return true;
		} else if (grid[loc.getRow()][loc.getCol()].getColor().equals(p.getColor())) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns an {@code ArrayList} of the locations in between two locations,
	 * excluding the start and end
	 * 
	 * @param start the starting {@code Location}
	 * @param end   the ending {@code Location}
	 * @return an {@code ArrayList} containing all the locations between
	 */
	public ArrayList<Location> locsBetween(Location start, Location end) {
		ArrayList<Location> locs = new ArrayList<Location>();
		start = start.getAdjacentLocation(start.getActualDirectionToward(end));
		while (!start.equals(end)) {
			locs.add(start);
			start = start.getAdjacentLocation(start.getActualDirectionToward(end));
		}
		return locs;
	}

}
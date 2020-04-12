package util.chessGame;

import java.awt.Color;

/**
 * The chariot piece moves like a rook in chess; horizontally and vertically any
 * number of units
 * 
 * @author Señor Rashi
 * @author Señor $JMoney$
 * @author Señor Bacon
 */
public class Chariot extends Piece {

	private final int worth = 50;

	public Chariot(int row, int col, Color color) {
		super(row, col, color);
	}

	public Chariot(Location loc, Color color) {
		super(loc, color);
	}

	public int getWorth() {
		return worth;
	}

	public Piece clone() {
		return new Chariot(this.row, this.col, this.color);
	}

	public boolean canMoveTo(Location loc) {
		if (!loc.isValidLocation() || loc.equals(this.getLocation())) {
			return false;
		} else if (loc.getRow() == row || loc.getCol() == col) {
			return true;
		} else {
			return false;
		}
	}

}
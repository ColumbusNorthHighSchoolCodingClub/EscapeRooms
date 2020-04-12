package util.chessGame;

import java.awt.Color;

/**
 * The elephant piece moves like a bishop in chess; any number of units
 * diagonally
 * 
 * @author Señor Rashi
 * @author Señor $JMoney$
 * @author Señor Bacon
 */
public class Elephant extends Piece {

	private final int worth = 30;

	public Elephant(int row, int col, Color color) {
		super(row, col, color);
	}

	public Elephant(Location loc, Color color) {
		super(loc, color);
	}

	public int getWorth() {
		return worth;
	}

	public Piece clone() {
		return new Elephant(this.row, this.col, this.color);
	}

	public boolean canMoveTo(Location loc) {
		if (!loc.isValidLocation() || loc.equals(this.getLocation())) {
			return false;
		} else if (this.getLocation().getActualDirectionToward(loc) % 90 == 45) {
			return true;
		} else {
			return false;
		}
	}

}
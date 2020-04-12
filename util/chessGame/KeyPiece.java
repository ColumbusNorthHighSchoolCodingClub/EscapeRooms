package util.chessGame;

import java.awt.Color;

/**
 * The key piece can move any number of units in any direction, including
 * diagonals.
 *
 * @author Señor Rashi
 * @author Señor $JMoney$
 * @author Señor Bacon
 */
public class KeyPiece extends Piece {

	private final int worth = 9000;

	public KeyPiece(int row, int col, Color color) {
		super(row, col, color);
	}

	public KeyPiece(Location loc, Color color) {
		super(loc, color);
	}

	public int getWorth() {
		return worth;
	}

	public Piece clone() {
		return new KeyPiece(this.row, this.col, this.color);
	}

	public boolean canMoveTo(Location loc) {
		if (!loc.isValidLocation() || loc.equals(this.getLocation())) {
			return false;
		} else if (getLocation().getActualDirectionToward(loc) % 45 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
package util.chessGame;

import java.awt.Color;

/**
 * The foot soldier can move one unit in any direction, including diagonals.
 *
 * @author Señor Rashi
 * @author Señor $JMoney$
 * @author Señor Bacon
 */
public class FootSoldier extends Piece {

	private final int worth = 10;

	public FootSoldier(int row, int col, Color color) {
		super(row, col, color);
	}

	public FootSoldier(Location loc, Color color) {
		super(loc, color);
	}

	public int getWorth() {
		return worth;
	}

	public Piece clone() {
		return new FootSoldier(this.row, this.col, this.color);
	}

	public boolean canMoveTo(Location loc) {

		if (!loc.isValidLocation() || loc.equals(this.getLocation())) {
			return false;
		} else if (getLocation().getActualDirectionToward(loc) == (color.equals(Color.blue) ? 0 : 180)
				&& getLocation().distanceTo(loc) == 1) {
			return true;
		} else if ((getLocation().getActualDirectionToward(loc) == (color.equals(Color.blue) ? 45 : 225)
				|| getLocation().getActualDirectionToward(loc) == (color.equals(Color.blue) ? 315 : 135))
				&& getLocation().distanceTo(loc) == 2) {
			return true;
		} else {
			return false;
		}

	}

}
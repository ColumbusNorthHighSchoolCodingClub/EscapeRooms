package util.chessGame;

import java.awt.Color;

public class Move {

	public Piece piece;
	public Location origLoc;
	public Location finalLoc;
	public int finalBoardValue;

	public Move(Piece p, Location origLoc, Location finalLoc, int finalBoardValue) {
		piece = p;
		this.origLoc = origLoc;
		this.finalLoc = finalLoc;
		this.finalBoardValue = finalBoardValue;
	}

	public void setValue(int value) {
		finalBoardValue = value;
	}

	public String toString() {
		if (piece.getColor().equals(Color.red)) {
			return "Red " + piece.getClass().getName().replace("util.chessGame.", "") + " from " + origLoc + " to "
					+ finalLoc;
		} else {
			return "Blue " + piece.getClass().getName().replace("util.chessGame.", "") + " from " + origLoc + " to "
					+ finalLoc;
		}
	}

}
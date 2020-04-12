package util.chessGame;

import java.awt.Color;

/**
 * Allows you to create different game pieces for a chess-like game.
 *
 * @author 22raor
 * @author 22wangj
 * @author 22banerjeea
 */
public abstract class Piece {

	protected int row;
	protected int col;
	protected Color color;
	public int x;
	public int y;
	public boolean dead = false;

	/* Constructors */
	public Piece(Location loc, Color color) {
		this.row = loc.getRow();
		this.col = loc.getCol();
		x = 15 + 70 * getCol();
		y = 25 + 70 * getRow();
		this.color = color;
	}

	public Piece(int row, int col, Color color) {

		this.row = row;
		this.col = col;
		x = 15 + 70 * getCol();
		y = 25 + 70 * getRow();
		this.color = color;
	}

	/* Getters and Setters */
	public Color getColor() {
		return color;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public void setColor(Color color) {
		this.color = color; // add.(appendToCurrentIndex());
	}

	public void update(int row, int col) {
		this.row = row;
		this.col = col;
		x = 15 + 70 * getCol();
		y = 25 + 70 * getRow();
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Location getLocation() {
		return new Location(row, col);
	}

	public void setLocation(Location loc) {
		this.row = loc.getCol();
		this.col = loc.getRow();
	}

	public String toString() {
		return this.getClass().getName().replace("util.chessGame.", "") + " at " + this.getLocation();
	}

	/* Methods */
	public abstract boolean canMoveTo(Location loc);

	public abstract Piece clone();

	public abstract int getWorth();

}
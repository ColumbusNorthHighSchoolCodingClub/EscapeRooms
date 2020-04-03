package items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Arrays;

import gameObjects.Item;
import gameObjects.Player;
import util.Triangle;

/**
 * This puzzle replicates a mobile game, Kami, where the goal is to end the
 * puzzle with all pieces the same color. Clicking on a triangle with a color
 * causes that triangle and all adjacent triangles to change to that color.
 *
 * @author 22raor
 * @author jMoney
 * @author BaconOutlaw
 */
public class KamiPuzzle extends Item {

	private ArrayList<Triangle> triangles;
	private final ArrayList<Triangle> initialState;
	private ArrayList<Triangle> toChange;
	private Color currentColor = Color.cyan;
	private final int MAX_MOVES;
	private int movesLeft;
	private Color initialColor = null;

	private static final Rectangle CYAN_SELECT = new Rectangle(440, 100, 50, 50);
	private static final Rectangle RED_SELECT = new Rectangle(500, 100, 50, 50);
	private static final Rectangle GRAY_SELECT = new Rectangle(560, 100, 50, 50);

	private static final Rectangle RESET_BUTTON = new Rectangle(460, 270, 110, 55);

	/**
	 *
	 * @param triangles to be used in puzzle
	 */
	public KamiPuzzle(Triangle[] trA, int maxMoves) {
		super("KamiPuzzle", new Rectangle(300, 250, 100, 230));
		MAX_MOVES = maxMoves;
		movesLeft = MAX_MOVES;

		final ArrayList<Triangle> triangles = new ArrayList<>(Arrays.asList(trA));
		this.triangles = new ArrayList<Triangle>(triangles);
		initialState = new ArrayList<Triangle>();
		for (Triangle p : triangles) {
			initialState.add(p.clone());
		}

	}

	public void recursiveChange(Triangle target) {
		//

		/*
		 * if (toChange == null) { toChange = new ArrayList<Triangle>(); initialColor =
		 * target.getColor(); } // take target triangle, when color is changed, look
		 * through triangles array and // if the triangle is adjacent to it and has the
		 * same color, change that // triangles color, the invoke change color on each
		 * of those triangles for (final Triangle possibleAdjacent : triangles) { if
		 * (possibleAdjacent.isAdjacent(target)) { if
		 * (possibleAdjacent.getColor().equals(target.getColor())) {
		 * toChange.add(possibleAdjacent); recursiveChange(possibleAdjacent); }
		 * 
		 * }
		 * 
		 * } for (Triangle z : toChange) { z.setColor(currentColor); }
		 */

		if (toChange == null) {
			toChange = new ArrayList<Triangle>();
			initialColor = target.getColor();
		}
		// take target triangle, when color is changed, look through triangles array and
		// if the triangle is adjacent to it and has the same color, change that
		// triangles color, the invoke change color on each of those triangles
		for (Triangle possibleAdjacent : triangles) {
			if (possibleAdjacent.isAdjacent(target)) {
				if (possibleAdjacent.getColor().equals(initialColor)) {
					possibleAdjacent.setColor(currentColor);
					recursiveChange(possibleAdjacent);
				}

			}

		}

	}

	public void reactToMouseRelease(Point p, Player player) {
		toChange = null;
	}

	@Override
	public void reactToClickGeneric(Point p, Player player) {
		for (Triangle t : triangles) {
			if (t.contains(p) && !(t.getColor().equals(currentColor)) && movesLeft > 0) {
				recursiveChange(t);
				movesLeft--;
			}
		}

		if (CYAN_SELECT.contains(p)) {
			currentColor = Color.cyan;
		} else if (RED_SELECT.contains(p)) {
			currentColor = Color.red;
		} else if (GRAY_SELECT.contains(p)) {
			currentColor = Color.darkGray;
		}

		if (RESET_BUTTON.contains(p)) {
			movesLeft = MAX_MOVES;
			triangles = new ArrayList<Triangle>();
			for (Triangle original : initialState) {
				triangles.add(new Triangle(original));
			}
		}

	}

	@Override
	public void draw(Graphics g, ImageObserver io) {

		// super.draw(g, io);

		// Draw triangles
		for (Triangle t : triangles) {

			g.setColor(t.getColor());

			g.fillPolygon(t.toPolygon());

		}

		// Draw celected color outline
		g.setColor(Color.black);
		if (currentColor.equals(Color.cyan)) {
			g.fillRect(CYAN_SELECT.x - 4, CYAN_SELECT.y - 4, CYAN_SELECT.width + 8, CYAN_SELECT.height + 8);
		} else if (currentColor.equals(Color.red)) {
			g.fillRect(RED_SELECT.x - 4, RED_SELECT.y - 4, RED_SELECT.width + 8, RED_SELECT.height + 8);
		} else if (currentColor.equals(Color.darkGray)) {
			g.fillRect(GRAY_SELECT.x - 4, GRAY_SELECT.y - 4, GRAY_SELECT.width + 8, GRAY_SELECT.height + 8);
		}

// Draw color selectors
		g.setColor(Color.cyan);
		g.fillRect(CYAN_SELECT.x, CYAN_SELECT.y, CYAN_SELECT.width, CYAN_SELECT.height);
		g.setColor(Color.red);
		g.fillRect(RED_SELECT.x, RED_SELECT.y, RED_SELECT.width, RED_SELECT.height);
		g.setColor(Color.darkGray);
		g.fillRect(GRAY_SELECT.x, GRAY_SELECT.y, GRAY_SELECT.width, GRAY_SELECT.height);

		// Draw reset button
		g.setColor(Color.black);
		g.fillRect(RESET_BUTTON.x - 4, RESET_BUTTON.y - 4, RESET_BUTTON.width + 8, RESET_BUTTON.height + 8);
		g.setColor(Color.red);
		g.fillRect(RESET_BUTTON.x, RESET_BUTTON.y, RESET_BUTTON.width, RESET_BUTTON.height);

		Font stringFont = new Font("SansSerif", Font.PLAIN, 24);
		Font stringFont2 = new Font("SansSerif", Font.PLAIN, 11);

		g.setColor(Color.white);
		g.setFont(stringFont);
		g.drawString("RESET", RESET_BUTTON.x + 15, RESET_BUTTON.y + 35);

		g.setFont(new Font("SansSerif", Font.PLAIN, 60));
		g.setColor(Color.black);
		g.drawString("" + movesLeft, RESET_BUTTON.x - 100, RESET_BUTTON.y + 50);

		if (isSolved()) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 1000);

			g.setColor(Color.white);
			g.setFont(new Font("SansSerif", Font.PLAIN, 50));
			g.drawString("YOU ESCAPED", 140, 240);
		}

		g.setColor(Color.black);
		g.setFont(stringFont2); // set font size back to default
	}

	public void reactToDrag(Point p, Player player) {

	}

	public boolean isSolved() {
		Color b = triangles.get(0).getColor();

		for (Triangle z : triangles) {
			if (!z.getColor().equals(b)) {
				return false;
			}
		}
		return true;
	}
}
package util;

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
 * Add this item to a room, and return false is isDone(). Use the color selector to create your level and then hit export to print the Triangle array for the KamiPuzzle constructor.
 *
 * @author 22raor
 * @author jMoney
 * @author BaconOutlaw
 */
public class KamiPuzzleBuilder extends Item {

	private ArrayList<Triangle> triangles;
	private final ArrayList<Triangle> initialState;
	private ArrayList<Triangle> toChange;
	private Color currentColor = Color.cyan;
	// private final int MAX_MOVES;
//	private int movesLeft;
	private final Color initialColor = null;

	private static final Rectangle CYAN_SELECT = new Rectangle(430, 100, 50, 50);
	private static final Rectangle RED_SELECT = new Rectangle(490, 100, 50, 50);
	private static final Rectangle GRAY_SELECT = new Rectangle(550, 100, 50, 50);

	private static final Rectangle RESET_BUTTON = new Rectangle(460, 270, 110, 55);
	private static final Rectangle EXPORT_BUTTON = new Rectangle(460, 360, 110, 55);

	private final Triangle firstTriangle = new Triangle(182 + 10, 0 + 20, 208 + 10, 15 + 20, 182 + 10, 30 + 20,
			Color.cyan);

	/**
	 *
	 * @param triangles to be used in puzzle
	 */
	public KamiPuzzleBuilder() {
		super("KamiPuzzle", new Rectangle(300, 250, 100, 230));
		// this.MAX_MOVES = maxMoves;
		// movesLeft = MAX_MOVES;
		this.triangles = new ArrayList<Triangle>();
		triangles.add(firstTriangle);
		initialState = new ArrayList<Triangle>();
		for (final Triangle p : triangles) {
			initialState.add(p.clone());
		}

	}

	@Override
	public void reactToClickGeneric(Point p, Player player) {

		final ArrayList<Triangle> beforeTriangles = new ArrayList<Triangle>();
		for (final Triangle pppp : triangles) {
			beforeTriangles.add(pppp.clone());

		}


		


		for ( Triangle b : beforeTriangles) {

      if(b.contains(p)) {
        for(Triangle m: triangles){
          if(m.equalsIgnoreColor(b)){
        	 // System.out.println("Color set");
        	  
        	  
        	  
        	  
        	  
              m.setColor(currentColor);
          }

        }
          

      }


			ArrayList<Triangle> t = b.getAdjacents();

			for (Triangle z : t) {
				if (z.contains(p)) {
				
					boolean duplicate = false;
					for(Triangle popo: triangles) {
						if(popo.equalsIgnoreColor(z)) {
							duplicate = true;
						}
						
					}
					if(duplicate==false) {
					triangles.add(new Triangle(z.getVertices(), currentColor));
				
					}
				
				}

			}

		}

		if (CYAN_SELECT.contains(p)) {
			currentColor = Color.cyan;
		} else if (RED_SELECT.contains(p)) {
			currentColor = Color.red;
		} else if (GRAY_SELECT.contains(p)) {
			currentColor = Color.darkGray;
		} else if (EXPORT_BUTTON.contains(p)) {
			System.out.println();

			System.out.print(triangles.size() + " triangle drawn   :    " + "new Triangle[] { ");
			for (final Triangle abcd : triangles) {

				System.out.print( "new Triangle(" + "new Point(" + abcd.getVertices()[0].x + "," + abcd.getVertices()[0].y + ")" + "," + "new Point(" + abcd.getVertices()[1].x + "," + abcd.getVertices()[1].y + ")"
						+  "," +  "new Point(" + abcd.getVertices()[2].x + "," + abcd.getVertices()[2].y + ")" + "," + "new Color(" + abcd.getColor().getRGB() + ")),");

			}
			System.out.print("}");

			System.out.println();
		}

		if (RESET_BUTTON.contains(p)) {
			// movesLeft = MAX_MOVES;
			triangles = new ArrayList<Triangle>();
			for (final Triangle original : initialState) {
				triangles.add(new Triangle(original));
			}
		}

	}

	@Override
	public void draw(Graphics g, ImageObserver io) {

		super.draw(g, io);
		for (Triangle t : triangles) {


			g.setColor(t.getColor());

			double bb = 0.1;
			Point a = new Point((t.getVertices()[0].x
					+ (int) (bb * (((t.getVertices()[1].x + t.getVertices()[2].x) / 2) - t.getVertices()[0].x))),
					(t.getVertices()[0].y + (int) (bb
							* (((t.getVertices()[1].y + t.getVertices()[2].y) / 2) - t.getVertices()[0].y))));
			Point b = new Point((t.getVertices()[1].x
					+ (int) (bb * (((t.getVertices()[2].x + t.getVertices()[0].x) / 2) - t.getVertices()[1].x))),
					(t.getVertices()[1].y + (int) (bb
							* (((t.getVertices()[2].y + t.getVertices()[0].y) / 2) - t.getVertices()[1].y))));
			Point c = new Point((t.getVertices()[2].x
					+ (int) (bb * (((t.getVertices()[0].x + t.getVertices()[1].x) / 2) - t.getVertices()[2].x))),
					(t.getVertices()[2].y + (int) (bb
							* (((t.getVertices()[0].y + t.getVertices()[1].y) / 2) - t.getVertices()[2].y))));
			Triangle mini = new Triangle(a, b, c, t.getColor());

			g.fillPolygon(mini.toPolygon());

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

			// Draw export button
			g.setColor(Color.black);
			g.fillRect(EXPORT_BUTTON.x - 4, EXPORT_BUTTON.y - 4, EXPORT_BUTTON.width + 8, EXPORT_BUTTON.height + 8);
			g.setColor(Color.green);
			g.fillRect(EXPORT_BUTTON.x, EXPORT_BUTTON.y, EXPORT_BUTTON.width, EXPORT_BUTTON.height);

			g.setColor(Color.white);
			g.drawString("EXPORT", EXPORT_BUTTON.x + 7, EXPORT_BUTTON.y + 35);

			g.setFont(stringFont2); // set font size back to default
		}

	}

	public boolean isSolved() {
		final Color b = triangles.get(0).getColor();
		for (final Triangle z : triangles) {
			if (!z.getColor().equals(b)) {
				return false;
			}
		}
		return true;
	}
}
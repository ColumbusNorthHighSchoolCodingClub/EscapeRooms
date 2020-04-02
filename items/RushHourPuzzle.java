package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import gameObjects.Item;
import gameObjects.Player;

/**
 * 
 * @author 22raor
 * @author 22wangj
 * @author 22banerjeea
 */
public class RushHourPuzzle extends Item {

	private ArrayList<Rectangle> blocks;

	private final ArrayList<Rectangle> initialOrientation;
	private final Rectangle initialKey;
	private ArrayList<Color> blockColors;
	private Rectangle keyBlock;
	private Rectangle reset;
	private Toolkit toolkit;
	private static Image key;

	private final int BORDER = 2;

	Rectangle exitRect = new Rectangle(420, 155, 120, 80);

	private Point lastMouse;

	public void reactToDrag(Point p, Player player) {

		for (Rectangle targetRect : blocks) {

			boolean movesInX = false;
			if (targetRect.width > targetRect.height) {
				movesInX = true;
			}

			if (targetRect.contains(p)) {
				if (lastMouse == null) {
					lastMouse = p;
				}

				Point toMove;
				if (movesInX) {
					toMove = new Point(targetRect.x + (p.x - lastMouse.x), targetRect.y);
				} else {
					toMove = new Point(targetRect.x, targetRect.y + (p.y - lastMouse.y));
				}
				boolean canMove = true;
				// Rectangle offendingBlock;

				for (Rectangle possibleObstructs : blocks) {
					Rectangle toMoveRect = new Rectangle(toMove.x, toMove.y, targetRect.width, targetRect.height);

					// intersects border then false
					if (toMove.x <= 10 || toMove.y <= 20 || toMove.x >= 430 - targetRect.width
							|| toMove.y >= 440 - targetRect.height) {
						canMove = false;
					}

					// for only keyBlock, intersects exit rectangle, then true

					if (targetRect.equals(keyBlock) && targetRect
							.intersects(new Rectangle(exitRect.x, exitRect.y, exitRect.width, exitRect.height))) {
						canMove = true;
					}

					if (possibleObstructs.intersects(toMoveRect) && !possibleObstructs.equals(targetRect)) {
						canMove = false;
					}
				}

				if (canMove) {
					targetRect.setLocation(toMove);
				}

			}
		}
		lastMouse = p;

	}

	public void reactToMouseRelease(Point p, Player player) {
		lastMouse = null;
	}

	public void reactToClickGeneric(Point p, Player player) {
		//System.out.println("Mouse Clicked");
		if (reset.contains(p)) {
			blocks = new ArrayList<Rectangle>();
			for (Rectangle b : initialOrientation) {
				blocks.add(new Rectangle(b));
			}

			keyBlock = new Rectangle(initialKey);
			blocks.add(keyBlock);
		}

	}

	public RushHourPuzzle(ArrayList<Rectangle> blocks, Point keyBlock) {
		super("RushHourPuzzle", new Rectangle(500, 200, 20, 20));
		reset = new Rectangle(460, 270, 110, 55);
		Rectangle theKey = new Rectangle(keyBlock.x, keyBlock.y, 139, 69);

		initialOrientation = new ArrayList<Rectangle>();
		for (Rectangle b : blocks) {
			initialOrientation.add(new Rectangle(b));
		}

		blocks.add(theKey);
		this.blocks = blocks;
		this.keyBlock = theKey;
		initialKey = new Rectangle(this.keyBlock);

		blockColors = new ArrayList<Color>();
		toolkit = Toolkit.getDefaultToolkit();
		key = toolkit.getImage("src/items/images/better_key.gif");

		Color[] colors = new Color[] { Color.blue, Color.cyan, Color.gray, Color.green, Color.magenta, Color.orange,
				Color.pink, Color.red, Color.yellow };

		for (int i = 0; i < blocks.size(); i++) {
			blockColors.add(colors[i % colors.length]);
		}
	}

	public Rectangle getKeyBounds() {
		return keyBlock;
	}

	public void draw(Graphics g, ImageObserver io) {
		// Draw room boundaries
		g.setColor(Color.black);
		g.fillRect(6, 16, 428, 428);
		g.setColor(Color.white);
		g.fillRect(10, 20, 420, 420);

		// Draw exit
		g.fillRect(exitRect.x, exitRect.y, exitRect.width, exitRect.height);

		// Draw each block with black borders
		for (Rectangle block : blocks) {
			g.setColor(Color.black);
			g.fillRect(block.x, block.y, block.width, block.height);
			g.setColor(blockColors.get(blocks.indexOf(block)));
			g.fillRect(block.x + BORDER, block.y + BORDER, block.width - 2 * BORDER, block.height - 2 * BORDER);
		}
		g.drawImage(key, keyBlock.x, keyBlock.y, keyBlock.width, keyBlock.height, io);

		// Reset button
		g.setColor(Color.black);
		g.fillRect(reset.x - 4, reset.y - 4, reset.width + 8, reset.height + 8);
		g.setColor(Color.red);
		g.fillRect(reset.x, reset.y, reset.width, reset.height);

		Font stringFont = new Font("SansSerif", Font.PLAIN, 24);
		Font stringFont2 = new Font("SansSerif", Font.PLAIN, 11);

		g.setColor(Color.white);
		g.setFont(stringFont);
		g.drawString("RESET", reset.x + 15, reset.y + 35);
		g.setFont(stringFont2);
	}

}
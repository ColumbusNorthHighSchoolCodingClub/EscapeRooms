package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import gameObjects.Item;
import gameObjects.Player;

public class lightTile extends Item {
	boolean isOn = false;

	// Select Location its located at and width and height
	public lightTile(int x, int y) {
		super("lightTile", new Rectangle(x, y, 50, 50));
	}

	public boolean isOn() {
		return isOn;
	}

	public void reactToClick(Point p, Player player) {
		isOn = !isOn;
	}

	public void draw(Graphics g, ImageObserver io) {
		if (isOn)
			g.setColor(Color.black);
		else
			g.setColor(Color.yellow);
		g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
	}
}
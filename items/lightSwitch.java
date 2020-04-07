package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import gameObjects.Item;
import gameObjects.Player;

public class lightSwitch extends Item {

	boolean isOn = false;

	public lightSwitch(int x, int y, int width, int height) {
		super("LightSwitch", new Rectangle(x, y, width, height));
	}

	public boolean isOn() {
		return isOn;
	}

	public void reactToClick(Point p, Player player) {
		isOn = !isOn;

		System.out.println("Switch flipped!!");
	}

	public void draw(Graphics g, ImageObserver io) {

		if (isOn) {
			// Basic Circle
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1000, 1000);

			g.setColor(Color.BLUE);
			g.fillRect(getRect().x - 10, getRect().y - 10, getRect().width + 20, getRect().height + 20);

			g.setColor(Color.GREEN);
			g.fillRect(getRect().x, getRect().y - 30, getRect().width, getRect().height + 30);
		} else {

			g.setColor(Color.BLUE);
			g.fillRect(getRect().x - 10, getRect().y - 10, getRect().width + 20, getRect().height + 20);

			g.setColor(Color.RED);
			g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height + 30);
		}
	}

}

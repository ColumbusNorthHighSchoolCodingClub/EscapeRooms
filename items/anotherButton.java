package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import gameObjects.Item;
import gameObjects.Player;

public class anotherButton extends Item {
	boolean isOn = false;
	//Select Location its located at and width and height
	public anotherButton(int x, int y, int width, int height) {
		super("anotherButton", new Rectangle(x, y, width, height));
	}

	public boolean isOn() {
		return isOn;
	}

	public void reactToClick(Point p, Player player) {
		isOn = !isOn;
		System.out.println("anotherButton Clicked!");
	}

	public void draw(Graphics g, ImageObserver io) {
		if (isOn)
			g.setColor(Color.white);
		else
			g.setColor(Color.blue);
		g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
	}
}

package rooms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import gameObjects.Room;
import items.RushHourPuzzle;

/**
 * 
 * Finish a rush hour style puzzle to unlock the door
 * 
 * @author 22raor
 * @author 22wangj
 * @author BaconOutlaw
 */
public class RoomThree extends Room {
	public Rectangle door = new Rectangle(540, 155, 30, 80);

	public RoomThree() {
		super();
		ArrayList<Rectangle> r = new ArrayList<Rectangle>();
		r.add(new Rectangle(220, 20, 69, 139));
		r.add(new Rectangle(220, 160, 69, 139));
		r.add(new Rectangle(360, 300, 69, 139));
		r.add(new Rectangle(290, 90, 139, 69));
		r.add(new Rectangle(290, 230, 139, 69));
		r.add(new Rectangle(220, 300, 139, 69));
		r.add(new Rectangle(11, 230, 69, 209));
		r.add(new Rectangle(150, 230, 69, 209));

		this.addItem(new RushHourPuzzle(r, 11));
	}

	public boolean isDone() {
		return ((RushHourPuzzle) getItemByName("RushHourPuzzle")).getKeyBounds().intersects(door);
	}

	public void draw(Graphics g, ImageObserver io) {
		super.draw(g, io);
		g.setColor(Color.orange);
		g.fillRect(door.x, door.y, door.width, door.height);
		 if(isDone()) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.white);

		
		 }

	}
}

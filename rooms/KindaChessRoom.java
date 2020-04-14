package rooms;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.SimpleButton;
import items.anotherButton;
import items.KindaChessGame;

public class KindaChessRoom extends Room {

	public KindaChessRoom() {
		super();
		this.addItem(new KindaChessGame());
	}

	public boolean isDone() {
		return ((KindaChessGame)getItemByName("KindaChessGame")).isFinished();
	}

  public void draw(Graphics g, ImageObserver io) {
		super.draw(g, io);
	}
}

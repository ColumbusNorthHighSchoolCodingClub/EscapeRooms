package rooms;

import java.awt.Point;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.SimpleButton;
import items.anotherButton;
import items.lightTile;

public class lightsOut extends Room {
	private boolean isDone = false;

	public lightsOut() {
		super();
		for (int i = 200; i < 354; i += 51) {
			this.addItem(new lightTile(i, 200 - 50));
			this.addItem(new lightTile(i, 251 - 50));
			this.addItem(new lightTile(i, 302 - 50));
			this.addItem(new lightTile(i, 353 - 50));
		}
	}

	public void onClick(Point p, Player player) {
		for (int index = 0; index < getItems().size(); index++) {
			Item i = getItems().get(index);

			if (i.getHitBox().contains(p) && i instanceof lightTile) {
				for (int k = 0; k < getItems().size(); k++) {
					Item temp = getItems().get(k);
					if (temp instanceof lightTile) {
						if ((((Math.abs(temp.getRect().x - i.getRect().x)) == 51
								&& (Math.abs(temp.getRect().y - i.getRect().y) == 0))
								|| ((Math.abs(temp.getRect().y - i.getRect().y) == 51)
										&& (Math.abs(temp.getRect().x - i.getRect().x) == 0)))
								&& (((Math.abs(temp.getRect().x - i.getRect().x))
										+ (Math.abs(temp.getRect().y - i.getRect().y))) != 0)) {
							temp.reactToClick(p, player);
						}

					}
				}
			}

			if (i.getHitBox().contains(p)) {
				i.reactToClick(p, player);
			} // all other objects, in this case only the button
		}
		int count = 0;
		for (int index = 0; index < getItems().size(); index++) {
			Item i = getItems().get(index);
			if (i instanceof lightTile) {
				if (((lightTile) i).isOn()) {
					count++;
				}
			}
		}
		if (count == 16) {
			isDone = true;
		}

	}

	public boolean isDone() {
		return isDone;
	}

}

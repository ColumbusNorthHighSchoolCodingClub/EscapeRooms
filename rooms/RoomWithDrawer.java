/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.Drawer;
import items.Key;
import items.LockedDoor;
import java.awt.Point;

/**
 *
 * @author 22willsr
 */
public class RoomWithDrawer extends Room{
    public boolean keyAdded = false;

	public RoomWithDrawer() {
		super();
		this.addItem(new LockedDoor());
		this.addItem(new Drawer());

	}

	public void onClickGeneric(Point p, Player player) {

		for (int i = 0; i < getItems().size(); i++) {
			Item a = getItems().get(i);
			if (a.getHitBox().contains(p)) {
				a.reactToClick(p, player);
				if (a instanceof Drawer) {
					a.reactToClick(p, player);
					if (!keyAdded) {
						this.addItem(new Key(new Point(230, 230)));
						keyAdded = true;
					}
				}

			}
		}
	}

	public boolean isDone() {
		return ((LockedDoor) getItemByName("LockedDoor")).isOpen();
	}
}

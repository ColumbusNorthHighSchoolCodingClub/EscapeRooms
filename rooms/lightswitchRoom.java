package rooms;

import java.awt.Color;
import java.awt.Point;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.SimpleButton;
import items.anotherButton;
import items.lightSwitch;

public class lightswitchRoom extends Room {
	public lightswitchRoom() {
		super();
		this.addItem(new BasicDoor());
		this.addItem(new lightSwitch(50, 300, 20, 20));
		this.addItem(new anotherButton(230, 120, 10, 10));
	}

	public void onClick(Point p, Player player) {
		for (int index = 0; index < getItems().size(); index++) {
			Item i = getItems().get(index);

			if (i.getHitBox().contains(p)) {
				if (i instanceof BasicDoor) {
					if (((anotherButton) getItemByName("anotherButton")).isOn())
						i.reactToClick(p, player);
				} else // all other objects, in this case only the button
					i.reactToClick(p, player);

			}
		}
	}

	public boolean isDone() {
		return ((BasicDoor) getItemByName("BasicDoor")).isOpen()
				&& ((anotherButton) getItemByName("anotherButton")).isOn();
	}
}
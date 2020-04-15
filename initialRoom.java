package rooms;

import java.awt.Point;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.SimpleButton;
import items.anotherButton;

public class initialRoom extends Room {

	public initialRoom() {
		super();
		this.addItem(new anotherButton(380, 250, 80, 150));
	}

	public void onClick(Point p, Player player) {
		for (int index = 0; index < getItems().size(); index++) {
			Item i = getItems().get(index);

			if (i.getHitBox().contains(p)) {
				if (((anotherButton) getItemByName("anotherButton")).isOn())
					i.reactToClick(p, player);
			} else // all other objects, in this case only the button
				i.reactToClick(p, player);

		}
	}

	public boolean isDone() {
		return ((anotherButton) getItemByName("anotherButton")).isOn();
	}

}

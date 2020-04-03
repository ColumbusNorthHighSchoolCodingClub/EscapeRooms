package rooms;

import java.awt.Point;
import java.util.ArrayList;

import javax.print.attribute.standard.Copies;

import items.Blue;
import items.Clues;
import items.Green;
import items.Indigo;
import items.NamedButton;
import items.BasicDoor;
import items.Orange;
import items.Red;
import items.Yellow;
import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;

public class RainbowRoom extends Room {

	public RainbowRoom() {
		super();
	

		this.addItem(new Red("R", "R", new Point(100, 100)));
		this.addItem(new Orange("O", "O", new Point(130, 100)));

		this.addItem(new Yellow("Y", "Y", new Point(160, 100)));

		this.addItem(new Green("G", "G", new Point(190, 100)));

		this.addItem(new Blue("B", "B", new Point(220, 100)));

		this.addItem(new Indigo("I", "I", new Point(250, 100)));

		this.addItem(new Clues());

		this.addItem(new BasicDoor());

	}

	public void onClick(Point p, Player player) {
		Clues c = new Clues();
		System.out.println(c.text());
		char ch1 = c.text().charAt(0);
		char ch2 = c.text().charAt(3);
		char ch3 = c.text().charAt(6);
		char ch4 = c.text().charAt(9);
		char ch5 = c.text().charAt(12);
		char ch6 = c.text().charAt(15);
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println(ch6);
		String s1 = Character.toString(ch1);
		String s2 = Character.toString(ch2);
		String s3 = Character.toString(ch3);
		String s4 = Character.toString(ch4);
		String s5 = Character.toString(ch5);
		String s6 = Character.toString(ch6);
		for (int i = 0; i < getItems().size(); i++) {
			Item it = getItems().get(i);
			if (it.getHitBox().contains(p)) {
				if (it instanceof BasicDoor) {
					if (((NamedButton) getItemByName(s1)).isOn()) {
						if (((NamedButton) getItemByName(s2)).isOn()) {
							if (((NamedButton) getItemByName(s3)).isOn()) {
								if (((NamedButton) getItemByName(s4)).isOn()) {
									if (((NamedButton) getItemByName(s5))
											.isOn()) {
										if (((NamedButton) getItemByName(s6))
												.isOn()) {
											it.reactToClick(p, player);
										}
									}
								}
							}
						}
					}
				} else {
					it.reactToClick(p, player);

				}

			}
		}
	}

	public boolean isDone() {
		return ((BasicDoor) getItemByName("BasicDoor")).isOpen()
				&& ((Red) getItemByName("R")).isOn()
				&& ((Orange) getItemByName("O")).isOn()
				&& ((Yellow) getItemByName("Y")).isOn()
				&& ((Green) getItemByName("G")).isOn()
				&& ((Blue) getItemByName("B")).isOn()
				&& ((Indigo) getItemByName("I")).isOn();
	}

}

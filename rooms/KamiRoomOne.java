package rooms;

import gameObjects.Room;
import items.BasicDoor; 
import items.KamiPuzzle;
import util.KamiPuzzleBuilder;
import util.Triangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

/**
 * This room contains one Kami Puzzle
 * 
 * @author 22raor
 * @author 22wangj
 * @author 22banerjeea
 *
 */
public class KamiRoomOne extends Room {
	public KamiRoomOne() {
		super();
		Triangle[] arr = 
				{new Triangle(new Point(192, 20), new Point(218, 35), new Point(192, 50), new Color(-16711681)),
				new Triangle(new Point(218, 35), new Point(192, 50), new Point(218, 65), new Color(-65536)),
				new Triangle(new Point(192, 50), new Point(218, 65), new Point(192, 80), new Color(-65536)),
				new Triangle(new Point(192, 50), new Point(192, 80), new Point(166, 65), new Color(-65536)),
				new Triangle(new Point(192, 80), new Point(166, 65), new Point(166, 95), new Color(-65536)),
				new Triangle(new Point(192, 20), new Point(192, 50), new Point(166, 35), new Color(-16711681)),
				new Triangle(new Point(192, 50), new Point(166, 65), new Point(166, 35), new Color(-16711681)),
				new Triangle(new Point(166, 65), new Point(166, 35), new Point(140, 50), new Color(-16711681)),
				new Triangle(new Point(166, 65), new Point(140, 50), new Point(140, 80), new Color(-12566464)),
				new Triangle(new Point(166, 65), new Point(166, 95), new Point(140, 80), new Color(-12566464)),
				new Triangle(new Point(218, 65), new Point(192, 80), new Point(218, 95), new Color(-16711681)),
				new Triangle(new Point(218, 65), new Point(218, 95), new Point(244, 80), new Color(-16711681)),
				new Triangle(new Point(218, 95), new Point(244, 80), new Point(244, 110), new Color(-16711681)),
				new Triangle(new Point(244, 80), new Point(244, 110), new Point(270, 95), new Color(-16711681)),
				new Triangle(new Point(218, 95), new Point(244, 110), new Point(218, 125), new Color(-16711681)),
				new Triangle(new Point(218, 95), new Point(218, 125), new Point(192, 110), new Color(-16711681)),
				new Triangle(new Point(192, 80), new Point(218, 95), new Point(192, 110), new Color(-12566464)),
				new Triangle(new Point(244, 110), new Point(270, 95), new Point(270, 125), new Color(-65536)),
				new Triangle(new Point(244, 110), new Point(270, 125), new Point(244, 140), new Color(-65536)),
				new Triangle(new Point(244, 110), new Point(218, 125), new Point(244, 140), new Color(-65536)),
				new Triangle(new Point(218, 125), new Point(244, 140), new Point(218, 155), new Color(-65536)),
				new Triangle(new Point(218, 125), new Point(218, 155), new Point(192, 140), new Color(-12566464)),
				new Triangle(new Point(218, 125), new Point(192, 110), new Point(192, 140), new Color(-12566464)),
				new Triangle(new Point(192, 110), new Point(192, 140), new Point(166, 125), new Color(-65536)),
				new Triangle(new Point(192, 140), new Point(166, 125), new Point(166, 155), new Color(-65536)),
				new Triangle(new Point(192, 140), new Point(166, 155), new Point(192, 170), new Color(-65536)),
				new Triangle(new Point(166, 125), new Point(166, 155), new Point(140, 140), new Color(-65536)),
				new Triangle(new Point(166, 155), new Point(140, 140), new Point(140, 170), new Color(-65536)),
				new Triangle(new Point(166, 155), new Point(140, 170), new Point(166, 185), new Color(-65536)),
				new Triangle(new Point(166, 155), new Point(192, 170), new Point(166, 185), new Color(-65536)),
				new Triangle(new Point(140, 170), new Point(166, 185), new Point(140, 200), new Color(-65536)),
				new Triangle(new Point(166, 185), new Point(140, 200), new Point(166, 215), new Color(-65536)),
				new Triangle(new Point(140, 200), new Point(166, 215), new Point(140, 230), new Color(-65536)),
				new Triangle(new Point(192, 170), new Point(166, 185), new Point(192, 200), new Color(-16711681)),
				new Triangle(new Point(192, 170), new Point(192, 200), new Point(218, 185), new Color(-16711681)),
				new Triangle(new Point(192, 170), new Point(218, 185), new Point(218, 155), new Color(-16711681)),
				new Triangle(new Point(218, 185), new Point(218, 155), new Point(244, 170), new Color(-16711681)),
				new Triangle(new Point(244, 140), new Point(218, 155), new Point(244, 170), new Color(-16711681)),
				new Triangle(new Point(244, 140), new Point(244, 170), new Point(270, 155), new Color(-16711681)),
				new Triangle(new Point(166, 185), new Point(166, 215), new Point(192, 200), new Color(-12566464)),
				new Triangle(new Point(166, 215), new Point(192, 200), new Point(192, 230), new Color(-12566464)),
				new Triangle(new Point(140, 140), new Point(140, 170), new Point(114, 155), new Color(-12566464)),
				new Triangle(new Point(140, 140), new Point(114, 155), new Point(114, 125), new Color(-12566464)),
				new Triangle(new Point(140, 170), new Point(114, 155), new Point(114, 185), new Color(-12566464)),
				new Triangle(new Point(140, 170), new Point(140, 200), new Point(114, 185), new Color(-12566464)),
				new Triangle(new Point(140, 200), new Point(114, 185), new Point(114, 215), new Color(-12566464)),
				new Triangle(new Point(140, 200), new Point(140, 230), new Point(114, 215), new Color(-12566464)),
				new Triangle(new Point(140, 140), new Point(114, 125), new Point(140, 110), new Color(-16711681)),
				new Triangle(new Point(166, 125), new Point(140, 140), new Point(140, 110), new Color(-16711681)),
				new Triangle(new Point(166, 125), new Point(140, 110), new Point(166, 95), new Color(-16711681)),
				new Triangle(new Point(192, 110), new Point(166, 125), new Point(166, 95), new Color(-16711681)),
				new Triangle(new Point(192, 200), new Point(192, 230), new Point(218, 215), new Color(-65536)),
				new Triangle(new Point(192, 200), new Point(218, 185), new Point(218, 215), new Color(-65536)),
				new Triangle(new Point(218, 185), new Point(218, 215), new Point(244, 200), new Color(-65536)),
				new Triangle(new Point(218, 185), new Point(244, 170), new Point(244, 200), new Color(-65536)),
				new Triangle(new Point(244, 170), new Point(270, 155), new Point(270, 185), new Color(-65536)),
				new Triangle(new Point(244, 170), new Point(244, 200), new Point(270, 185), new Color(-65536)),
				new Triangle(new Point(192, 230), new Point(218, 215), new Point(218, 245), new Color(-16711681)),
				new Triangle(new Point(218, 215), new Point(244, 200), new Point(244, 230), new Color(-16711681)),
				new Triangle(new Point(218, 215), new Point(218, 245), new Point(244, 230), new Color(-16711681)),
				new Triangle(new Point(244, 200), new Point(244, 230), new Point(270, 215), new Color(-16711681)),
				new Triangle(new Point(218, 245), new Point(244, 230), new Point(244, 260), new Color(-65536)),
				new Triangle(new Point(244, 230), new Point(244, 260), new Point(270, 245), new Color(-65536)),
				new Triangle(new Point(244, 230), new Point(270, 215), new Point(270, 245), new Color(-65536)),
				new Triangle(new Point(218, 245), new Point(244, 260), new Point(218, 275), new Color(-65536)),
				new Triangle(new Point(192, 230), new Point(218, 245), new Point(192, 260), new Color(-12566464)),
				new Triangle(new Point(218, 245), new Point(218, 275), new Point(192, 260), new Color(-12566464)),
				new Triangle(new Point(218, 275), new Point(192, 260), new Point(192, 290), new Color(-16711681)),
				new Triangle(new Point(192, 260), new Point(192, 290), new Point(166, 275), new Color(-16711681)),
				new Triangle(new Point(244, 260), new Point(218, 275), new Point(244, 290), new Color(-16711681)),
				new Triangle(new Point(244, 260), new Point(244, 290), new Point(270, 275), new Color(-16711681)),
				new Triangle(new Point(218, 275), new Point(192, 290), new Point(218, 305), new Color(-65536)),
				new Triangle(new Point(192, 290), new Point(218, 305), new Point(192, 320), new Color(-65536)),
				new Triangle(new Point(218, 275), new Point(244, 290), new Point(218, 305), new Color(-12566464)),
				new Triangle(new Point(244, 290), new Point(218, 305), new Point(244, 320), new Color(-12566464)),
				new Triangle(new Point(244, 290), new Point(244, 320), new Point(270, 305), new Color(-65536)),
				new Triangle(new Point(244, 290), new Point(270, 275), new Point(270, 305), new Color(-65536)),
				new Triangle(new Point(192, 290), new Point(166, 275), new Point(166, 305), new Color(-12566464)),
				new Triangle(new Point(192, 290), new Point(192, 320), new Point(166, 305), new Color(-12566464)),
				new Triangle(new Point(218, 305), new Point(244, 320), new Point(218, 335), new Color(-16711681)),
				new Triangle(new Point(218, 305), new Point(192, 320), new Point(218, 335), new Color(-16711681)),
				new Triangle(new Point(192, 320), new Point(166, 305), new Point(166, 335), new Color(-16711681)),
				new Triangle(new Point(166, 305), new Point(166, 335), new Point(140, 320), new Color(-16711681)),
				new Triangle(new Point(166, 335), new Point(140, 320), new Point(140, 350), new Color(-16711681)),
				new Triangle(new Point(140, 320), new Point(140, 350), new Point(114, 335), new Color(-16711681)),
				new Triangle(new Point(114, 185), new Point(114, 215), new Point(88, 200), new Color(-65536)),
				new Triangle(new Point(114, 215), new Point(88, 200), new Point(88, 230), new Color(-65536)),
				new Triangle(new Point(114, 215), new Point(88, 230), new Point(114, 245), new Color(-65536)),
				new Triangle(new Point(88, 230), new Point(114, 245), new Point(88, 260), new Color(-65536)),
				new Triangle(new Point(114, 245), new Point(88, 260), new Point(114, 275), new Color(-65536)),
				new Triangle(new Point(88, 260), new Point(114, 275), new Point(88, 290), new Color(-65536)),
				new Triangle(new Point(88, 260), new Point(88, 290), new Point(62, 275), new Color(-12566464)),
				new Triangle(new Point(88, 260), new Point(62, 275), new Point(62, 245), new Color(-12566464)),
				new Triangle(new Point(88, 230), new Point(88, 260), new Point(62, 245), new Color(-12566464)),
				new Triangle(new Point(88, 230), new Point(62, 245), new Point(62, 215), new Color(-12566464)),
				new Triangle(new Point(88, 200), new Point(88, 230), new Point(62, 215), new Color(-12566464)),
				new Triangle(new Point(88, 200), new Point(62, 215), new Point(62, 185), new Color(-12566464)),
				new Triangle(new Point(192, 320), new Point(218, 335), new Point(192, 350), new Color(-12566464)),
				new Triangle(new Point(218, 335), new Point(192, 350), new Point(218, 365), new Color(-12566464)),
				new Triangle(new Point(140, 350), new Point(114, 335), new Point(114, 365), new Color(-12566464)),
				new Triangle(new Point(140, 350), new Point(114, 365), new Point(140, 380), new Color(-12566464)),
				new Triangle(new Point(166, 335), new Point(140, 350), new Point(166, 365), new Color(-65536)),
				new Triangle(new Point(140, 350), new Point(140, 380), new Point(166, 365), new Color(-65536)),
				new Triangle(new Point(192, 320), new Point(166, 335), new Point(192, 350), new Color(-65536)),
				new Triangle(new Point(166, 335), new Point(166, 365), new Point(192, 350), new Color(-65536)),
				new Triangle(new Point(244, 320), new Point(218, 335), new Point(244, 350), new Color(-65536)),
				new Triangle(new Point(218, 335), new Point(218, 365), new Point(244, 350), new Color(-65536)),
				new Triangle(new Point(166, 365), new Point(192, 350), new Point(192, 380), new Color(-16711681)),
				new Triangle(new Point(192, 350), new Point(218, 365), new Point(192, 380), new Color(-16711681)),
				new Triangle(new Point(166, 365), new Point(192, 380), new Point(166, 395), new Color(-12566464)),
				new Triangle(new Point(192, 380), new Point(166, 395), new Point(192, 410), new Color(-12566464)),
				new Triangle(new Point(218, 365), new Point(192, 380), new Point(218, 395), new Color(-65536)),
				new Triangle(new Point(192, 380), new Point(192, 410), new Point(218, 395), new Color(-65536)),
				new Triangle(new Point(140, 320), new Point(114, 335), new Point(114, 305), new Color(-65536)),
				new Triangle(new Point(140, 320), new Point(114, 305), new Point(140, 290), new Color(-65536)),
				new Triangle(new Point(114, 335), new Point(114, 305), new Point(88, 320), new Color(-65536)),
				new Triangle(new Point(114, 335), new Point(88, 320), new Point(88, 350), new Color(-65536)),
				new Triangle(new Point(88, 320), new Point(88, 350), new Point(62, 335), new Color(-65536)),
				new Triangle(new Point(88, 350), new Point(62, 335), new Point(62, 365), new Color(-65536)),
				new Triangle(new Point(62, 335), new Point(62, 365), new Point(36, 350), new Color(-12566464)),
				new Triangle(new Point(62, 335), new Point(36, 350), new Point(36, 320), new Color(-12566464)),
				new Triangle(new Point(62, 335), new Point(36, 320), new Point(62, 305), new Color(-16711681)),
				new Triangle(new Point(88, 320), new Point(62, 335), new Point(62, 305), new Color(-16711681)),
				new Triangle(new Point(88, 320), new Point(62, 305), new Point(88, 290), new Color(-16711681)),
				new Triangle(new Point(114, 305), new Point(88, 320), new Point(88, 290), new Color(-16711681)),
				new Triangle(new Point(114, 275), new Point(88, 290), new Point(114, 305), new Color(-16711681)),
				new Triangle(new Point(114, 305), new Point(140, 290), new Point(114, 275), new Color(-16711681)),
				new Triangle(new Point(36, 320), new Point(62, 305), new Point(36, 290), new Color(-65536)),
				new Triangle(new Point(62, 305), new Point(36, 290), new Point(62, 275), new Color(-65536)),
				new Triangle(new Point(36, 290), new Point(62, 275), new Point(36, 260), new Color(-65536)),
				new Triangle(new Point(62, 275), new Point(62, 245), new Point(36, 260), new Color(-65536)),
				new Triangle(new Point(36, 290), new Point(36, 260), new Point(10, 275), new Color(-12566464)),
				new Triangle(new Point(36, 320), new Point(36, 290), new Point(10, 305), new Color(-12566464)),
				new Triangle(new Point(36, 290), new Point(10, 275), new Point(10, 305), new Color(-12566464)),
				new Triangle(new Point(36, 260), new Point(10, 275), new Point(10, 245), new Color(-12566464)),
				new Triangle(new Point(36, 260), new Point(10, 245), new Point(36, 230), new Color(-16711681)),
				new Triangle(new Point(62, 245), new Point(36, 260), new Point(36, 230), new Color(-16711681)),
				new Triangle(new Point(88, 200), new Point(62, 185), new Point(88, 170), new Color(-16711681)),
				new Triangle(new Point(114, 185), new Point(88, 200), new Point(88, 170), new Color(-16711681)),
				new Triangle(new Point(62, 185), new Point(88, 170), new Point(62, 155), new Color(-65536)),
				new Triangle(new Point(88, 170), new Point(62, 155), new Point(88, 140), new Color(-65536)),
				new Triangle(new Point(62, 185), new Point(62, 155), new Point(36, 170), new Color(-12566464)),
				new Triangle(new Point(62, 155), new Point(36, 170), new Point(36, 140), new Color(-12566464)),
				new Triangle(new Point(36, 170), new Point(36, 140), new Point(10, 155), new Color(-12566464)),
				new Triangle(new Point(36, 140), new Point(10, 155), new Point(10, 125), new Color(-12566464)),
				new Triangle(new Point(36, 140), new Point(10, 125), new Point(36, 110), new Color(-16711681)),
				new Triangle(new Point(36, 140), new Point(36, 110), new Point(62, 125), new Color(-16711681)),
				new Triangle(new Point(62, 155), new Point(36, 140), new Point(62, 125), new Color(-16711681)),
				new Triangle(new Point(62, 155), new Point(88, 140), new Point(62, 125), new Color(-16711681)) };

		this.addItem(new KamiPuzzle(arr,9));
	}

	public boolean isDone() {
		return ((KamiPuzzle)getItemByName("KamiPuzzle")).isSolved();
	}

	public void draw(Graphics g, ImageObserver io) {

		super.draw(g, io);

	}
}

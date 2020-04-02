package animation;

/**
 * Class ArcadeDemo
 * This class contains demos of many of the things you might
 * want to use to make an animated arcade game.
 * 
 * Adapted from the AppletAE demo from years past. 
 */

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.applet.AudioClip;
import java.awt.Point;
import java.util.ArrayList;
import rooms.RoomOne;
import rooms.RoomWithStuff;
import rooms.RoomZero;
import rooms.initialRoom;
import rooms.lightswitchRoom;

public class ArcadeDemo extends AnimationPanel {

	// Constants
	// -------------------------------------------------------

	// Instance Variables
	// -------------------------------------------------------
	private Player player;
	private ArrayList<Room> rooms;
	private int currentRoom;

	private boolean waitMode;
	private boolean started = false;
	private int waitBeforeNextRoomTimer;

	// Constructor
	// -------------------------------------------------------
	public ArcadeDemo() { // Enter the name and width and height.
		super("Escape Room 2020", 640, 480);
		player = new Player("Demo");
		rooms = new ArrayList<>();
		addRoomsToList();
		currentRoom = 0;
		waitMode = false;
		waitBeforeNextRoomTimer = 0;
	}

	public void addRoomsToList() {
		rooms.add(new initialRoom());
		rooms.add(new lightswitchRoom());
		rooms.add(new RoomZero());
		rooms.add(new RoomOne());
		rooms.add(new RoomWithStuff());
	}

	// The renderFrame method is the one which is called each time a frame is drawn.
	// -------------------------------------------------------
	protected Graphics renderFrame(Graphics g) {
		if (started == false) {
			g.drawImage(startingScreen, 0, -10, null);
			if(rooms.get(currentRoom).isDone())
			{
				started = true;
				currentRoom++;
			}
		} else {
			// Draw a square that is stationary on the screen.
			g.setColor(Color.BLUE);
			g.fillRect(220, 120, 50, 50);

			// Draw a circle that follows the mouse.
			g.setColor(Color.BLACK);
			g.fillOval(mouseX - 10, mouseY - 10, 20, 20);

			rooms.get(currentRoom).draw(g, this);

			if (rooms.get(currentRoom).isDone() && !waitMode) {
				waitMode = true;
				waitBeforeNextRoomTimer = 200;
			}
			if (waitMode) {
				if (waitBeforeNextRoomTimer > 0) {
					waitBeforeNextRoomTimer--;
					g.drawImage(congrats ,0,-10,null);
				} else {
					waitMode = false;
					if (currentRoom < rooms.size() - 1)
						currentRoom++;
					else
						System.out.println("You Have Escaped ALL the rooms!");
				}

			}

			// General Text (Draw this last to make sure it's on top.)
			g.setColor(Color.BLACK);
			g.drawString("CurrentRoom = " + currentRoom, 10, 12);
			g.drawString("f#" + frameNumber, 150, 12);
		}
		return g;
	}// --end of renderFrame method--

	// -------------------------------------------------------
	// Respond to Mouse Events
	// -------------------------------------------------------
	public void mouseClicked(MouseEvent e) {
		Point clickPoint = e.getPoint();
		rooms.get(currentRoom).onClick(clickPoint, player);
	}

	// -------------------------------------------------------
	// Respond to Keyboard Events
	// -------------------------------------------------------
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();

	}

	public void keyPressed(KeyEvent e) {
		int v = e.getKeyCode();

	}

	public void keyReleased(KeyEvent e) {
		int v = e.getKeyCode();

	}

	// -------------------------------------------------------
	// Initialize Graphics
	// -------------------------------------------------------
//-----------------------------------------------------------------------
	/*
	 * Image section... To add a new image to the program, do three things. 1. Make
	 * a declaration of the Image by name ... Image imagename; 2. Actually make the
	 * image and store it in the same directory as the code. 3. Add a line into the
	 * initGraphics() function to load the file.
	 * //-----------------------------------------------------------------------
	 */
	Image ballImage;
	Image starImage;
	Image startingScreen;
	Image congrats;
	public void initGraphics() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Item.loadImages(toolkit);
		startingScreen = toolkit.getImage("src/escape.png");
		congrats = toolkit.getImage("src/congrats.jpg");
//        ballImage = toolkit.getImage("ball.gif");
//        starImage = toolkit.getImage("star.gif");
	} // --end of initGraphics()--

	// -------------------------------------------------------
	// Initialize Sounds
	// -------------------------------------------------------
//-----------------------------------------------------------------------
	/*
	 * Music section... To add music clips to the program, do four things. 1. Make a
	 * declaration of the AudioClip by name ... AudioClip clipname; 2. Actually
	 * make/get the .wav file and store it in the same directory as the code. 3. Add
	 * a line into the initMusic() function to load the clip. 4. Use the play(),
	 * stop() and loop() functions as needed in your code.
	 * //-----------------------------------------------------------------------
	 */
	AudioClip themeMusic;
	AudioClip bellSound;

	public void initMusic() {
	}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}// --end of ArcadeDemo class--

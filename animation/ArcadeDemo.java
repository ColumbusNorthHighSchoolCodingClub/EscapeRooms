package animation;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Class ArcadeDemo
 * This class contains demos of many of the things you might
 * want to use to make an animated arcade game.
 * 
 * Adapted from the AppletAE demo from years past. 
 */
import javax.swing.JOptionPane;
import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import gameObjects.TextBox;
import rooms.CandleRoom;
import rooms.ColorButtonRoom;
import rooms.ColorRoom;
import rooms.CustomRoom;
import rooms.KamiRoomOne;
import rooms.MultiButtonRoom;
import rooms.RainbowRoom;
import rooms.RoomOne;
import rooms.RoomSearch;
import rooms.RushHourRoom;
//import rooms.RoomThree;
import rooms.MazeRoom;
import rooms.MysteryDoorRoom;
import rooms.RoomLetters;
import rooms.RoomWithDrawer;
import rooms.RoomWithRandomHiddenButton;
import rooms.RoomWithStuff;
import rooms.RoomZero;
import rooms.SafeRoom;
import rooms.TimedButtonRoom;
import rooms.initialRoom;
import rooms.lightswitchRoom;


public class ArcadeDemo extends AnimationPanel 
{

    //Constants
    //-------------------------------------------------------

    //Instance Variables
    //-------------------------------------------------------
    private Player player; 
    private ArrayList<Room> rooms;
    private int currentRoom; 
    public static TextBox textBox;
    
    private boolean waitMode;
    private int waitBeforeNextRoomTimer;
    private boolean started = false;
    private int totalTime;
    private int roomTime;
    private String cheatSequence = "";
    //Constructor
    //-------------------------------------------------------
    public ArcadeDemo()
    {   //Enter the name and width and height.  
        super("Escape Room 2020", 640, 480);
        player = new Player("Demo");
        rooms = new ArrayList<>();
        addRoomsToList();
        currentRoom = 0;
        
        waitMode = false;
        waitBeforeNextRoomTimer = 0;
        totalTime=0;
        roomTime=0;
        textBox=new TextBox();
    }
    
    public void addRoomsToList()
    {
        rooms.add(new initialRoom());
        rooms.add(new MysteryDoorRoom()); 
        rooms.add(new ColorButtonRoom());
        rooms.add(new CandleRoom()); 
        rooms.add(new RoomWithDrawer());
        rooms.add(new lightswitchRoom());    	
        rooms.add(new RainbowRoom());
    	rooms.add(new TimedButtonRoom());
    	rooms.add(new RoomSearch());
    	rooms.add(new RushHourRoom());
        rooms.add(new MazeRoom());
        rooms.add(new RoomZero());
        rooms.add(new MultiButtonRoom());
        rooms.add(new RoomWithStuff());
    	rooms.add(new KamiRoomOne());
        rooms.add(new CustomRoom()); //good, not easy
        rooms.add(new RoomLetters());
        rooms.add(new RoomWithRandomHiddenButton()); //DIFFICULT!
        rooms.add(new ColorRoom());  //can't get to work
        rooms.add(new RoomOne());        
        rooms.add(new SafeRoom());  //Crashes
    }
       
    //The renderFrame method is the one which is called each time a frame is drawn.
    //-------------------------------------------------------
    protected Graphics renderFrame(Graphics g) 
    {
        if (started == false) {
                g.drawImage(startingScreen, 0, -10, null);
                if(rooms.get(currentRoom).isDone())
                {
                        started = true;
                        currentRoom++;
                }
        } else {
        
            //Draw a circle that follows the mouse.
            g.setColor(Color.BLACK);
            g.fillOval(mouseX-10, mouseY-10, 20,20);

            rooms.get(currentRoom).draw(g,this);
            rooms.get(currentRoom).updateMouseCoords(mouseX, mouseY);

            if (rooms.get(currentRoom).isDone() && !waitMode) 
            {   
                waitMode = true;
                waitBeforeNextRoomTimer = 200;
            }
            if(waitMode)
            {
                if(waitBeforeNextRoomTimer > 0)
                {
                    waitBeforeNextRoomTimer--;
                    g.drawImage(congrats ,0,-10,null);     
                }
                else
                {
                    textBox.closeBox();
                    waitMode = false;
                    if(currentRoom < rooms.size()-1)
                    {
                        currentRoom++;
                        roomTime=0;
                    }
                    else
                    {
                        textBox.openBox("You Have Escaped ALL the rooms!",false);
                        System.out.println("You Have Escaped ALL the rooms!");
                    }
                }

            }
            textBox.draw(g, this);
            player.drawInventory(g, this);

            //General Text (Draw this last to make sure it's on top.)
            g.setColor(Color.BLACK);
            g.drawString("CurrentRoom = "+currentRoom, 10, 12);
            g.drawString("f#"+frameNumber, 150, 12);
            g.drawString("Total Time: "+totalTime/60, 500, 80);
            g.drawString("Room Time: "+roomTime/60, 500, 100);
            roomTime++;
            totalTime++;
        }
        return g;

    }//--end of renderFrame method--
    
    //-------------------------------------------------------
    //Respond to Mouse Events
    //-------------------------------------------------------
    public void mouseClicked(MouseEvent e)  
    { 
        Point clickPoint = e.getPoint();
        if(textBox.shouldClose()&&textBox.isOpen()) {
            textBox.closeBox();
        } else {        
            rooms.get(currentRoom).onClick(clickPoint, player);
            rooms.get(currentRoom).onClickGeneric(clickPoint, player);
        }
    }
    public void mouseDragged(MouseEvent e) 
    {
    	Point clickPoint = e.getPoint();
        rooms.get(currentRoom).onDrag(clickPoint, player);
    	
    }
    public void mouseReleased(MouseEvent e) 
    {
    	Point clickPoint = e.getPoint();
        rooms.get(currentRoom).onMouseRelease(clickPoint, player);
    	
    }
    
    //-------------------------------------------------------
    //Respond to Keyboard Events
    //-------------------------------------------------------

	public void keyTyped(KeyEvent e) {
		
		char c = e.getKeyChar();

		if (c == 'b')
			cheatSequence = "b"; // Restart the sequence when b is typed.
		else
			cheatSequence += c;

		if (cheatSequence.contentEquals("backdoor")) {

			String[] allRoomNames = new String[rooms.size()];
			for (int i = 0; i<rooms.size(); i++) {
				allRoomNames[i] = rooms.get(i).getClass().getName();
			}

			cheatSequence = "";
			String desiredRoom = (String) JOptionPane.showInputDialog(null, "Please choose a room", "Cheat Menu",
					JOptionPane.QUESTION_MESSAGE, null,
					 allRoomNames, rooms.get(currentRoom).getClass().getName() );

			for (int i = 0; i < rooms.size(); i++) {
				if (rooms.get(i).getClass().getName().equals(desiredRoom)) {
					currentRoom = i;
					return;

				}

			}

		}

		rooms.get(currentRoom).onKey(c, player);
	}
    
    public void keyPressed(KeyEvent e)
    {
        int v = e.getKeyCode();
        
    }

    public void keyReleased(KeyEvent e)
    {
        int v = e.getKeyCode();
        
    }
    
    
    //-------------------------------------------------------
    //Initialize Graphics
    //-------------------------------------------------------
//-----------------------------------------------------------------------
/*  Image section... 
 *  To add a new image to the program, do three things.
 *  1.  Make a declaration of the Image by name ...  Image imagename;
 *  2.  Actually make the image and store it in the same directory as the code.
 *  3.  Add a line into the initGraphics() function to load the file. 
//-----------------------------------------------------------------------*/
    Image ballImage;        
    Image starImage;
    Image startingScreen;
    Image congrats;
    
    public void initGraphics() 
    {      
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        Item.loadImages(toolkit);
        startingScreen = toolkit.getImage("src/items/images/escape.png");
        congrats = toolkit.getImage("src/items/images/congrats.jpg");
//        ballImage = toolkit.getImage("ball.gif");
//        starImage = toolkit.getImage("star.gif");
    } //--end of initGraphics()--
    
    //-------------------------------------------------------
    //Initialize Sounds
    //-------------------------------------------------------
//-----------------------------------------------------------------------
/*  Music section... 
 *  To add music clips to the program, do four things.
 *  1.  Make a declaration of the AudioClip by name ...  AudioClip clipname;
 *  2.  Actually make/get the .wav file and store it in the same directory as the code.
 *  3.  Add a line into the initMusic() function to load the clip. 
 *  4.  Use the play(), stop() and loop() functions as needed in your code.
//-----------------------------------------------------------------------*/
    AudioClip themeMusic;
    AudioClip bellSound;
    
    public void initMusic() 
    {
    }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}//--end of ArcadeDemo class--


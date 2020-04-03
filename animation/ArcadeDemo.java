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
import gameObjects.TextBox;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.applet.AudioClip;   
import java.awt.Point;
import java.util.ArrayList;
import rooms.CustomRoom;


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
    private boolean done;

    //Constructor
    //-------------------------------------------------------
    public ArcadeDemo()
    {   //Enter the name and width and height.  
        super("Escape Room 2020", 640, 480);
        player = new Player("Demo");
        rooms = new ArrayList<>();
        addRoomsToList();
        currentRoom = 0;
        done = false;
        waitMode = false;
        waitBeforeNextRoomTimer = 0;
        textBox=new TextBox();
    }
    
    public void addRoomsToList()
    {
        rooms.add(new CustomRoom());
    }
       
    //The renderFrame method is the one which is called each time a frame is drawn.
    //-------------------------------------------------------
    protected Graphics renderFrame(Graphics g) 
    {
        g.drawString("( " + mouseX + " , " + mouseY + " )", 200,10);
        //g.fillOval(mouseX-10, mouseY-10, 20,20);
        
        rooms.get(currentRoom).draw(g,this);
        
        if (rooms.get(currentRoom).isDone() && !waitMode&&!done) 
        {   
            textBox.openBox("You Have Escaped!",false);
            waitMode = true;
            waitBeforeNextRoomTimer = 100;
        }
        
        if(waitMode)
        {
            if(waitBeforeNextRoomTimer > 0)
            {
                waitBeforeNextRoomTimer--;
                //g.setFont(ArcadeRunner.customFont);
                //g.drawString("You Have Escaped!", 250, 150);
                
            }
            else
            {
                textBox.closeBox();
                waitMode = false;
                if(currentRoom < rooms.size()-1)
                    currentRoom++;
                else {
                    done = true;
                    textBox.openBox("You Have Escaped ALL the rooms!",false);
                }
            }
            
        }
        textBox.draw(g, this);
        player.drawInventory(g, this);
        //General Text (Draw this last to make sure it's on top.)
        g.setColor(Color.BLACK);
        g.setFont(ArcadeRunner.customFont);
        g.drawString("CurrentRoom = "+currentRoom, 10, 20);
        //g.drawString("f#"+frameNumber, 150, 12);
        
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
            player.onClick(mouseX, mouseY);
        }
    }
    
    //-------------------------------------------------------
    //Respond to Keyboard Events
    //-------------------------------------------------------
    public void keyTyped(KeyEvent e) 
    {
        char c = e.getKeyChar();

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
    
    public void initGraphics() 
    {      
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        Item.loadImages(toolkit);
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


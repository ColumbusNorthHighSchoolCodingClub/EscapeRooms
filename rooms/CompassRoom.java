package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.NamedButton;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class CompassRoom extends Room
{
    String sequence = ""; //The sequence of buttons that have been pressed.  
    
    public CompassRoom()
    {
        super();
        this.addItem(new NamedButton("N","N",new Point(100,100)));
        this.addItem(new NamedButton("E","E",new Point(130,130)));
        this.addItem(new NamedButton("S","S",new Point(100,160)));
        this.addItem(new NamedButton("W","W",new Point(70,130)));
        this.addItem(new BasicDoor());
   }

    public void onClick(Point p, Player player)
    {        
        for(int index=0; index<getItems().size(); index++)
        {
            Item i = getItems().get(index);
        
            if(i.getHitBox().contains(p))
            {
                if(i instanceof BasicDoor)
                {
                    if(sequence.equals("NSEW"))
                         i.reactToClick(p,player);
                }                  
                else if(i instanceof NamedButton)//all other objects, in this case only the buttons
                {
                    if(((NamedButton)i).getName().equals("N"))
                        sequence = "N"; //Restart the sequence when O is typed.
                    else
                        sequence += ((NamedButton)i).getName();
                    
                    i.reactToClick(p,player);
                }                
            }
        }
    }


    
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen();   
    }



    public void draw(Graphics g, ImageObserver io)
    {
        g.drawString("1. Follow the _____ star", 300, 200);
        g.drawString("2. Mexico is ______ of America", 300, 215);
        g.drawString("3. What school is our rival?", 300, 230);
        g.drawString("4. Purdue is located in ____ Lafayette", 300, 245);
        super.draw(g,io);
    }
    
}
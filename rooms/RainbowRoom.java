package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.ColoredButton1;
import items.NamedButton;
import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author spockm
 */
public class RainbowRoom extends Room
{
    String sequence = ""; //The sequence of buttons that have been pressed.  
    
    public RainbowRoom()
    {
        super();
        this.addItem(new ColoredButton1("purple",Color.MAGENTA, new Point(100,100)));
        this.addItem(new ColoredButton1("orange",Color.ORANGE, new Point(130,100)));
        this.addItem(new ColoredButton1("green", Color.GREEN, new Point(160,100)));
        this.addItem(new ColoredButton1("yellow", Color.YELLOW, new Point(190,100)));
        this.addItem(new ColoredButton1("red",Color.RED, new Point(220,100)));
        this.addItem(new ColoredButton1("blue",Color.BLUE, new Point(250,100)));
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
                    if(sequence.equals("redorangeyellowgreenbluepurple"))
                         i.reactToClick(p,player);
                }                  
                else if(i instanceof ColoredButton1)//all other objects, in this case only the buttons
                {
                    if(((ColoredButton1)i).getName().equals("red"))
                        sequence = "red"; //Restart the sequence when red is clicked.
                    else
                        sequence += ((ColoredButton1)i).getName();
                    
                    i.reactToClick(p,player);
                }                
            }
        }
    }
    

    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen();   
    }
}
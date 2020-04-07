package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.NamedButton;
import items.SimpleButton;
import items.NumberedDoor;
import java.awt.Point;

/**
 *
 * @author 20maloneb
 */
public class MysteryDoorRoom extends Room
{
    public MysteryDoorRoom()
    {
        super();
        this.addItem(new NumberedDoor("X","X", new Point(300,100)));
        this.addItem(new NamedButton(" "," ", new Point(200,50)));
        this.addItem(new NamedButton("  ","  ", new Point(100,25)));
        this.addItem(new NamedButton("   ","   ", new Point(300,75)));
        this.addItem(new NamedButton("    ","    ", new Point(150,90)));
        this.addItem(new NamedButton("     ","     ", new Point(50,30)));
    }
    
    public void onClick(Point p, Player player)
    {
        for(int index=0; index<getItems().size(); index++)
        {
            Item i = getItems().get(index);
            
            
            if(i.getHitBox().contains(p))
            {
                if(i instanceof NumberedDoor)
                {
                    if(((NamedButton)getItemByName(" ")).isOn())
                        i.reactToClick(p,player);
                }
                    else
                        i.reactToClick(p,player);
            }
        }
    } 
    
    public boolean isDone()
    {
        return ((NumberedDoor)getItemByName("X")).isOpen();    
    }   
}

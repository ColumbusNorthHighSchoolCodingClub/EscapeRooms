package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.SimpleButton;
import java.awt.Point;

/**
 * This is the room you appear in at the start.  
 * All you have to do is click the door.  
 * @author spockm
 */
public class RoomOne extends Room
{
    public RoomOne()
    {
        super();
        this.addItem(new BasicDoor());
        this.addItem(new SimpleButton());
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
                    if(((SimpleButton)getItemByName("SimpleButton")).isOn())
                         i.reactToClick(p,player);
                }                  
                else //all other objects, in this case only the button
                    i.reactToClick(p,player);
                
            }
        }
    }

    
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen() && 
                ((SimpleButton)getItemByName("SimpleButton")).isOn();    
    }
}

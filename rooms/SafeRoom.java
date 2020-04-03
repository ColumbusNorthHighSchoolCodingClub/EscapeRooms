package rooms;

import gameObjects.Room;
import items.BasicDoor;
import items.CombinationSafe;
import items.LockedDoor;
import items.Paper;


/**
 *   
 *   
 * @author dlpre
 *
 **/
public class SafeRoom extends Room
{
    public SafeRoom()
    {
        super();
       this.addItem(new LockedDoor());
       this.addItem(new CombinationSafe());
       this.addItem(new Paper());
    }
    
   public boolean isDone()
    {
        return ((LockedDoor)getItemByName("LockedDoor")).isOpen() ;    
    }
}

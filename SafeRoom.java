package rooms;

import gameObjects.Room;
import items.BasicDoor;
import items.CombinationSafe;
import items.LockedDoor;
import items.Paper;


/**
 * This is the room you appear in at the start.  
 * All you have to do is click the door.  
 * @author spockm
 */
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

package rooms;

import gameObjects.Room;
import items.Key;
import items.LockedDoor;
import java.awt.Point;

/**
 * This is the room you appear in at the start.  
 * All you have to do is click the door.  
 * @author spockm
 */
public class RoomWithStuff extends Room
{
    public RoomWithStuff()
    {
        super();
        this.addItem(new LockedDoor());
        this.addItem(new Key(new Point(100,100)));
    }
    
    public boolean isDone()
    {
        return ((LockedDoor)getItemByName("LockedDoor")).isOpen() ;    
    }
}

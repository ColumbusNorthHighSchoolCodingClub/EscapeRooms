package rooms;

import gameObjects.Room;
import items.BasicDoor;

/**
 * This is the room you appear in at the start.  
 * All you have to do is click the door.  
 * @author spockm
 */
public class RoomZero extends Room
{
    public RoomZero()
    {
        super();
        this.addItem(new BasicDoor());
    }
    
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen();    
    }
}

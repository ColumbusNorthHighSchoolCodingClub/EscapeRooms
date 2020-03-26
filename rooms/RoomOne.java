package rooms;

import gameObjects.Room;
import items.BasicDoor;
import items.SimpleButton;

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
    
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen() && 
                ((SimpleButton)getItemByName("SimpleButton")).isOn();    
    }
}

package rooms;

import gameObjects.Room;
import items.BasicDoor;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

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
    
    public void draw(Graphics g, ImageObserver io)
    {
        g.drawString("Click on the door to begin!", 200, 200);
        super.draw(g,io);
    }
}

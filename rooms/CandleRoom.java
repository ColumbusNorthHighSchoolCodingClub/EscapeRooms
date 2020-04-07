package rooms;

import gameObjects.Room;
import items.Candle;
import items.WoodenDoor;


public class CandleRoom extends Room       
{
    
    public CandleRoom()
    {
        super();
        
        this.addItem(new WoodenDoor());
        this.addItem(new Candle());
    }
 
    public boolean isDone()
    {
        return ((WoodenDoor)getItemByName("WoodenDoor")).isOpen(); 
    }    
}

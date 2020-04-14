package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.ComboButton;
import items.ComboButton2;
import items.ComboButton1;
import java.awt.Point;
//author@21malikr
public class RohitRoom extends Room
{
    public RohitRoom()
    {
        super();
        this.addItem(new BasicDoor());
        this.addItem(new ComboButton());
        this.addItem(new ComboButton2());
        this.addItem(new ComboButton1());
    }
    
    public void onClick(Point p, Player player)
    {        
        
        for(int index=0; index<getItems().size(); index++)
        {
            Item j = getItems().get(index);
        
            if(j.getHitBox().contains(p))
            {
                if(j instanceof BasicDoor)
                {
                    if(((ComboButton2)getItemByName("ComboButton2")).isOn())
                        j.reactToClick(p, player);
                }
                else if (j instanceof ComboButton2)
                {
                    if(((ComboButton1)getItemByName("ComboButton1")).isOn())
                        j.reactToClick(p, player);
                    
                }
                else if (j instanceof ComboButton1)
                {
                    if(((ComboButton)getItemByName("ComboButton")).isOn())
                        j.reactToClick(p, player);
                    
                }
                else 
                {
                    j.reactToClick(p, player);
                    
                
                }
            }
        }
        
        
    }
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen() && 
                ((ComboButton2)getItemByName("ComboButton2")).isOn();    
    }
}

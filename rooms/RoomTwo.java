/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.ColoredButton;
import items.SimpleButton;
import java.awt.Point;

/**
 *
 * @author 22leec
 */
public class RoomTwo extends Room
{
    public RoomTwo()
    {
        super();
        this.addItem(new ColoredButton());
        this.addItem(new BasicDoor());
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
                    if(((ColoredButton)getItemByName("ColoredButton")).isOn())
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
                ((ColoredButton)getItemByName("ColoredButton")).isOn();    
    }
}

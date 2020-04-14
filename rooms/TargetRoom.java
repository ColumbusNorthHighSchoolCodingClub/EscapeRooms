/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.InvisibleDoor;
import items.Target;
import java.awt.Point;
/**
 *
 * @author 20songe
 */
public class TargetRoom extends Room
{
    private int clicks;
    
    public TargetRoom()
    {
    super();
    this.addItem(new Target(new Point(100,50)));
    this.addItem(new InvisibleDoor());
    clicks=0;
    }
  
    public void onClick(Point p, Player player)
    {
        for(int index=0; index<getItems().size(); index++)
        {
            Item i = getItems().get(index);
            
        
            if(i.getHitBox().contains(p))
            {
           
                if(i instanceof Target)
                {
                    if(clicks<10)
                    {
                    i.reactToClick(p, player);
                    clicks++;
                    }
                    else
                    {
                        getItems().remove(i);
                    }
                }
                else if(i instanceof InvisibleDoor && clicks==10)
                {
                    
                    i.reactToClick(p,player);
                    
                }
                 
            }
        }
    }
   
    public boolean isDone()
    {
        return ((InvisibleDoor)getItemByName("InvisibleDoor")).isOpen() ;    
    }
}


package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.Key;
import items.LetterB;
import items.LetterU;
import items.LetterL;
import items.LetterL2;
import items.LetterD;
import items.LetterO;
import items.LetterG;
import items.LockedPadDoor;


import items.SimpleButton;
import java.awt.Point;



/**
 *
 * @author 21reisingerm
 */
public class RoomLetters extends Room {
    
    public RoomLetters()
            
            
    {
        super();
        
        this.addItem(new LockedPadDoor());
        this.addItem(new LetterB(new Point(100,100)));
        this.addItem(new LetterU(new Point(100,200)));
        this.addItem(new LetterL(new Point(100,150)));
        this.addItem(new LetterL2(new Point(100,300)));
        this.addItem(new LetterD(new Point(100,400)));
        this.addItem(new LetterO(new Point(100,250)));
        this.addItem(new LetterG(new Point(100,350)));
      
        
    }
    /*
    public void onClick(Point p, Player player)
    {
            for(int index = 0; index< getItems().size(); index++)
            {
                Item i = getItems().get(index);
                
                if(i.getHitBox().contains(p))
                {
                    if(i instanceof LockedPadDoor)
                    {
                       
                    }
                }
            }
    }
    */
    
   public boolean isDone()
    {
        return ((LockedPadDoor)getItemByName("LockedPadDoor")).isOpen() ;    
    }
}

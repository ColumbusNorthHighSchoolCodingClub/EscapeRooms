/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.AlphabetE;
import items.AlphabetN;
import items.AlphabetO;
import items.AlphabetP;
import items.BasicDoor;
import java.awt.Point;

/**
 *
 * @author 22leec
 */
public class AlphabetRoom extends Room
{    
    public AlphabetRoom()
    {
        super();
        this.addItem(new AlphabetO(new Point(50,100)));
        this.addItem(new AlphabetP(new Point(75,100)));
        this.addItem(new AlphabetE(new Point(100,100)));
        this.addItem(new AlphabetN(new Point(125,100)));
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
                    if(((AlphabetO)getItemByName("AlphabetO")).isO() && 
                            ((AlphabetP)getItemByName("AlphabetP")).isP() && 
                            ((AlphabetE)getItemByName("AlphabetE")).isE() &&
                            ((AlphabetN)getItemByName("AlphabetN")).isN())
                         i.reactToClick(p,player);
                }                  
                else
                    i.reactToClick(p,player);
            }
        }
    }
    
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen();    
    }
}

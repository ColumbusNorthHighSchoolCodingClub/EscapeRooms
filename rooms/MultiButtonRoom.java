package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import items.BasicDoor;
import items.NamedButton;
import java.awt.Point;

/**
 *
 * @author spockm
 */
public class MultiButtonRoom extends Room
{
    String sequence = ""; //The sequence of buttons that have been pressed.  
    
    public MultiButtonRoom()
    {
        super();
        this.addItem(new NamedButton("O","O",new Point(100,100)));
        this.addItem(new NamedButton("P","P",new Point(130,100)));
        this.addItem(new NamedButton("E","E",new Point(160,100)));
        this.addItem(new NamedButton("N","N",new Point(190,100)));
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
                    if(sequence.equals("OPEN"))
                         i.reactToClick(p,player);
                }                  
                else if(i instanceof NamedButton)//all other objects, in this case only the buttons
                {
                    if(((NamedButton)i).getName().equals("O"))
                        sequence = "O"; //Restart the sequence when O is typed.
                    else
                        sequence += ((NamedButton)i).getName();
                    
                    i.reactToClick(p,player);
                }                
            }
        }
    }


    
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen();   
    }
}
    


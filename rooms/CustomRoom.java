package rooms;

import animation.ArcadeDemo;
import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import gameObjects.WallRoom;
import items.BasicDoor;
import items.Clue;
import items.Key;
import items.LockedDoor;
import items.NamedButton;
import items.Safe;
import items.ScrollButton;
import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the room you appear in at the start.  
 * All you have to do is click the door.  
 * @author spockm
 */
public class CustomRoom extends Room
{
    private String code;
    public CustomRoom()
    {
        super();
        this.addItem(new BasicDoor());
        this.addItem(new Safe(this,new Point(70,368),new Clue(new Point(90,388),"2861")));
        this.addItem(new ScrollButton("b0",new Point(50,100)));
        this.addItem(new ScrollButton("b1",new Point(75,100)));
        this.addItem(new ScrollButton("b2",new Point(100,100)));
        this.addItem(new ScrollButton("b3",new Point(125,100)));
        code="AAAA";
        
    }
    
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen() ;    
    }
    public void onClick(Point p, Player player)
    {        
        for(int index=0; index<getItems().size(); index++)
        {
            Item i = getItems().get(index);
        
            if(i.getHitBox().contains(p))
            {
                
                if(i instanceof Safe)
                {
                    
                    if(code.equals("SAFE")) {
                         ((Safe) i).unlock();
                    }
                    i.reactToClick(p,player);
                }
                else if(i instanceof ScrollButton)//all other objects, in this case only the buttons
                {
                    i.reactToClick(p,player);
                    char ch = ((ScrollButton) i).getText().charAt(0);
                    int num = Integer.parseInt(((ScrollButton) i).getName().charAt(1)+"");
                    //System.out.println(ch + " " + num);
                    char[] chars = code.toCharArray();
                    chars[num]=ch;
                    code=String.valueOf(chars);
                    if(code.equals("SAFE")) {
                        ArcadeDemo.textBox.openBox("Unlocked Safe.",true);
                    }
                    if(code.equals("CIGB")) {
                        ArcadeDemo.textBox.openBox("Unlocked Door.",true);
                    }
                }else if(i instanceof BasicDoor) {
                    if(code.equals("CIGB")) {
                        i.reactToClick(p,player);
                    } else 
                        ArcadeDemo.textBox.openBox("The door is locked.",true);
                }else {
                    i.reactToClick(p,player);
                }
            }
        }
    }
}

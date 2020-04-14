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
import items.SequencedButton;
import java.awt.Point;

/**
 *
 * @author 21agrawala
 */
public class ButtonsInOrder extends Room
{
    private boolean Oon;
    private boolean Pon; 
    private boolean Eon;
    private boolean Non;
    private String seq = "";


    
    public ButtonsInOrder()
    {
        super();
        this.addItem(new SequencedButton("O","O",new Point(100,200)));
        this.addItem(new SequencedButton("P","P",new Point(350,120)));
        this.addItem(new SequencedButton("E","E",new Point(120,350)));
        this.addItem(new SequencedButton("N","N",new Point(250,400)));
        this.addItem(new BasicDoor());
    }
    public void onClick(Point p, Player player)
    {
     if (((SequencedButton)getItemByName("O")).isOn() && !Oon)
        {
            seq += "O";
            Oon = true;
        }
        if (((SequencedButton)getItemByName("P")).isOn() && !Pon)
        {
            seq += "P";
            Pon = true;
        }
        if (((SequencedButton)getItemByName("E")).isOn() && !Eon)
        {
            seq += "E";
            Eon = true;
        }
        if (((SequencedButton)getItemByName("N")).isOn() && !Non)
        {
            seq += "N";
            Non = true;
        }
        Oon = ((SequencedButton)getItemByName("O")).isOn();
        Pon = ((SequencedButton)getItemByName("P")).isOn();
        Eon = ((SequencedButton)getItemByName("E")).isOn();
        Non = ((SequencedButton)getItemByName("N")).isOn();
     for(int index=0; index<getItems().size(); index++)
        {
            Item i = getItems().get(index);
            if(i.getHitBox().contains(p))
            {
                if(i instanceof BasicDoor)
                {
                    if(seq.equals("OPEN"))
                    {
                        i.reactToClick(p,player);
                    }
                    else
                    {
                        seq = "";
                    }
                }
                if(i instanceof SequencedButton)
                {
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

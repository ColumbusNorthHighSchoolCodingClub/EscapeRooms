/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room; 
import items.Background;
import items.BackgroundImage;
import items.BasicDoor;
import items.HiddenButton;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.awt.Graphics;

import java.awt.Point;
import java.awt.image.ImageObserver;

/**
 *
 * @author Eamon
 */
public class RoomWithRandomHiddenButton extends Room
{
    private int x = (int)(Math.random() * 600 + 1);
    private int y = (int)(Math.random() * 420 + 1);
    public RoomWithRandomHiddenButton()
    {
        super();
        if(x>=300 && x<=500)
           if(y>=300 && y<=480)
        {
            y=y-200;
        }
        System.out.println("The button is hidden at: "+x+","+y);
        this.addItem(new Background());
        this.addItem(new HiddenButton(x,y,WHITE));
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
                    if(((HiddenButton)getItemByName("HiddenButton")).isOn())
                         i.reactToClick(p,player);
                }
                else if(i instanceof BackgroundImage)
                {
                    if(((HiddenButton)getItemByName("HiddenButton")).isOn())
                         i.reactToClick(p,player);
                }
                else //all other objects, in this case only the button
                    i.reactToClick(p,player);
                
            }
        }
    }
    public void draw(Graphics g, ImageObserver io)
    {
        super.draw(g,io);
        g.setColor(BLACK);
        String text = "Find the hidden button";
        g.drawString(text, 200, 100);
        
    }
    
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen() && 
                ((HiddenButton)getItemByName("HiddenButton")).isOn();    
    }
}

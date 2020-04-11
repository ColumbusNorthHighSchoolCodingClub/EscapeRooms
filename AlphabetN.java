/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author 22leec
 */
public class AlphabetN extends Item
{
    boolean isN = false;
    String letter = "A";
    String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public AlphabetN(Point loc)
    {
        super("AlphabetN", new Rectangle(loc.x, loc.y, 20,20));
    }
        
    public boolean isN() { return isN; }
    
    int i = 0;
    public void reactToClick(Point p, Player player)
    {
        i++;
        if(i == abc.length())
            i = 0;
        letter = abc.charAt(i)+"";
        
        if(i==13)
            isN = !isN;
        else
            isN = false;
        
        System.out.println(letter);
    }
            
    public void draw(Graphics g, ImageObserver io)
    {
        g.setColor(Color.GREEN);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.setColor(Color.BLACK); //draw the text onto the button
        g.drawString(letter, getRect().x, getRect().y);
    }
}

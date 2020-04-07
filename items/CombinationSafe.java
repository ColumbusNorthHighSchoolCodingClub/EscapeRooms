/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

/**
 *
 * @author dlpre
 */


import java.util.Scanner;
import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author dlpre
 */
public class CombinationSafe extends Item
{
    boolean isOpen = false;
    
    public CombinationSafe()
    {
        super("CombinationSafe", new Rectangle(100,350,50,50));
    }
    
    public boolean isOpen() { return isOpen; }
    
    public void reactToClick(Point p, Player player)
    {
       if (!isOpen)
       { System.out.println("Enter a combination! Please use lowercase letters and separate the numbers with spaces.");
        Scanner sc = new Scanner(System.in); 
        String passwordAttempt = sc.nextLine();
        if (passwordAttempt.equals("seven one one"))
            
        {System.out.println ("Success! You got a key!");
            isOpen = true;
        player.addItem(new Key(new Point(100,100)));}
        
        else
        {System.out.println ("Incorrect");}
    }
       
     else
       {System.out.println ("Safe is open");}
    }
    

    
    public void draw(Graphics g, ImageObserver io)
    {
        if(!isOpen)
            g.setColor(Color.GRAY);
            super.draw(g,io);
    }
}

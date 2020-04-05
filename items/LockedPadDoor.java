package items;
import java.util.Scanner;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;


public class LockedPadDoor extends Item
{
    boolean isOpen = false;
    
    public LockedPadDoor()
    {
        super("LockedPadDoor", new Rectangle(300,300,200,300));
    }
    
    public boolean isOpen() { return isOpen; }
    
    public void reactToClick(Point p, Player player)
    {
       if(player.hasItem("B" )/* && player.hasItem("U") && player.hasItem("L") && player.hasItem("L2") && player.hasItem("D") && player.hasItem("O") && player.hasItem("G")*/) {
        {
           
            System.out.println("Unscramble the letters to make a word");
       
            
             Scanner sc = new Scanner(System.in); 
             String password = sc.nextLine(); 
             
             while(isOpen == false) {
             if("bulldog".equals(password) ||"Bulldog".equals(password) || "BULLDOG".equals(password) ){
                 isOpen = true;
             }
             else{
                 
                 System.out.println("Type in the password");
                 password = sc.nextLine(); 
             }
             }
        }
        
        
        
       }  
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(!isOpen)
            super.draw(g,io);
    }
}

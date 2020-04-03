package items;

import gameObjects.Item;
import gameObjects.Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Clues extends Item
{
    boolean isOpen = false;
    String txt ="";
   boolean once=true;

    
    public Clues()
    {
        super("Clues", new Rectangle(100,100,50,50));
    }
    
    public boolean isOpen() { return isOpen; }

public String text(){
	if(once){
	  ArrayList <String> strs=new ArrayList();

	   strs.add("R");
	   strs.add("O");
	   strs.add("Y");
	   strs.add("G");
	   strs.add("B");
	   strs.add("I");
	   for(int i=0;i<strs.size();i++){
		   int rand=(int) (Math.random()*strs.size());
		   txt+=strs.get(rand);
		   txt+=", ";
		   strs.remove(rand);
		   i--;
		
	   }
	  
	   once=false;
	   return txt;}
	else{
		return txt;
	}
   }
    
    public void reactToClick(Point p, Player player)
    {
        isOpen = !isOpen;
        System.out.println("Basic Door Clicked!");
    }
    
    public void draw(Graphics g)
    {
    	g.setColor(Color.BLACK);
    	g.drawString(text(), 100, 200);
    	
     }
}



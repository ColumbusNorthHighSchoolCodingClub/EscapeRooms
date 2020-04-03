package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameObjects.Item;
import gameObjects.Player;

public class Red extends Item {
	private boolean isOn=false;
	
	
	public Red(String n, String text, Point loc ) {
		super(n, new Rectangle(loc.x, loc.y, 20,20));
	}
    public boolean isOn() {
    	System.out.println(isOn+"Ye");
    	return isOn; }
    public void reactToClick(Point p, Player player)
    {
        isOn = !isOn;
        System.out.println("NamedButton Clicked!");
    }
    
    public void draw(Graphics g)
    {
    	
        if(isOn)
            g.setColor(Color.BLACK);
        else
            g.setColor(Color.RED);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
    }
    	}
	
	



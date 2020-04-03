package gameObjects;

import animation.ArcadeRunner;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 * The Player represents the person playing the game and trying to escape.  
 * @author spockm
 */
public class Player 
{
    private final int SPACE_SIZE = 40;
    private final int MAX_ITEMS = 5;
    private String name;
    private ArrayList<Item> items;
    private int score;
    private int activeItem;
    
    public Player(String who)
    {
        name = who; 
        items = new ArrayList<>();
        score = 0;
        activeItem=0;
    }
    
    public String getName() { return name; }
    public void addItem(Item i) { items.add(i); }
    public int getNumItems() {return items.size();}
    public int getScore() { return score; }
    public boolean hasItemActive(String itemName) {
        if(activeItem>=items.size())
            return false;
        return items.get(activeItem).getName().equals(itemName);
    }
    public boolean hasItem(String itemName)
    {
        for(Item i : items)
            if(i.getName().equals(itemName))
                return true;
        return false;
    }
    
    public void drawInventory(Graphics g,ImageObserver io) {
        int startX=400;
        int y = 20;
        Graphics2D g2d = (Graphics2D)g;
        
        g.setFont(ArcadeRunner.customFont.deriveFont(18f));
        g.setColor(Color.BLACK);
        g.drawString("Inventory", 470, 15);
        int space=0;
        for(int x=startX;x<startX+MAX_ITEMS*SPACE_SIZE;x+=SPACE_SIZE) {
            g2d.setStroke(new BasicStroke(3));
            g.setColor(new Color(224, 222, 200,120));
            g.fillRect(x,y,SPACE_SIZE,SPACE_SIZE);
            g.setColor(new Color(81, 47, 52));
            g.drawRect(x,y,SPACE_SIZE,SPACE_SIZE);
            if(space<items.size())
                g.drawImage(items.get(space).getImage(),x+5,y+5,io);
            space++;
        }
        g2d.setStroke(new BasicStroke(2));
        g.setColor(Color.white);
        g.drawRect(startX+SPACE_SIZE*activeItem+2,y+2,SPACE_SIZE-3,SPACE_SIZE-3);
    }
    public void onClick(int mX,int mY) {
        Rectangle rect;
        int startX=400;
        int y = 20;
        int space=0;
        for(int x=startX;x<startX+MAX_ITEMS*SPACE_SIZE;x+=SPACE_SIZE) {
            rect=new Rectangle(x,y,SPACE_SIZE,SPACE_SIZE);
            if(rect.contains(new Point(mX,mY))) {
                activeItem=space;
                break;
            }
            space++;
        }
    }
    
}

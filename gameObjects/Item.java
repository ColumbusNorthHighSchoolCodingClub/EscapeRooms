package gameObjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 * An Item is a clickable object that can be drawn and perhaps contain things. 
 * It can change when clicked and could be part of the puzzle of the room.  
 * 
 * It is expected that MANY classes will extend this class.  
 * 
 * @author spockm
 */
public class Item 
{
    private String name; 
    private Rectangle rect;
    private boolean pickUpOnClick;
    public int mouseX;
    public int mouseY;
    private Image image;
    
    public Item(String what, Rectangle r,Image img)
    {
        name = what;
        rect = new Rectangle(r);
        pickUpOnClick = false;
        image = img;
    }
    public Item(String what, Rectangle r)
    {
        name = what;
        rect = new Rectangle(r);
        pickUpOnClick = false;
        image = null;
    }
    
    public String getName() { return name; }    
    public boolean pickUpOnClick() { return pickUpOnClick; }
    public void enablePickUpOnClick() { pickUpOnClick = true; }
    public Rectangle getRect() { return rect; }
    
    public void reactToClick(Point p, Player player)
    {
        System.out.println("A click occured, but the Item has not overriden the reactToClick method");
    }
    
    public void reactToClickGeneric(Point p, Player player)
    {
        System.out.println("A click occured, but the Item has not overriden the reactToClick method");
    }
    
    public void reactToDrag(Point p, Player player)
    {
        System.out.println("A drag occured, but the Item has not overriden the reactToDrag method");
    }
    public void reactToMouseRelease(Point p, Player player)
    {
        System.out.println("A mouse release occured, but the Item has not overriden the reactToRelease method");
    }
    public void updateMouseCoords(int x, int y) {
        mouseX = x;
        mouseY = y;
    }
    
    public Rectangle getHitBox()
    {
        return rect;
    }
    public void setRect(Rectangle newRect) {
        rect = newRect;
    }

    public Image getImage() {
        return image;
    }
    public void draw(Graphics g, ImageObserver io)
    {
        if(image!=null)
            g.drawImage(image,rect.x, rect.y,io);
        else
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
    
    //Make these static so that the Image only gets loaded once (not for each instance)
    public static Image keyImage;
    public static Image starImage;
    public static Image donutImage;
    public static Image smileImage;
    public static Image doorClosedImage;
    public static Image doorOpenImage;
    public static Image backgroundImage;
    public static Image arrowImage;
    public static Image clueImage;
    public static Image safeClosedImage;
    public static Image safeOpenImage;
    public static void loadImages(Toolkit toolkit)
    {
//        keyImage = toolkit.getImage("src/items/images/key.gif");
        keyImage = toolkit.getImage("src/items/images/key.png");
        starImage = toolkit.getImage("src/items/images/star.gif");
        donutImage = toolkit.getImage("src/items/images/donuts.gif");
        smileImage = toolkit.getImage("src/items/images/smile.gif");
        backgroundImage = toolkit.getImage("src/items/images/background.png");
        doorClosedImage = toolkit.getImage("src/items/images/door_closed.png");
        safeClosedImage = toolkit.getImage("src/items/images/safe_closed.png");
        safeOpenImage = toolkit.getImage("src/items/images/safe_open.png");
        doorOpenImage = toolkit.getImage("src/items/images/door_open.png");
        arrowImage = toolkit.getImage("src/items/images/arrow.png");
        clueImage = toolkit.getImage("src/items/images/paper.png");
    }
    public void reactToKey(char c, Player player) {
       System.out.println("A key was pressed, but the Item has not overriden the reactToKey method");
    } 
}

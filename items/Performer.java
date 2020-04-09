package items;

import gameObjects.Item;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 * Performer
 * Walks back and forth across the stage in RoomSpotlight.
 * 
 * by Tate McKenney
 */
public class Performer extends Item {
    
    private int x = 70;
    private int y = 200;
    private int frameNumber = 0;
    
    
    public Performer() {
        super("Performer", new Rectangle(120, 200, 100, 172));
    }
    
    
    public void draw(Graphics g, ImageObserver io) {
        if (frameNumber % 200 < 100)
            g.drawImage(actorImage, x, y, io);
        else
            g.drawImage(actorFlippedImage, x, y, io);
        
        x = (int) (270 - 120 * Math.cos(frameNumber * Math.PI / 100)); // move Performer back and forth horizontally
        setRect(new Rectangle(x, y, 100, 172));
        frameNumber++;
    }
}

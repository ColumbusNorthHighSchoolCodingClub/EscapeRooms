package items;

import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import gameObjects.WallRoom;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class RightArrow extends Item
{
    WallRoom room;
    public RightArrow(WallRoom rm)
    {
        super("LeftArrow", new Rectangle(585, 195, 25, 50),null);
        room=rm;
        
    }
        
    public void draw(Graphics g, ImageObserver io)
    {
//        g.setColor(Color.YELLOW);
//        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.drawImage(arrowImage, getRect().x+25, getRect().y, -25,50, io);
    }
    public void reactToClick(Point p, Player player)
    {
        room.activeWall--;
        if(room.activeWall<0)
            room.activeWall=room.numWalls-1;
    }
    
}

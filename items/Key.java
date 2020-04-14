package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class Key extends Item {

    Player player;
    boolean pickedUp = false;
    public Key(Point loc) {
        super("Key", new Rectangle(loc.x, loc.y, 30, 30));
        enablePickUpOnClick();
    }

    public void draw(Graphics g, ImageObserver io) {
//        g.setColor(Color.YELLOW);
//        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
            g.drawImage(keyImage, getRect().x, getRect().y, io);
    }

}

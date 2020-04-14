package rooms;

import gameObjects.Room;
import items.BackgroundImage;
import static gameObjects.Item.stageImage;
import items.Performer;
import items.Spotlight;

/**
 * RoomSpotlight
 * by Tate McKenney
 * 
 * Use the spotlight to follow the performer for eight seconds to progress to the next room.
 */
public class RoomSpotlight extends Room {
    
    private int focusTime = 0; // number of frames that the spotlight has focused on the performer
    
    
    public RoomSpotlight() {
        super();
        this.addItem(new BackgroundImage(stageImage));
        this.addItem(new Spotlight());
        this.addItem(new Performer());
    }
    
    
    public void updateMouseCoords(int x, int y) {
        ((Spotlight) getItemByName("Spotlight")).setPosition(x, y);
    }
    
    
    // Room ends when the spotlight has focused on the performer for 7 seconds
    public boolean isDone() {
        if (getItemByName("Spotlight").getRect().contains(getItemByName("Performer").getRect()))
            focusTime++;
        else
            focusTime = 0;
        
        return (focusTime > 240);
    }
    
    
    public String getHint() {
        return "Follow the performer";
    }
}

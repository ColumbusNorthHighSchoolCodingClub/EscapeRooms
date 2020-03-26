package gameObjects;

import java.util.ArrayList;

/**
 * The Player represents the person playing the game and trying to escape.  
 * @author spockm
 */
public class Player 
{
    private String name;
    private ArrayList<Item> items;
    private int score;
    
    public Player(String who)
    {
        name = who; 
        items = new ArrayList<>();
        score = 0;
    }
    
    public String getName() { return name; }
    public void addItem(Item i) { items.add(i); }
    public int getScore() { return score; }
    
    
}

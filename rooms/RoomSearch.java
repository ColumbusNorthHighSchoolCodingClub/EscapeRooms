/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Item;
import static gameObjects.Item.donutImage;
import static gameObjects.Item.smileImage;
import static gameObjects.Item.starImage;
import gameObjects.Player;
import gameObjects.Room;
import items.BackgroundImage;
import items.BasicDoor;
import items.SearchItem;
import items.Key;
import items.LockedDoor;
import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author 20songe
 */
public class RoomSearch extends Room
{
    private ArrayList<SearchItem> stars = new ArrayList();
    private int found;
    private SearchItem a;
    private SearchItem b;
    private SearchItem c;
    private SearchItem d;
    private SearchItem e;
    private SearchItem f;
    private SearchItem g;
    private SearchItem h;
    
    public RoomSearch()
    {
        super();
        a = new SearchItem(starImage, new Point(100,100));
        b = new SearchItem(starImage, new Point(200,50));
        c = new SearchItem(starImage, new Point(600,76));
        d = new SearchItem(starImage, new Point(400,120));
        e = new SearchItem(smileImage, new Point(300,10));
        f = new SearchItem(smileImage, new Point(244,380));
        g = new SearchItem(smileImage, new Point(340,12));
        h = new SearchItem(smileImage, new Point(20,190));
        stars.add(a);
        stars.add(b);
        stars.add(c);
        stars.add(d);
        stars.add(e);
        stars.add(f);
        stars.add(g);
        stars.add(h);
        
        found=0;
        
        this.addItem(new BackgroundImage(donutImage));
        for(int i=0; i<stars.size(); i++)
        {
            this.addItem(stars.get(i));
        }
        //this.addItem(new Key(new Point(100,100)));
        this.addItem(new BasicDoor());
    }
    public void onClick(Point p, Player player)
    {        
        for(int index=0; index<getItems().size(); index++)
        {
            Item i = getItems().get(index);
            
        
            if(i.getHitBox().contains(p))
            {
                if(i instanceof SearchItem)
                {
                    found++;
                    getItems().remove(index);
                }
                else if(i instanceof BasicDoor)
                {
                    if(stars.size()==found)
                         i.reactToClick(p,player);
                   
                }                  
                               
            }
        }
    }
    
    
    
    public boolean isDone()
    {
        return ((BasicDoor)getItemByName("BasicDoor")).isOpen();  
    }
}

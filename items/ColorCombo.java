/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 *
 * @author jdawg
 */
public class ColorCombo extends Item {

    boolean isOn = false;
    private int x = 100;
    private int y = 100;
    private int size = 80;
    private ArrayList<Integer> code = new ArrayList();
    private ArrayList<Integer> userCode = new ArrayList();

    public ColorCombo(Point loc) {
        super("SimonSays", new Rectangle(loc.x, loc.y, 80, 100));
        x = loc.x;
        y = loc.y;
        code.add(1);
        code.add(3);
        code.add(4);
        code.add(2);
    }

    //set the pattern to this, red = 1, green = 2, blue = 3, yellow = 4;
    public void setCode(ArrayList<Integer> newCode) {
        code = newCode;
    }
    public ArrayList<Integer> getCode(){
        return code;
    }

    public void reactToClick(Point p, Player player) {
        //left side
        if (p.x > x && p.x < x + (size / 2)) {
            //top left Red
            if (p.y > y && p.y < y + (size / 2)) {
                userCode.add(1);
            }
            //bot left Yellow
            if (p.y > y + (size / 2) && p.y < y + size) {
                userCode.add(4);

            }
        }
        //right side
        if (p.x < x + size && p.x > x + (size / 2)) {
            //top right Green
            if (p.y > y && p.y < y + (size / 2)) {
                userCode.add(2);

            }
            //bot right Blue
            if (p.y > y + (size / 2) && p.y < y + size) {
                userCode.add(3);

            }
        }

        if (p.x > x && p.x < x + size + 2 && p.y > y + size && p.y < y + size + (size / 4)) {
            userCode.clear();
        }
    }

    //draw methods
    public void draw(Graphics g, ImageObserver io) {
        int sqSize = (size / 2) - 2;

        //outline
        g.setColor(Color.BLACK);
        g.fillRect(x, y, size + 2, size + 2);

        //colored rects
        g.setColor(Color.RED);
        g.fillRect(x + 2, y + 2, sqSize, sqSize);
        g.setColor(Color.GREEN);
        g.fillRect(x + 2 + (size / 2), y + 2, sqSize, sqSize);
        g.setColor(Color.BLUE);
        g.fillRect(x + 2 + (size / 2), y + 2 + (size / 2), sqSize, sqSize);
        g.setColor(Color.YELLOW);
        g.fillRect(x + 2, y + 2 + (size / 2), sqSize, sqSize);

        //reset button
        g.setColor(Color.BLACK);
        g.drawRect(x, y + 80, size + 1, size / 4);
        g.drawString("RESET", x + (size / 4), y + (size + 15));

    }

    //get status
    public boolean isOpen() {
        for (int i = 0; i < code.size(); i++) {
            if(userCode.size() < code.size()){
                return false;
            }
            if (!(code.get(i) == userCode.get(i))) {
                return false;
            }
        }
        return true;
    }
}

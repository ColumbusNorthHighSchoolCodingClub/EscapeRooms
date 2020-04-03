/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Room;
import items.BasicDoor;
import items.ColorCombo;
import items.SimpleButtonBordered;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jdawg
 */
public class ColorRoom extends Room {

    private ArrayList<Color> colors = new ArrayList();
    private ColorCombo cc1 = new ColorCombo(new Point(280, 180));
    private SimpleButtonBordered door = new SimpleButtonBordered();
    private Boolean reset = true;
    private Long prev = Long.MAX_VALUE;
    private int i = 0;

    public ColorRoom() {
        super();
        this.addItem(cc1);
        this.addItem(door);
        ArrayList<Integer> code = cc1.getCode();
        for (int i : code) {
            if (i == 1) {
                colors.add(Color.RED);
            }
            if (i == 2) {
                colors.add(Color.GREEN);
            }
            if (i == 3) {
                colors.add(Color.BLUE);
            }
            if (i == 4) {
                colors.add(Color.YELLOW);
            }
        }
    }

    public boolean isDone() {
        return ((SimpleButtonBordered) getItemByName("SimpleButton")).isOn() && ((ColorCombo) getItemByName("SimonSays")).isOpen();
    }

    public void draw(Graphics g) {
        if (!(((SimpleButtonBordered) getItemByName("SimpleButton")).isOn() && ((ColorCombo) getItemByName("SimonSays")).isOpen())) {
            if (reset) {
                prev = System.currentTimeMillis();
                reset = false;
            }
            if (System.currentTimeMillis() - prev > 1000) {
                prev = System.currentTimeMillis();
                if (i == 3) {
                    i = 0;
                } else {
                    i++;
                }
            }

            g.setColor(colors.get(i));
            g.fillRect(0, 0, 1000, 1000);
        }
        cc1.draw(g);
        door.draw(g);
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(i + 1), 320, 100);
    }
}

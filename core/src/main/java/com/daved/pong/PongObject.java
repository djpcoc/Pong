package com.daved.pong;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.engine.geom.CollisionPoint;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

/**
 * Created by david on 17/09/2016.
 */
public class PongObject {

    private CollisionBox box;
    private int height;
    private int width;

    public PongObject(int height, int width) {
        box = new CollisionBox();
        this.height = height;
        this.width = width;
    }

    public CollisionBox getBox() {
        return box;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

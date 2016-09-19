package com.daved.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.collisions.RegionQuadTree;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.geom.Rectangle;
import org.mini2Dx.core.graphics.Graphics;

import java.util.ArrayList;
import java.util.List;

public class MyMini2DxGame extends BasicGame {
	public static final String GAME_IDENTIFIER = "com.daved.pong";

	private Texture texture;
    private PongObject leftPlayer;
    private PongObject rightPlayer;
    private PongObject ball;

	@Override
    public void initialise() {
    	leftPlayer = new PongObject(64, 25);
    	rightPlayer = new PongObject(64, 25);
    	ball = new PongObject(10, 10);

        leftPlayer.getBox().set(16, 200);
        rightPlayer.getBox().set(600, 200);
        ball.getBox().set(300, 240);

        RegionQuadTree<CollisionBox> collisions1 = new RegionQuadTree<>(1, 16, 200, 64, 25);
        RegionQuadTree<CollisionBox> collisions2 = new RegionQuadTree<>(1, 600, 200, 64, 25);
        RegionQuadTree<CollisionBox> collisions3 = new RegionQuadTree<>(1, 300, 240, 10, 10);
//Add a collision
        collisions1.add(new CollisionBox(4f, 4f, 2f, 2f));
//Get all collisions in an area
        List<CollisionBox> collisionsInArea = new ArrayList<CollisionBox>();
        collisions1.getElementsWithinArea(collisionsInArea, new Rectangle(0f, 0f, 2f, 2f));
//collisionsInArea now has a list of collisions intersecting or within the rectangle's area

    }

    @Override
    public void update(float delta) {
        //preUpdate() must be called before any changes are made to the CollisionBox
        leftPlayer.getBox().preUpdate();
        rightPlayer.getBox().preUpdate();
        ball.getBox().preUpdate();

        //Move the point by 4 pixels on the X and Y axis
        leftPlayer.getBox().set(leftPlayer.getBox().getX() + 0f, leftPlayer.getBox().getY() + 0f);
        rightPlayer.getBox().set(rightPlayer.getBox().getX() + 0f, rightPlayer.getBox().getY() + 0f);
        ball.getBox().set(ball.getBox().getX() + 1f, ball.getBox().getY() + 0f);
    }

    @Override
    public void interpolate(float alpha) {
        //This method uses the lerp (linear interpolate) method from LibGDX
        //to interpolate between the previous and current positions
        //and set the render coordinates correctly
        leftPlayer.getBox().interpolate(null, 0.1f);
        rightPlayer.getBox().interpolate(null, 0.1f);
        ball.getBox().interpolate(null, 0.1f);
    }

    @Override
    public void render(Graphics g) {
        //Use the point's render coordinates to draw the sprite
        g.fillRect(leftPlayer.getBox().getRenderX(), leftPlayer.getBox().getRenderY(), leftPlayer.getWidth(), leftPlayer.getHeight());
        g.fillRect(rightPlayer.getBox().getRenderX(), rightPlayer.getBox().getRenderY(), rightPlayer.getWidth(), leftPlayer.getHeight());


        g.fillRect(ball.getBox().getRenderX(), ball.getBox().getRenderY(), ball.getWidth(), ball.getHeight());
    }

}

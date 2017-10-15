package com.drop.game.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by Vova on 16.09.2017.
 */
public class Meteorite extends FallingGameObject {

    public Meteorite(String atlasFile, String spriteName, float x, float y, float width, float height) {
        super(atlasFile, spriteName, x, y, width, height);
    }


    {
        velocity = 350;
    }

    public void cycleDraw(SpriteBatch batch, String spriteName, String spriteName2) {
        sprite.setBounds(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        sprite.draw(batch);
        setSpriteName(spriteName);
        for (; ; ) {
            long drawTime = System.nanoTime();
            if (TimeUtils.nanoTime() - drawTime > 500000000) {
                setSpriteName(spriteName2);
            }
        }

    }

    Meteorite(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public Meteorite spawn(float x, float y) {
        Meteorite meteorite = new Meteorite(x, y, 64, 64);
        meteorite.atlas = atlas;
        meteorite.sprite = sprite;
        meteorite.spriteName = spriteName;
        return meteorite;
    }
}

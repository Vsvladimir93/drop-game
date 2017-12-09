package com.drop.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Vova on 13.09.2017.
 */
public class Bucket extends GameObject {


    public Bucket(String atlasFile, String spriteName, float x, float y, float width, float height) {
        super(atlasFile, spriteName, x, y, width, height);
    }

}

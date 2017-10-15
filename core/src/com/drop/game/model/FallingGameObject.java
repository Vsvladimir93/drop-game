package com.drop.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

/**
 * Created by Vova on 21.09.2017.
 */
public class FallingGameObject extends GameObject {
    public FallingGameObject(String atlasFile, String spriteName, float x, float y, float width, float height) {
        super(atlasFile, spriteName, x, y, width, height);
    }

    public FallingGameObject(String atlasFile, String spriteName) {
        super(atlasFile, spriteName);
    }

    FallingGameObject(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public FallingGameObject() {
    }

    int velocity = 200;

    public void spawn (GameObject Object, long time, ArrayList arrayList){

        if (System.currentTimeMillis() - time >= 1500) {
            time = System.currentTimeMillis();
            arrayList.add(Object.spawn(MathUtils.random(35, 700), 600));
        }
    }

    public void fall() {
        rectangle.y -= (velocity * Gdx.graphics.getDeltaTime());
    }



}

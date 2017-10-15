package com.drop.game.model;




/**
 * Created by Vova on 13.09.2017.
 */
public class Drop extends FallingGameObject {
    public Drop(String atlasFile, String spriteName, float x, float y, float width, float height) {
        super(atlasFile, spriteName, x, y, width, height);

    }

    public Drop(String atlasFile, String spriteName) {
        super(atlasFile, spriteName);

    }

    public Drop(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public Drop() {

    }

    @Override
    public Drop spawn(float x, float y) {
        Drop newDrop = new Drop(x, y, 64, 64);
        newDrop.atlas = atlas;
        newDrop.sprite = sprite;
        newDrop.spriteName = spriteName;
        return newDrop;
    }
}




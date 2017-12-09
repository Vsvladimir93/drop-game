package com.drop.game.model;
import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Vova on 21.09.2017.
 */
public class FallingGameObject extends GameObject {
    public FallingGameObject(String atlasFile, String spriteName, float x, float y, float width, float height) {
        super(atlasFile, spriteName, x, y, width, height);
    }

    FallingGameObject(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public FallingGameObject() {
    }

    int velocity = 200;

    public void fall() {
        rectangle.y -= (velocity * Gdx.graphics.getDeltaTime());
    }

    public void remove(ArrayList<FallingGameObject> fallingObjects, Bucket bucket) {
        Iterator<FallingGameObject> iter = fallingObjects.iterator();
        while (iter.hasNext()) {
            FallingGameObject fallingGameObject = iter.next();
            if (bucket.rectangle.overlaps(fallingGameObject.rectangle)) {
                User.setDropsCollected(User.getDropsCollected() + 1);
                System.out.println(User.getDropsCollected());
                iter.remove();
            }
            if (fallingGameObject.rectangle.getY() < 0) {
                User.setDropsMissed(User.getDropsMissed() + 1);
                iter.remove();
            }
        }
    }

}




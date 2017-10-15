package com.drop.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.drop.game.model.Bucket;
import com.drop.game.model.FallingGameObject;
import com.drop.game.model.Meteorite;
import com.drop.game.view.GameScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by Vova on 16.09.2017.
 */
public class BucketController {

    long time;
    int speed = 0;
    Meteorite meteorite;

    Vector3 touchPos = new Vector3();


    public void controll(Rectangle rectangle, OrthographicCamera camera, Bucket bucket) {
        if (Gdx.input.isTouched()) {

            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            rectangle.x = (int) (rectangle.x + (touchPos.x - rectangle.x - 64) * 0.05);
            rectangle.y = (int) (rectangle.y + (touchPos.y - rectangle.y - 64) * 0.05);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.rectangle.x -= (speed + 200) * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.rectangle.x += (speed + 200) * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) bucket.rectangle.y -= (speed + 200) * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) bucket.rectangle.y += (speed + 200) * Gdx.graphics.getDeltaTime();

    }

    public void borderCheck (Bucket bucket) {

        if (bucket.rectangle.y < 0) {
            bucket.rectangle.y = 0;
        }
        if (bucket.rectangle.y > Gdx.graphics.getHeight() - 64) {
            bucket.rectangle.y = Gdx.graphics.getHeight() - 64;
        }
        if (bucket.rectangle.x < 0) {
            bucket.rectangle.x = 0;
        }
        if (bucket.rectangle.x > Gdx.graphics.getWidth() - 64) {
            bucket.rectangle.x = Gdx.graphics.getWidth() - 64;
        }
    }

    public void boost(Bucket bucket, ArrayList<FallingGameObject> list) {

        for (FallingGameObject fallingGameObject : list) {
            if (fallingGameObject.getSpriteName() == "meteorite1") {

                if (bucket.rectangle.overlaps(fallingGameObject.rectangle)) {
                    speed += 35;
                    time = System.currentTimeMillis();
                  /*  System.out.println(speed);
                    System.out.println(time + " + ");*/
                }
            }
        }
        if (System.currentTimeMillis() - time > 3000) {
            speed -= 35;
            if(speed < 0 ){speed = 0;}
            time = System.currentTimeMillis();
           /* System.out.println(speed);
            System.out.println(time + " - ");*/
        }

    }


}

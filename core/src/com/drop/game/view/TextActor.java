package com.drop.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Vova on 09.12.2017.
 */
public class TextActor extends Actor {

    BitmapFont bitmapFont;
    String string;
    Batch batch;
    float x,y;

    public TextActor (String score, Batch batch, float x, float y) {

       this.batch = batch;
       string = score;
       this.x = x;
       this.y = y;
       bitmapFont = new BitmapFont(Gdx.files.internal("default.fnt"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        bitmapFont.draw(batch, string, x, y);
    }
}

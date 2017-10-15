package com.drop.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Vova on 27.09.2017.
 */
public class GameBackground {

    int counter = -1;

    Pixmap pixmap = new Pixmap(Gdx.files.internal("background.png"));

    Texture background = new Texture(pixmap);

    GameBackground() {


    }

    String[] arr = {"background2.1.png", "background2.2.png",
            "background2.3.png", "background3.1.png", "background3.2.png", "background3.3.png"};

    public void drawBackground () {
        background.draw(pixmap, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }


    public String bgChanger() {
        counter++;

        switch(counter){
            case 0:
                return arr[counter];

            case 1:
              return arr[counter];

            case 2:
                return arr[counter];

            case 3:
                return arr[counter];

            case 4:
                return arr[counter];

            case 5:
                counter = -1;
                return arr[5];

            default:
                return arr[0];
        }



    }
}

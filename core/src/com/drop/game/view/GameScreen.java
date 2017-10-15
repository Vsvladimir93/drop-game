package com.drop.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.drop.game.Main;
import com.drop.game.controller.BucketController;
import com.drop.game.model.*;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Vova on 11.09.2017.
 */
public class GameScreen implements Screen {


    SpriteBatch batch;
    OrthographicCamera camera;
    GameMusic gameMusic;
    GameBackground bg;
    User user;
    Main main;
    MenuScreen menuScreen;
    public static ArrayList<FallingGameObject> fallingObjects;
    GameObject object;
    Sprite sprite;
    BitmapFont bitmapFont;
    static Integer score = 0;


    Bucket bucket = new Bucket("Bucket3.txt", "bucket1", 1, 1, 64, 64);
    private static final Meteorite METEORITE = new Meteorite("DropAndMeteorite.txt", "meteorite1", 0, 0, 64, 64);
    private static final Drop DROP = new Drop("DropAndMeteorite.txt", "drop", 0, 0, 64, 64);

    BucketController bucketController = new BucketController();
    long time = System.currentTimeMillis();
    long time2 = System.currentTimeMillis();

    public GameScreen() {
       main.getMain();

        sprite = new Sprite();
        batch = new SpriteBatch();
        bitmapFont = new BitmapFont(Gdx.files.internal("font1.fnt"));

        object = new GameObject();

        bg = new GameBackground();
        bg.drawBackground();

        gameMusic = new GameMusic();
        gameMusic.play();

        user = new User();
        menuScreen = new MenuScreen();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        fallingObjects = new ArrayList<FallingGameObject>();
    }


    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {

        update();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.begin();


        if (System.currentTimeMillis() - time > 1500) {
            System.out.println(System.currentTimeMillis() + "                     !!!!!!!!1");
            System.out.println(bg.bgChanger());
            bg.background = new Texture(bg.bgChanger());
        }
        batch.draw(bg.background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Создание прорисовка объектов из массива fallingObjects
        for (FallingGameObject fallingGameObject : fallingObjects) {
            fallingGameObject.fall();
            fallingGameObject.draw(batch);
        }

        if (System.currentTimeMillis() - time >= 1500) {
            time = System.currentTimeMillis();
            fallingObjects.add(DROP.spawn(MathUtils.random(35, Gdx.graphics.getWidth() - 100), Gdx.graphics.getHeight()));
        }

        if (System.currentTimeMillis() - time2 >= 1000) {
            time2 = System.currentTimeMillis();
            fallingObjects.add(METEORITE.spawn(MathUtils.random(35, Gdx.graphics.getWidth() - 100), Gdx.graphics.getHeight()));
        }

        bucket.draw(batch);

        Iterator<FallingGameObject> iter = fallingObjects.iterator();

        while (iter.hasNext()) {
            if (bucket.rectangle.overlaps(iter.next().rectangle)) {
                score += 1;
                iter.remove();
            }

//            if(iter.next().rectangle.y<-20) {iter.remove();}
        }


        bitmapFont.draw(batch, score.toString(), 750, 550);

        batch.end();

        if (score > 10) {

            main.getMain().useGameOverScreen();
            gameMusic.stop();


        }


    }

    //
    public void update() {

        bucketController.controll(bucket.rectangle, camera, bucket);
        bucketController.borderCheck(bucket);
        bucketController.boost(bucket, fallingObjects);

    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        batch.dispose();

    }


}

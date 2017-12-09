package com.drop.game.view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.drop.game.Main;
import com.drop.game.model.User;

import java.io.IOException;


/**
 * Created by Vova on 10.10.2017.
 */
public class GameOverScreen implements Screen {
    User user;
    Texture background;
    Image img;
    OrthographicCamera camera;
    TextActor dropsCollected;
    TextActor dropsMissed;
    TextActor userName;
    Stage stage;
    Button btnRestart;
    Main main;
    Skin skin;


    @Override
    public void show() {
        user = new User();


        try {
            user.writer(user.getDropsCollected());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage = new Stage();


        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("uiskin.json"));


        background = new Texture("background.png");

        img = new Image(background);
        img.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(user.reader());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
      Закончить с сохранением данных  и выводом их на экран.

      Попробовать через Ридер - Стринг Буффер - Стринг..
  !!!!!!!!!!!!!!20,10,2017

*/

        btnRestart = new Button(skin);
        btnRestart.add("Restart");
        btnRestart.setSize(150, 50);
        btnRestart.setPosition(325, 375);
        btnRestart.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                main.getMain().useMenuScreen();
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        dropsCollected = new TextActor("Drops collected " + user.dropsCollToString(), stage.getBatch(), 350, 280);
        dropsMissed = new TextActor("Drops missed " + user.dropsMissToString(), stage.getBatch(), 350, 260);
        userName = new TextActor(user.getUserName(), stage.getBatch(), 350, 300);
        stage.addActor(img);
        stage.addActor(btnRestart);
        stage.addActor(dropsCollected);
        stage.addActor(dropsMissed);
        stage.addActor(userName);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        stage.act();
        stage.draw();
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
        stage.dispose();
        background.dispose();

    }
}

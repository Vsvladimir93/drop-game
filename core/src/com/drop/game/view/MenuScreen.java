package com.drop.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.drop.game.Main;
import com.drop.game.model.User;

import java.io.IOException;


/**
 * Created by Vova on 30.09.2017.
 */
public class MenuScreen implements Screen {
    private Texture background;
    private SpriteBatch batch;

    Stage stage;
    TextField textField;
    Skin skin;


    User user;
    private String userName = "";
    Main main;
    Button btn, btn1, btn2;

    public MenuScreen(Main main) {
        super();
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        System.out.println("0987");
        this.main = main;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        btn = new Button(skin);
        btn1 = new Button(skin);
        btn2 = new Button(skin);
        user = new User();
    }

    public MenuScreen() {
    }

    @Override
    public void show() {

        batch = new SpriteBatch();
        background = new Texture("background.png");

        Image img = new Image(background);
        img.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        btn.setPosition(625, 530);
        btn.setSize(150, 50);
        btn1.setPosition(225, 150);
        btn1.setSize(150, 50);
        btn2.setPosition(425, 150);
        btn2.setSize(150, 50);
        btn.add("Option");
        btn1.add("Start");
        btn2.add("Quit");

        btn.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                return super.touchDown(event, x, y, pointer, button);
            }

        });

        btn1.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println(textField.getText());
                user.setUserName(textField.getText());
                try {
                    user.writer(textField.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                User.setDropsCollected(0);
                main.getMain().useGameScreen();

                return super.touchDown(event, x, y, pointer, button);
            }
        });


        btn2.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                Gdx.app.exit();
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        textField = new TextField("", skin);
        textField.setMessageText("Enter your name here");
        textField.setSize(350, 60);
        textField.setPosition(225, 250);

        stage.addActor(img);
        stage.addActor(btn);
        stage.addActor(btn1);
        stage.addActor(btn2);
        stage.addActor(textField);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        batch.begin();

        stage.draw();

        batch.end();

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            System.out.println(textField.getText());
            user.setUserName(textField.getText());
            try {
                user.writer(textField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            User.setDropsCollected(0);
            main.getMain().useGameScreen();

        }

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
        batch.dispose();
    }
}

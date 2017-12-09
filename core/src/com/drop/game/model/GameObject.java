package com.drop.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Vova on 14.09.2017.
 */
public class GameObject {

    public Rectangle rectangle;
    Sprite sprite;
    TextureAtlas atlas;
    String spriteName;


    /* GameObject(Texture texture, float x, float y, float width, float height) {
         rectangle = new Rectangle(x, y, width, height);
         sprite = new Sprite(texture);
     }*/

    GameObject(String atlasFile, String spriteName, float x, float y, float width, float height) {
        rectangle = new Rectangle(x, y, width, height);
        atlas = new TextureAtlas(atlasFile);
        sprite = atlas.createSprite(spriteName);
        this.spriteName = spriteName;
    }

    GameObject(String atlasFile, String spriteName) {
        atlas = new TextureAtlas(atlasFile);
        sprite = atlas.createSprite(spriteName);
        this.spriteName = spriteName;

    }

    GameObject(float x, float y, float width, float height) {
        rectangle = new Rectangle(x, y, width, height);
    }

    public GameObject() {

    }


    //метод отрисовывающий модель по параметрам из конструктора
    public void draw(SpriteBatch batch) {
        sprite.setBounds(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        sprite.draw(batch);
    }

    public GameObject spawn(float x, float y) {
        throw new RuntimeException("Child class " + this.getClass().getSimpleName() + "  have to override method spawn");
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
        sprite = atlas.createSprite(spriteName);

    }

    public String getSpriteName() {
        return spriteName;
    }


}

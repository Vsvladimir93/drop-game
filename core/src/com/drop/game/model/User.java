package com.drop.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vova on 01.10.2017.
 */
public class User {
    FileWriter fileWriter;
    FileReader fileReader;

    private static int dropsCollected = 1;
    private static int dropsMissed = 0;
    private static String userName = "";


    public User() {


    }

    public String dropsCollToString() {
        Integer number = dropsCollected;
        return number.toString();

    }

    public static int getDropsCollected() {
        return dropsCollected;
    }

    public static void setDropsCollected(int number) {
        dropsCollected = number;
    }

    public String dropsMissToString () {
        Integer number = dropsMissed;
        return number.toString();
    }

    public static int getDropsMissed() {
        return dropsMissed;
    }

    public static void setDropsMissed(int dropsMissed) {
        User.dropsMissed = dropsMissed;
    }

    public static String getUserName() {
        return userName;

    }

    public void setUserName(String userName) {
        User.userName = userName;

    }

    public void writer(String value) throws IOException {

        fileWriter = new FileWriter("Users.txt", true);
        fileWriter.write("\n<" + getUserName() + ">");
        fileWriter.flush();
    }

    public void writer(int value) throws IOException {

        fileWriter = new FileWriter("Users.txt", true);
        fileWriter.write("*" + value + "*");
        fileWriter.flush();
    }

    public char reader() throws IOException {
        fileReader = new FileReader("Users.txt");
        int c;
        while ((c = fileReader.read()) != -1) {
            int counter = 0;
            if ((char) c == '<') return ' ';
            if ((char) c == '>') return ' ';
            if ((char) c == '*') {
                counter ++;
               if(counter == 2){
                   counter =0;
                   return '\n';}
                return ' ';
            }
            return (char) c;
        }
        return (char)c;
    }

    class TextActor extends Actor {

        BitmapFont font;
        Batch batch;
        String string;

        TextActor (Batch batch, String string) {
            font = new BitmapFont(Gdx.files.internal("default.fnt"));
            this.batch = batch;
            this.string = string;
        }
        @Override
        public void draw(Batch batch, float parentAlpha) {
            font.draw(batch, string, 200, 200 );
        }
    }

    public Actor collectedActor(Stage stage) {
        TextActor textActor = new TextActor(stage.getBatch(), dropsCollToString());

        return textActor;
    }

   /* public void checkForAndOrDesk () {
        Gdx.app.getType();
//        return type of application Android or Desktop
    }
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
    */


}

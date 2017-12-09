package com.drop.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.drop.game.view.GameOverScreen;
import com.drop.game.view.GameScreen;
import com.drop.game.view.MenuScreen;


public class Main extends Game {
    private static Screen gameScreen;
    private static Screen menuScreen;
    private static Screen gameOverScreen = new GameOverScreen();
    public Game game;
    private static Main main;

    public Main() {

    }


    @Override
    public void create() {
       menuScreen = new MenuScreen(this);


        setScreen(menuScreen);


    }

    @Override
    public void render() {
        super.render();

    }


    public static Main getMain() {
        if (main == null) {
            main = new Main();
        }
        return main;
    }

    public void useGameScreen() {
        if (gameScreen == null) {
            gameScreen = new GameScreen();
        }
        setScreen(gameScreen);
        menuScreen.dispose();
        menuScreen = null;

    }

    public void useGameOverScreen() {
        if (gameOverScreen == null) {
            gameOverScreen = new GameOverScreen();

        }
        setScreen(gameOverScreen);

        gameScreen = null;
    }

    public void useMenuScreen() {
        if (menuScreen == null) {
            menuScreen = new MenuScreen(this);

        }

        setScreen(menuScreen);
        if (gameOverScreen != null) gameOverScreen.dispose();
        gameOverScreen = null;

    }

    public void test() {
        if (menuScreen == null) System.out.println("menuScreen-null");
        if (gameScreen == null) System.out.println("gameScreen-null");
        if (gameOverScreen == null) System.out.println("gameOverScreen-null");
    }

}

package com.drop.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.drop.game.view.GameOverScreen;
import com.drop.game.view.GameScreen;
import com.drop.game.view.MenuScreen;


public class Main extends Game {
    private Screen gameScreen;
    private Screen menuScreen;
    private Screen gameOverScreen = new GameOverScreen();
    public Game game;
    private static Main main;

    private Main() {

    }


    @Override
    public void create() {
        menuScreen = new MenuScreen(this);


setScreen(menuScreen);
//      setScreen(gameOverScreen);

    }

    @Override
    public void render() {
        super.render();

    }



    public static Main getMain() {
        if(main  == null){
            main = new Main();
        }
        return main;
    }

    public void useGameScreen() {
        if (gameScreen == null) {
            gameScreen = new GameScreen();
        }
        setScreen(gameScreen);
    }

    public void useGameOverScreen() {
        if (gameOverScreen == null) {
            gameOverScreen = new GameScreen();
            gameScreen.dispose();

        }

        setScreen(gameOverScreen);
    }

}

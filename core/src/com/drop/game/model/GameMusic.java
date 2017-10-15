package com.drop.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by Vova on 26.09.2017.
 */
public class GameMusic {
    Music music;
    Music.OnCompletionListener onCompletionListener = new Music.OnCompletionListener() {
        @Override
        public void onCompletion(Music music) {
            music.dispose();
            if (counter >= 3) {
                counter = -1;
            }
            counter++;
            createPlayer(Gdx.files.internal(arr[counter])).play();
        }
    };

    String[] arr = {"music.mp3", "music2.mp3", "music3.mp3"};

    int counter = 0;

    public void play() {
        createPlayer(Gdx.files.internal(arr[counter])).play();
    }

    public void stop() {
        music.dispose();
    }

    private Music createPlayer(FileHandle musicFile) {
        music = Gdx.audio.newMusic(musicFile);
        music.setOnCompletionListener(onCompletionListener);
        music.setVolume(0.4f);
        return music;
    }


}

package com.magneto.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.magneto.platformer.Assets;
import com.magneto.platformer.Platformer;
import com.magneto.platformer.screen.GameScreen;

public class MainMenuScreen implements Screen {

    private final Platformer game;
    private final OrthographicCamera camera;
    private AssetManager assetManager;

    public MainMenuScreen(Platformer game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(final float delta) {

        //DEBUGGING TO SKIP SCREEN FOR NOW

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // load loading images and wait until finished
        assetManager = Assets.load();
        assetManager.finishLoading();

        game.setScreen(new NewGameScreen());
        dispose();

        camera.update();
        game.getSpriteBatch().setProjectionMatrix(camera.combined);

        game.getSpriteBatch().begin();
        game.getBitmapFont().draw(game.getSpriteBatch(), "Welcome to magneto :) ", 100, 150);
        game.getBitmapFont().draw(game.getSpriteBatch(), "Press the ENTER key to start!", 100, 100);
        game.getSpriteBatch().end();

        /*if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }*/

    }

    @Override
    public void resize(final int width, final int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}
    @Override
    public void hide() {}

    @Override
    public void dispose() {}

    @Override
    public void show() {}
}

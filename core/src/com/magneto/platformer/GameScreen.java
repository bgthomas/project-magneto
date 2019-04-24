package com.magneto.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen {

    final Platformer game;
    private Texture dinoImg;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Rectangle dino;
    private Sprite dinoSprite;

    public GameScreen(Platformer game){

        this.game = game;

        //Set up camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);

        //Load in textures
        batch = new SpriteBatch();
        dinoImg = new Texture("dinoDoux.png");
        dinoSprite = new Sprite(dinoImg,0,0,27,30);
        dinoSprite.scale(3);
        dinoSprite.setPosition(50,50);
        //textureRegion = new TextureRegion(dinoImg,0,0,20,20);

        dino = new Rectangle();
        dino.x = 50;
        dino.y = 50;
        dino.width = 27;
        dino.height = 30;

    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        dinoSprite.draw(batch);
        batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            float dinoXPosition = dino.x -= 200 * Gdx.graphics.getDeltaTime();
            dinoSprite.setPosition(dinoXPosition,dino.y);
            dino.x = dinoXPosition;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            float dinoXPosition = dino.x += 200 * Gdx.graphics.getDeltaTime();
            dinoSprite.setPosition(dinoXPosition,dino.y);
            dino.x = dinoXPosition;
        }

        if(dino.x < 0) {
            dino.x = 0;
        }
        if(dino.x > 800 - 27) {
            dino.x = 800 - 27;
        }

    }

    @Override
    public void show() {

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
        dinoImg.dispose();
    }
}

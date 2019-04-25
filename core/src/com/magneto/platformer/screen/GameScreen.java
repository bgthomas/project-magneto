package com.magneto.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.magneto.platformer.Platformer;
import com.magneto.platformer.animation.DinoAnimator;
import lombok.NonNull;

public class GameScreen implements Screen {

    private final Platformer game;
    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private final DinoAnimator dinoAnimator;

    private float dinoPosition = 0;
    private float dinoAnimationStateTime;

    public GameScreen(@NonNull final Platformer game){

        this.game = game;

        //Set up camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);

        dinoAnimator = new DinoAnimator();

        batch = new SpriteBatch();

    }

    @Override
    public void render (final float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        dinoAnimationStateTime = dinoAnimator.getStateTime();

        //if right is pressed calculate animation state time else reset it back to 0 (standing state)
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            dinoAnimationStateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
            dinoPosition += 1;
        } else {
            dinoAnimationStateTime = 0.0f;
        }

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = dinoAnimator.getWalkAnimation().getKeyFrame(dinoAnimationStateTime, false);

        batch.begin();
        batch.draw(currentFrame,dinoPosition,0, 50, 50); // Draw current frame at (50, 50)
        batch.end();

        dinoAnimator.setStateTime(dinoAnimationStateTime);

    }

    @Override
    public void dispose() {
        batch.dispose();
        dinoAnimator.getWalkSheet().dispose();
    }

    @Override
    public void show() {}

    @Override
    public void resize(final int width, final int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

}

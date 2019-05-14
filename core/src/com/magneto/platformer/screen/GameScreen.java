package com.magneto.platformer.screen;

/*import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.magneto.platformer.Platformer;
import com.magneto.platformer.animation.DinoAnimator;
import com.magneto.platformer.physics.DinoPhysics;
import com.magneto.platformer.physics.LevelPhysics;
import com.magneto.platformer.entity.systems.PhysicsCacheManager;
import com.magneto.platformer.physics.WorldPhysics;
import lombok.NonNull;*/

public class GameScreen {

  /*private final Platformer game;
      private final OrthographicCamera camera;
      private final SpriteBatch batch;
      private final DinoAnimator dinoAnimator;
      private final LevelPhysics levelPhysics;
      private final WorldPhysics worldPhysics;
      private final DinoPhysics dinoPhysics;
      private final World world;

      private float dinoAnimationStateTime;

      private Box2DDebugRenderer debugRenderer;

      public GameScreen(@NonNull final Platformer game){

          this.game = game;

          //Set up camera
          camera = new OrthographicCamera();
          camera.setToOrtho(false,800,480);

          //Animation
          dinoAnimator = new DinoAnimator();
          batch = new SpriteBatch();

          Box2D.init();
          debugRenderer = new Box2DDebugRenderer();

          //Physics dude
          world = new World(new Vector2(0, -120), true);
          levelPhysics = new LevelPhysics(world,camera);
          worldPhysics = new WorldPhysics(world);

          PhysicsCacheManager physicsCacheManager = new PhysicsCacheManager();
          dinoPhysics = new DinoPhysics(world,physicsCacheManager);

          levelPhysics.createGround();

      }

      @Override
      public void render (final float delta) {

          Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
          worldPhysics.stepWorld();

          camera.update();

          batch.setProjectionMatrix(camera.combined);

          dinoAnimationStateTime = dinoAnimator.getStateTime();

          TextureRegion currentFrame;

          batch.begin();

          Vector2 position = dinoPhysics.getDinoBody().getPosition();

          boolean flip = false;

          //if right is pressed calculate animation state time else reset it back to 0 (standing state)
          if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
              dinoPhysics.getDinoBody().applyForce(10000, 0, position.x,position.y, true);
              dinoAnimationStateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

              if(dinoPhysics.getDirection() == "LEFT"){
                  flip = true;
              }

              dinoPhysics.setDirection("RIGHT");
          }
          else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

              dinoPhysics.getDinoBody().applyForce(-10000, 0, position.x,position.y, true);
              dinoAnimationStateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

              if(dinoPhysics.getDirection() == "RIGHT"){
                  flip = true;
              }

              dinoPhysics.setDirection("LEFT");

          } else {
              dinoAnimationStateTime = 0.0f;
          }


          currentFrame = dinoAnimator.getWalkAnimation().getKeyFrame(dinoAnimationStateTime, true);

          if(flip){
              dinoAnimator.flipFrames(true, false);
          }

          batch.draw(currentFrame,position.x,position.y, 50, 50); // Draw current frame at (50, 50)
          batch.end();

          dinoAnimator.setStateTime(dinoAnimationStateTime);

          debugRenderer.render(world, camera.combined);

      }

      @Override
      public void dispose() {
          batch.dispose();
          dinoAnimator.getWalkSheet().dispose();
          world.dispose();
      }

      @Override
      public void show() {}

      @Override
      public void resize(final int width, final int height) {
      }

      @Override
      public void pause() {}

      @Override
      public void resume() {}

      @Override
      public void hide() {}
  */
}

package com.magneto.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.magneto.platformer.Platformer;
import com.magneto.platformer.animation.DinoAnimator;
import com.badlogic.gdx.math.Vector2;

import com.codeandweb.physicseditor.PhysicsShapeCache;

import lombok.NonNull;

public class GameScreen implements Screen {

    private final Platformer game;
    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private final DinoAnimator dinoAnimator;

    private float dinoPosition = 0;
    private float dinoAnimationStateTime;
    private World world;
    float accumulator = 0;

    static final float STEP_TIME = 1f / 60f;
    static final int VELOCITY_ITERATIONS = 6;
    static final int POSITION_ITERATIONS = 2;

    Box2DDebugRenderer debugRenderer;
    PhysicsShapeCache physicsBodies;
    Body dinoBody;
    Body ground;

    public GameScreen(@NonNull final Platformer game){

        this.game = game;

        //Set up camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);

        dinoAnimator = new DinoAnimator();

        batch = new SpriteBatch();

        Box2D.init();
        debugRenderer = new Box2DDebugRenderer();

        world = new World(new Vector2(0, -120), true);
        physicsBodies = new PhysicsShapeCache(Gdx.files.internal("physics.xml"));

        dinoBody = physicsBodies.createBody("dinoSingle", world, 1.4f, 1.4f);
        dinoBody.setTransform(40,100, 0);

    }

    private void stepWorld() {
        float delta = Gdx.graphics.getDeltaTime();

        accumulator += Math.min(delta, 0.25f);

        if (accumulator >= STEP_TIME) {
            accumulator -= STEP_TIME;

            world.step(STEP_TIME, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        }
    }

    @Override
    public void render (final float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stepWorld();

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        dinoAnimationStateTime = dinoAnimator.getStateTime();

        TextureRegion currentFrame;
        boolean flip = false;

        /*else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            dinoAnimationStateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
            dinoPosition -= 1;

            if(dinoAnimator.getDirection() == "RIGHT") {
                flip = true;
            }
            dinoAnimator.setDirection("LEFT");
        }
        else {
            dinoAnimationStateTime = 0.0f;
        }
        */

        batch.begin();


        /*if(flip){
            currentFrame.flip(true, false);
        }*/

        Vector2 position = dinoBody.getPosition();
        currentFrame = dinoAnimator.getWalkAnimation().getKeyFrame(0, true);

        //if right is pressed calculate animation state time else reset it back to 0 (standing state)
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            dinoBody.applyLinearImpulse(500, 0, position.x,position.y, true);
        }
        batch.draw(currentFrame,position.x,position.y, 50, 50); // Draw current frame at (50, 50)
        batch.end();

        //dinoAnimator.setStateTime(dinoAnimationStateTime);

        debugRenderer.render(world, camera.combined);

    }

    private void createGround() {
        if (ground != null) world.destroyBody(ground);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        FixtureDef fixtureDef = new FixtureDef();

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(camera.viewportWidth, 1);

        fixtureDef.shape = shape;
        fixtureDef.friction = 1;

        ground = world.createBody(bodyDef);
        ground.createFixture(fixtureDef);
        ground.setTransform(0, 0, 0);

        shape.dispose();
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
        createGround();
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

}

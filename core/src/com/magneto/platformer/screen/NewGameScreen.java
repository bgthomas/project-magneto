package com.magneto.platformer.screen;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.magneto.platformer.entity.components.*;
import com.magneto.platformer.entity.systems.AnimationSystem;
import com.magneto.platformer.entity.systems.PhysicsDebugSystem;
import com.magneto.platformer.entity.systems.RenderingSystem;
import com.magneto.platformer.entity.systems.TextureSystem;

public class NewGameScreen implements Screen {

    private final SpriteBatch spriteBatch;
    private final OrthographicCamera camera;
    private final World world;
    private final PooledEngine engine;

    public NewGameScreen(){

        world = new World(new Vector2(0, -120), true);
        //world.setContactListener(new B2dContactListener());

        spriteBatch = new SpriteBatch();

        // Create our new rendering system
        RenderingSystem renderingSystem = new RenderingSystem(spriteBatch);
        camera = renderingSystem.getCamera();
        spriteBatch.setProjectionMatrix(camera.combined);

        //create a pooled engine
        engine = new PooledEngine();

        // add all the relevant systems our engine should run
        engine.addSystem(new TextureSystem());
        engine.addSystem(new AnimationSystem());
        engine.addSystem(renderingSystem);
        //engine.addSystem(new PhysicsSystem(world));
        engine.addSystem(new PhysicsDebugSystem(world, renderingSystem.getCamera()));
        //engine.addSystem(new CollisionSystem());
        //engine.addSystem(new PlayerControlSystem(controller));

        // create some game objects
        createPlayer();
        //createFloor();

    }

    private void createPlayer(){
        // Create the Entity and all the components that will go in the entity
        Entity entity = engine.createEntity();
        TransformComponent position = engine.createComponent(TransformComponent.class);
        TextureComponent texture = engine.createComponent(TextureComponent.class);
        PlayerComponent player = engine.createComponent(PlayerComponent.class);
        //CollisionComponent colComp = engine.createComponent(CollisionComponent.class);
        TypeComponent type = engine.createComponent(TypeComponent.class);
        StateComponent stateCom = engine.createComponent(StateComponent.class);
        AnimationComponent animationCom = engine.createComponent(AnimationComponent.class);

        // create the data for the components and add them to the components
        //b2dbody.body = bodyFactory.makeCirclePolyBody(10,10,1, BodyFactory.STONE, BodyDef.BodyType.DynamicBody,true);
        // set object position (x,y,z) z used to define draw order 0 first drawn
        //position.position.set(10,10,0);
        //texture.region = atlas.findRegion("player");

        type.type = TypeComponent.PLAYER;
        stateCom.set(StateComponent.STATE_NORMAL);
        //b2dbody.body.setUserData(entity);

        // add the components to the entity
        //entity.add(b2dbody);
        entity.add(position);
        entity.add(texture);
        entity.add(player);
        //entity.add(colComp);
        entity.add(type);
        entity.add(stateCom);
        entity.add(animationCom);

        // add the entity to the engine
        engine.addEntity(entity);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        engine.update(delta);

    }

    @Override
    public void show() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}

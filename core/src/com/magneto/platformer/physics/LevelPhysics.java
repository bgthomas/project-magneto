package com.magneto.platformer.physics;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.physics.box2d.*;
import lombok.Getter;

public class LevelPhysics {

    @Getter private Body ground;
    private World world;
    private Camera camera;

    public LevelPhysics(World world, Camera camera){
        this.world = world;
        this.camera = camera;
    }

    public void createGround() {

        if (ground != null) {
            world.destroyBody(ground);
        }

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
}
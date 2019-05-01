package com.magneto.platformer.physic;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.physics.box2d.*;
import lombok.Getter;
import lombok.Setter;

public class LevelPhysics {

    private Body ground;
    @Setter @Getter private World world;
    @Setter @Getter private Camera camera;

    public LevelPhysics(World world, Camera camera){
        this.world = world;
        this.camera = camera;
    }

    public void createGround() {

        if (ground != null) {
            getWorld().destroyBody(ground);
        }

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        FixtureDef fixtureDef = new FixtureDef();

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getCamera().viewportWidth, 1);

        fixtureDef.shape = shape;
        fixtureDef.friction = 1;

        ground = world.createBody(bodyDef);
        ground.createFixture(fixtureDef);
        ground.setTransform(0, 0, 0);

        shape.dispose();

    }
}
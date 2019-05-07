package com.magneto.platformer.physics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import lombok.Getter;
import lombok.Setter;

public class WorldPhysics {

    @Getter private float accumulator = 0;
    @Getter private static final float STEP_TIME = 1f / 60f;
    @Getter private static final int VELOCITY_ITERATIONS = 6;
    @Getter private static final int POSITION_ITERATIONS = 2;
    @Setter private World world;

    public WorldPhysics(World world){
        this.world = world;
    }

    public void stepWorld() {

        float delta = Gdx.graphics.getDeltaTime();

        accumulator += Math.min(delta, 0.25f);

        if (accumulator >= STEP_TIME) {
            accumulator -= STEP_TIME;

            world.step(STEP_TIME, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        }
    }

}

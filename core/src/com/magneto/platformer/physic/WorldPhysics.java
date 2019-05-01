package com.magneto.platformer.physic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import lombok.Getter;
import lombok.Setter;

public class WorldPhysics {

    @Getter @Setter private float accumulator = 0;
    @Getter @Setter static final float STEP_TIME = 1f / 60f;
    @Getter @Setter static final int VELOCITY_ITERATIONS = 6;
    @Getter @Setter static final int POSITION_ITERATIONS = 2;
    @Setter @Getter private World world;

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

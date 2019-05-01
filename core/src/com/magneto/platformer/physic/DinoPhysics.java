package com.magneto.platformer.physic;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import lombok.Getter;
import lombok.Setter;

public class DinoPhysics {

    @Getter @Setter private final Body dinoBody;

    public DinoPhysics(World world,PhysicsCacheManager physicsCacheManager){
        dinoBody = physicsCacheManager.getPhysicsBodies().createBody("dinoSingle", world, 1.4f, 1.4f);
        dinoBody.setTransform(40,100, 0);
    }
}

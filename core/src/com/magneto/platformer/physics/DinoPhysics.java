package com.magneto.platformer.physics;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.magneto.platformer.entity.systems.PhysicsCacheManager;
import lombok.Getter;
import lombok.Setter;

public class DinoPhysics {

    @Getter private final Body dinoBody;
    @Getter @Setter private String direction;

    public DinoPhysics(World world, PhysicsCacheManager physicsCacheManager){
        dinoBody = physicsCacheManager.getPhysicsBodies().createBody("dinoSingle", world, 1.4f, 1.4f);
        dinoBody.setTransform(40,100, 0);
        dinoBody.setFixedRotation(true);
    }
}
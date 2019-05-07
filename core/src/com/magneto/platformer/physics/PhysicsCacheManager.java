package com.magneto.platformer.physics;

import com.codeandweb.physicseditor.PhysicsShapeCache;
import lombok.Getter;
import lombok.Setter;

public class PhysicsCacheManager {

    @Getter @Setter PhysicsShapeCache physicsBodies;

    public PhysicsCacheManager(){
        physicsBodies = new PhysicsShapeCache("physics.xml");
    }
}

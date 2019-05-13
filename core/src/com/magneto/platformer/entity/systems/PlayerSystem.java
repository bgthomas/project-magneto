package com.magneto.platformer.entity.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.World;
import com.magneto.platformer.entity.components.BodyComponent;
import com.magneto.platformer.entity.components.PlayerComponent;
import com.magneto.platformer.entity.components.StateComponent;
import com.magneto.platformer.entity.components.TransformComponent;

public class PlayerSystem extends IteratingSystem {

    private ComponentMapper<BodyComponent> bodyMapper = ComponentMapper.getFor(BodyComponent.class);
    private ComponentMapper<StateComponent> stateMapper = ComponentMapper.getFor(StateComponent.class);
    private World world;

    public PlayerSystem(World world) {
        super(Family.all(BodyComponent.class, TransformComponent.class,PlayerComponent.class).get());
        this.world = world;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        float xForce = 0;

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            xForce = 10000;
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            xForce = -10000;
        }

        if (xForce != 0){
            BodyComponent bodyComponent = bodyMapper.get(entity);
            bodyComponent.body.applyForce(xForce, 0, bodyComponent.body.getPosition().x,bodyComponent.body.getPosition().y, true);

            StateComponent stateComponent = stateMapper.get(entity);
            stateComponent.set(3);
        }

    }
}

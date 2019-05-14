package com.magneto.platformer.entity.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.magneto.platformer.entity.components.AnimationComponent;
import com.magneto.platformer.entity.components.StateComponent;
import com.magneto.platformer.entity.components.TextureComponent;

public class AnimationSystem extends IteratingSystem {

  private ComponentMapper<TextureComponent> textureMapper;
  private ComponentMapper<AnimationComponent> animationMapper;
  private ComponentMapper<StateComponent> stateMapper;

  public AnimationSystem() {
    super(Family.all(TextureComponent.class, AnimationComponent.class, StateComponent.class).get());

    textureMapper = ComponentMapper.getFor(TextureComponent.class);
    animationMapper = ComponentMapper.getFor(AnimationComponent.class);
    stateMapper = ComponentMapper.getFor(StateComponent.class);
  }

  @Override
  protected void processEntity(Entity entity, float deltaTime) {

    AnimationComponent ani = animationMapper.get(entity);
    StateComponent state = stateMapper.get(entity);
    TextureComponent tex = textureMapper.get(entity);

    // ani.animation = new Animation<TextureRegion>(0.025f, tex.region);
    // tex.currentRegion = ani.animation.getKeyFrame(state.time, state.isLooping);

    state.time += deltaTime;
  }
}

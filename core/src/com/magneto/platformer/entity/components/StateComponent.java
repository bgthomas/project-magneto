package com.magneto.platformer.entity.components;

import com.badlogic.ashley.core.Component;
import lombok.Getter;

public class StateComponent implements Component {
  public static final int STATE_NORMAL = 0;
  public static final int STATE_JUMPING = 1;
  public static final int STATE_FALLING = 2;
  public static final int STATE_MOVING = 3;

  @Getter private int state = 0;
  public float time = 0.0f;
  public boolean isLooping = false;

  public void set(int newState) {
    state = newState;
    time = 0.0f;
  }
}

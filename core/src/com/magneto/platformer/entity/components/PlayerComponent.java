package com.magneto.platformer.entity.components;

import com.badlogic.ashley.core.Component;

public class PlayerComponent implements Component {
  public static final int STATE_JUMP = 0;
  public static final int STATE_FALL = 1;
  public static final int STATE_HIT = 2;
  public static final float JUMP_VELOCITY = 11;
  public static final float MOVE_VELOCITY = 20;
  public float heightSoFar = 0.0f;
}

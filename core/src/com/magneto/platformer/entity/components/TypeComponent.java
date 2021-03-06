package com.magneto.platformer.entity.components;

import com.badlogic.ashley.core.Component;

/*
 * Stores the type of entity this is
 */
public class TypeComponent implements Component {
  public static final int PLAYER = 0;
  public static final int ENEMY = 1;
  public static final int SCENE = 3;
  public static final int OTHER = 4;

  public int type = OTHER;
}

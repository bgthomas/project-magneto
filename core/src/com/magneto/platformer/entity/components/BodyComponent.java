package com.magneto.platformer.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

public class BodyComponent implements Component {
  public Body body;
  public String name;
}

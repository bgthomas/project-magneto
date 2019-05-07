package com.magneto.platformer.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureComponent implements Component {
    public TextureRegion[] region = null;
    public TextureRegion currentRegion = null;
}
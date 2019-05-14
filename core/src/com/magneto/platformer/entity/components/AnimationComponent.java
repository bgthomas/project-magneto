package com.magneto.platformer.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.ArrayMap;
import lombok.Getter;

public class AnimationComponent implements Component {

    @Getter private ArrayMap<String, Animation> animations = new ArrayMap<String, Animation>();


    public AnimationComponent addAnimation(String stateName, Animation animation){

        this.animations.put(stateName, animation);

        return this;
    }
}

package com.magneto.platformer.entity.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.magneto.platformer.entity.components.TextureComponent;

public class TextureSystem extends IteratingSystem {

    private ComponentMapper<TextureComponent> textureMapper;

    public TextureSystem(){
        super(Family.all(TextureComponent.class).get());
        textureMapper = ComponentMapper.getFor(TextureComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        /*TextureComponent textureComponent = textureMapper.get(entity);

        Texture walkSheet = new Texture(Gdx.files.internal("dinoV2.png"));

        textureComponent.region = generateWalkFrames(walkSheet);*/

    }

    private TextureRegion[] generateWalkFrames(Texture walkSheet) {

        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
                walkSheet.getWidth() / 14,
                walkSheet.getHeight() / 1);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] walkFrames = new TextureRegion[14 * 1];

        int index = 0;

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 14; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }

        return walkFrames;
    }
}

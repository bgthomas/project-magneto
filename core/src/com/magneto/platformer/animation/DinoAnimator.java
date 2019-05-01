package com.magneto.platformer.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;
import lombok.Setter;

public class DinoAnimator {

    private static final int FRAME_COLS = 14, FRAME_ROWS=1;

    @Getter @Setter private Animation<TextureRegion> walkAnimation;
    @Getter @Setter private Animation<TextureRegion> walkAnimationLeft;
    @Getter @Setter private Texture walkSheet;
    @Getter @Setter private SpriteBatch spriteBatch;
    @Getter @Setter private float stateTime;
    @Getter @Setter private String direction;

    public DinoAnimator(){
        createTextures();
    }

    //Create textures
    private void createTextures(){
        walkSheet = new Texture(Gdx.files.internal("dinoV2.png"));

        TextureRegion[] walkFrames = generateWalkFrames(walkSheet);

        // Initialize the Animation with the frame interval and array of frames
        walkAnimation = new Animation<TextureRegion>(0.025f, walkFrames);

        // Instantiate a SpriteBatch for drawing and reset the elapsed animation
        // time to 0
        stateTime = 0f;

    }

    private TextureRegion[] generateWalkFrames(Texture walkSheet) {

        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
                walkSheet.getWidth() / FRAME_COLS,
                walkSheet.getHeight() / FRAME_ROWS);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }

        return walkFrames;
    }
}

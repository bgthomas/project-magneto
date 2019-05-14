package com.magneto.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;

public class Assets {

    @Getter  public static AssetManager assetManager;
    private static Class<TextureAtlas> TEXTURE_ATLAS = TextureAtlas.class;
    private static final String DINO_ATLAS = Gdx.files.internal("dino.atlas").path();

    public static AssetManager load() {

        assetManager = new AssetManager();

        assetManager.load(DINO_ATLAS, TEXTURE_ATLAS);
        //assetManager.get(Gdx.files.internal("dino.atlas").path(), TEXTURE_ATLAS).findRegion("dinoV2");
        return assetManager;

    }

    public static TextureRegion getDinoFrames(){
        return assetManager.get(DINO_ATLAS, TEXTURE_ATLAS).findRegion("dinoV2");
    }

}

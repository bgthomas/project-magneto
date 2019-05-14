package com.magneto.platformer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.magneto.platformer.screen.MainMenuScreen;
import lombok.Getter;
import lombok.Setter;

public class Platformer extends Game {

  @Getter @Setter private SpriteBatch spriteBatch;
  @Getter @Setter private BitmapFont bitmapFont;

  public void create() {
    spriteBatch = new SpriteBatch();
    bitmapFont = new BitmapFont();
    this.setScreen(new MainMenuScreen(this));
  }

  public void render() {
    super.render();
  }

  public void dispose() {
    spriteBatch.dispose();
    bitmapFont.dispose();
  }
}

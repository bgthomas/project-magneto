package com.magneto.platformer;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Platformer extends Game {

	public SpriteBatch spriteBatch;
	public BitmapFont bitmapFont;

	public void create(){
		spriteBatch = new SpriteBatch();
		//Use LibGDX's default Arial font.
		bitmapFont = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render(){
		super.render();
	}

	public void dispose(){
		spriteBatch.dispose();
		bitmapFont.dispose();
	}
}

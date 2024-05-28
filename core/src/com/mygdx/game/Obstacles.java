package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Obstacles {
	
	protected Rectangle area;
	protected Texture texture;
	
	public Obstacles(Texture texture, float x, float y) {
		this.texture = texture;
	    this.area = new Rectangle(x, y, 64, 64);
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public Rectangle getArea() {
		return area;
	}

	public abstract void de_buff(Tarro tarro);
}

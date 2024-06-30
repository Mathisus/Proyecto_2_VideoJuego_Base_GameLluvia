package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Paloma extends Obstacles implements Pickup{ 
	
	public Paloma (Texture texture, float x, float y) {
		super(texture,x,y, new EfectoPaloma());
	}
	
	@Override
	public void pick(Tarro tarro) {
		applyEffect(tarro);
	}
}

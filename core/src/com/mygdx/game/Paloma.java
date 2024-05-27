package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Paloma extends Obstacles implements Pickup{ 
	
	public Paloma (Texture texture, float x, float y) {
		super(texture,x,y);
	}
	
	@Override
	public void de_buff(Tarro tarro) {
		tarro.dañar();	
	}
	
	@Override
	public void pick(Tarro tarro){
		de_buff(tarro);
	}
}

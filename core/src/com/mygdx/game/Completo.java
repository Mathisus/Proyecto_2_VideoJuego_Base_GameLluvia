package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Completo extends Obstacles implements Pickup{
	
	public Completo(Texture texture, float x, float y) {
        super(texture, x, y, new EfectoCompleto());
    }

    
	@Override
	public void pick(Tarro tarro) {
		applyEffect(tarro);
	}
}
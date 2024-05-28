package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Completo extends Obstacles implements Pickup{
	
	public Completo(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    @Override
    public void de_buff(Tarro tarro) {
        tarro.sumarPuntos(10);
    }
    
    @Override
    public void pick(Tarro tarro) {
        de_buff(tarro);
    }

}

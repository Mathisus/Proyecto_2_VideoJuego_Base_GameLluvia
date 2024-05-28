package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Completo extends Obstacles implements Pickup{
	
	public Completo(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    @Override
    public void de_buff(Paratrooper paratrooper) {
    	paratrooper.sumarPuntos(1);
    }
    
    @Override
    public void pick(Paratrooper paratrooper) {
        de_buff(paratrooper);
    }

}

package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Completo extends Obstacles implements Pickup{
	
	public Completo(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    @Override
    public void de_buff(Paratrooper tarro) {
        tarro.sumarPuntos(1);
    }
    
    @Override
    public void pick(Paratrooper tarro) {
        de_buff(tarro);
    }

}

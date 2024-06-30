package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture; 

public class RareDrop extends Obstacles implements Pickup{
	
		
		public RareDrop (Texture texture, float x, float y,int tipo) {
			super(texture,x,y,new EfectoRareDrop(tipo));
		}
	
		
		
		@Override
		public void pick(Tarro tarro) {
			applyEffect(tarro);
		}
	}
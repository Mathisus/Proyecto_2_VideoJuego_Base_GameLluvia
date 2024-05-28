package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture; 

public class RareDrop extends Obstacles implements Pickup{
	
		public int tipo;
		
		public RareDrop (Texture texture, float x, float y) {
			super(texture,x,y);
		}
		
		@Override
		public void de_buff(Tarro tarro) {
			if(tipo == 1) {
				tarro.sumarVidas(1);
			}else if(tipo == 2){
				tarro.sumarVidas(2);
			}else {
				tarro.DesvanDeMiCasa();
			}
			
		}
		
		
		@Override
		public void pick(Tarro tarro){
			de_buff(tarro);
		}
}

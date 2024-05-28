package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture; 

public class RareDrop extends Obstacles implements Pickup{
	
		public int tipo;
		
		public RareDrop (Texture texture, float x, float y) {
			super(texture,x,y);
		}
		
		@Override
		public void de_buff(Paratrooper paratrooper) {
			if(tipo == 1) {
				paratrooper.sumarVidas(1);
			}else if(tipo == 2){
				paratrooper.sumarVidas(2);
			}else {
				paratrooper.DesvanDeMiCasa();
			}
			
		}
		
		
		@Override
		public void pick(Paratrooper paratrooper){
			de_buff(paratrooper);
		}
}

package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class RareDropSpawn implements InterfazRaredrop {
	
	@Override
	public RareDrop porciento(Texture textureVida1, Texture textureVida2,Texture textureMisil, float x ,float y) {
		
		 int temporal;
		
		Texture texture;
		 if (MathUtils.random(1, 9) < 4) {
			 texture = textureVida1;
			 temporal = 1;
		 }else if(MathUtils.random(1, 9) < 7) {
			 texture = textureVida2;
			 temporal = 2;
		 }else {
			 texture = textureMisil;
			 temporal = 3;
		 }
		
		RareDrop choripan = new RareDrop(texture, x, y);
		choripan.tipo = temporal;
		return choripan;
	}

}

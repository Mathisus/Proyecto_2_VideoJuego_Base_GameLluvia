package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Obstacles {
	
	protected Rectangle area;
	protected Texture texture;
	protected EfectoEnemigoInterfaz efectos;
	
	public Obstacles(Texture texture, float x, float y, EfectoEnemigoInterfaz efectos) {
		this.texture = texture;
	    this.area = new Rectangle(x, y, 64, 64);
	    this.efectos = efectos;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public Rectangle getArea() {
		return area;
	}
	
	public void de_buff(Tarro tarro) {
	    efectos.apply(tarro);
	}

	// Método Template
	public void applyEffect(Tarro tarro) {
	    // Pasos comunes que pueden ser necesarios antes de aplicar el de_buff
	    System.out.println("Preparando para aplicar el efecto...");

	    // Llamada al método abstracto que las subclases deben implementar
	    de_buff(tarro);
	    
	    // Pasos comunes que pueden ser necesarios después de aplicar el de_buff
	    System.out.println("Efecto aplicado correctamente.");
	}
}

	//public abstract void de_buff(Tarro tarro);


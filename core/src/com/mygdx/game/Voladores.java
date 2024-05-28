package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Voladores {
    private Array<Obstacles> obstaculos;
    private long lastDropTime;
    private Texture completoTexture;
    private Texture palomaTexture;
    private Texture choripanTexture1;
    private Texture choripanTexture2;
    private Texture misilTexture;
    private Music music;
    private float fallSpeed;

    public Voladores(Texture completoTexture, Texture palomaTexture, Texture choripanTexture1,Texture choripanTexture2,Texture misilTexture, Music music) {
        this.completoTexture = completoTexture;
        this.palomaTexture = palomaTexture;
        this.choripanTexture1 = choripanTexture1;
        this.choripanTexture2 = choripanTexture2;
        this.misilTexture = misilTexture;
        this.music = music;
        this.fallSpeed = 300; 
    }

    public void crear() {
    	obstaculos = new Array<>();
        crearObstaculos();
        music.setLooping(true);
        music.play();
    }

    private void crearObstaculos() {
        float x = MathUtils.random(0, 800 - 64);
        float y = 480;

        Obstacles obstaculo;
        if (MathUtils.random(1, 11) < 7) {
        	obstaculo = new Paloma(palomaTexture, x, y);
        } else if(MathUtils.random(1, 11) < 2) {
        	RareDrop PlaceHolder = new RareDrop(null, 0, 0);
        	RareDropSpawn rareDropSpawn = new RareDropSpawn();
        	PlaceHolder = rareDropSpawn.porciento(choripanTexture1, choripanTexture2, misilTexture, x, y);
			obstaculo = PlaceHolder;
        }
        else{
        	obstaculo = new Completo(completoTexture, x, y);
        }

        obstaculos.add(obstaculo);
        lastDropTime = TimeUtils.nanoTime();
    }

    public boolean actualizarMovimiento(Paratrooper paratrooper) {
  
        long intervaloSpawn = Math.max(300000000L, 1000000000 - paratrooper.getPuntos() * 1000000000L);

        if (TimeUtils.nanoTime() - lastDropTime > intervaloSpawn) {
        	crearObstaculos();
        }

        fallSpeed = 300 + paratrooper.getPuntos() * 3;

        for (int i = 0; i < obstaculos.size; i++) {
            Obstacles obstaculo = obstaculos.get(i);
            obstaculo.getArea().y -= fallSpeed * Gdx.graphics.getDeltaTime();

            if (obstaculo.getArea().y + 64 < 0) {
            	obstaculos.removeIndex(i);
                continue;
            }

            if (obstaculo.getArea().overlaps(paratrooper.getArea())) {
                ((Pickup) obstaculo).pick(paratrooper);
                obstaculos.removeIndex(i);

                if (paratrooper.getVidas() <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void actualizarDibujoLluvia(SpriteBatch batch) {
        for (Obstacles obstaculo : obstaculos) {
            batch.draw(obstaculo.getTexture(), obstaculo.getArea().x, obstaculo.getArea().y);
        }
    }
    
    public void continuar() {
        music.play();
    }

    public void destruir() {
        music.dispose();
    }

    public void pausar() {
        music.stop();
    }


}


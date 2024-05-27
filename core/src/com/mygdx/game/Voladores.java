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
    private Music rainMusic;
    private float velocidadCaida;

    public Voladores(Texture completoTexture, Texture palomaTexture, Music rainMusic) {
        this.completoTexture = completoTexture;
        this.palomaTexture = palomaTexture;
        this.rainMusic = rainMusic;
        this.velocidadCaida = 300; 
    }

    public void crear() {
    	obstaculos = new Array<>();
        crearObstaculos();
        rainMusic.setLooping(true);
        rainMusic.play();
    }

    private void crearObstaculos() {
        float x = MathUtils.random(0, 800 - 64);
        float y = 480;

        Obstacles obstaculo;
        if (MathUtils.random(1, 10) < 5) {
        	obstaculo = new Paloma(palomaTexture, x, y);
        } else {
        	obstaculo = new Completo(completoTexture, x, y);
        }

        obstaculos.add(obstaculo);
        lastDropTime = TimeUtils.nanoTime();
    }

    public boolean actualizarMovimiento(Tarro tarro) {
  
        long intervaloSpawn = Math.max(200000000L, 1000000000 - tarro.getPuntos() * 800000000L);

        if (TimeUtils.nanoTime() - lastDropTime > intervaloSpawn) {
        	crearObstaculos();
        }

        velocidadCaida = 300 + tarro.getPuntos() * 3;

        for (int i = 0; i < obstaculos.size; i++) {
            Obstacles obstaculo = obstaculos.get(i);
            obstaculo.getArea().y -= velocidadCaida * Gdx.graphics.getDeltaTime();

            if (obstaculo.getArea().y + 64 < 0) {
            	obstaculos.removeIndex(i);
                continue;
            }

            if (obstaculo.getArea().overlaps(tarro.getArea())) {
                ((Pickup) obstaculo).pick(tarro);
                obstaculos.removeIndex(i);

                if (tarro.getVidas() <= 0) {
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
        rainMusic.play();
    }

    public void destruir() {
        rainMusic.dispose();
    }

    public void pausar() {
        rainMusic.stop();
    }


}


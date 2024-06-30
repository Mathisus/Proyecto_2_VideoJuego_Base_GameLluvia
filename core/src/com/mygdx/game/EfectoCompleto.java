package com.mygdx.game;

public class EfectoCompleto implements EfectoEnemigoInterfaz {
    @Override
    public void apply(Tarro tarro) {
        tarro.sumarPuntos(10);
    }
}
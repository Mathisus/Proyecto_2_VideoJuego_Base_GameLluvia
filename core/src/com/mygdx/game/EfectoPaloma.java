package com.mygdx.game;

public class EfectoPaloma implements EfectoEnemigoInterfaz {
    @Override
    public void apply(Tarro tarro) {
        tarro.dañar();
    }
}
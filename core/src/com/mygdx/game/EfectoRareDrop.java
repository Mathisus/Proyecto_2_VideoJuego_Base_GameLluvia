package com.mygdx.game;

public class EfectoRareDrop implements EfectoEnemigoInterfaz {
    private int tipo;

    public EfectoRareDrop(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void apply(Tarro tarro) {
        if (tipo == 1) {
            tarro.sumarVidas(1);
            tarro.sumarPuntos(20);
        } else if (tipo == 2) {
            tarro.sumarVidas(2);
            tarro.sumarPuntos(50);
        } else {
            tarro.DesvanDeMiCasa();
        }
    }
}
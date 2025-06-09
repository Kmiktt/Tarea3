package org.example.logica;


public abstract class Moneda implements Comparable<Moneda>{

    public abstract int getValor();
    @Override
    public int compareTo(Moneda o) {
        if (this.getValor() > o.getValor()) {
            return 1;
        } else if (this.getValor() < o.getValor()) {
            return -1;
        } else {
            return 0;
        }
    }
}
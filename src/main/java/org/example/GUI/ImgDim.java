package org.example.GUI;

public enum ImgDim {
    BEBIDA(60,120,0),
    DULCE(80,20,70),
    EXPENDEDOR(600,720,0),
    DEPOSITO(180,160,0),
    COMPRADOR(200,400,200),
    MONEDA(35,35,0);

    private int wi;
    private int he;
    private int mdy;
    ImgDim(int w, int h, int my){
        this.wi=w;
        this.he=h;
        this.mdy=my;
    }

    public int getWi() {
        return wi;
    }
    public int getMdy() {
        return mdy;
    }
    public int getHe() {
        return he;
    }
}

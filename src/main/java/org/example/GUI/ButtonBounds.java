package org.example.GUI;

import java.awt.*;

public enum ButtonBounds {
    Fanta(30,30,160,70,220,200,20,80,0,20,50,45,70),
    Sprite(200,30,160,70,20,200,20,80,0,20,50, 210,70),
    CocaCola(365,30,160,70,20,20,20,80,250,250,250, 370,70),
    Snickers(30,110,250,50,120,80,20,90,250,250,250,40,140),
    Super8(290,110,250,50,0,0,0,90,250,250,250,300,140);
    public int rx;
    public int ry;
    public int rw;
    public int rh;
    public int rr;
    public int rgr;
    public int rbl;
    public int ral;
    public int sre;
    public int sbl;
    public int sgr;
    public int sxx;
    public int syy;
    ButtonBounds(int x, int y, int w, int h, int ra, int rg, int rb, int ralp, int sa, int sg, int sb,int sx,int sy){
        rx=x; ry=y; rw=w; rh=h;rr=ra;rbl=rb;rgr=rg;ral=ralp;sre=sa;sgr=sg;sbl=sb;sxx=sx;syy=sy;
    }
    public void dibujarOpcion(Graphics2D g2, String str){
        g2.setFont(new Font("Arial",Font.BOLD,16));
        g2.setColor(new Color(rr, rgr, rbl, ral));
        g2.fillRoundRect(rx,ry, rw,rh,10,10);
        g2.setColor(new Color(sre,sgr,sbl));
        g2.drawString(str, sxx,syy);
    }

}

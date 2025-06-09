package org.example.GUI;

import org.example.logica.Deposito;
import org.example.logica.Moneda;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**JPanel encargado de mostrar el depósito de Monedas de vuelto del expendedor*/
public class PanelMonedas extends JPanel {
    private Deposito<Moneda>dp;
    private ImgDim dims;
    private String fna ="";
    /**Constructor de PanelMonedas, guarda la dirección del Deposito y la posición del panel
     * @param d Dirección del deposito de monedas
     * @param */
    public PanelMonedas(Deposito d, int x, int y){
        super();
        dp = d;
        dims = ImgDim.MONEDA;
        this.setBackground(new Color(0,0,0,0));
        this.setBounds(x,y,100,50);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        AlphaComposite apc;
        int bs = 2;
        if (dp.getSize()<3) bs=dp.getSize()-1;
        //representa visualmente hasta 3 monedas
        for (int i=bs; i>=0; i--){
            int px =this.getX()+(20*i);
            int py = this.getY();
            apc = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(1-(0.33f*i)));
            g2.setComposite(apc);
            int v = dp.indGet(i).getValor();
            String fil = null;
            switch (v){
                case 100: fil = "src/main/resources/Moneda100.png";
                    break;
                case 500: fil = "src/main/resources/Moneda500.png";
                    break;
                case 1000: fil = "src/main/resources/Moneda1000.png";
                break;
            }
            BufferedImage img;
            try {img = ImageIO.read(new File(fil));}
            catch (IOException e) {
                e.printStackTrace();
                img = null;
            }
            g2.drawImage(img,px,py,dims.getWi(), (int)(dims.getHe()*(Math.pow(0.98,i))),null);
            if (i==0){
                fna = "Valor: $" + v;
                g2.setColor(Color.black);
                g2.fillRect(px,py+dims.getHe()*6/10,fna.length()*8,15);
                g2.setFont(new Font("Arial",Font.BOLD,10));
                g2.setColor(new Color(105,200,15));
                g2.drawString(fna, px+5,py+dims.getHe()-5);
            }
        }
        g2.setColor(Color.gray);
        g2.fillRect(this.getX(),this.getY()+dims.getHe(), fna.length()*8, 20);
        g2.setFont(new Font("Arial",Font.BOLD,12));
        g2.setColor(new Color(0,20,50));
        g2.drawString("Restantes: "+dp.getSize(),
                this.getX()+5,
                this.getY()+dims.getHe()+12);

    }
}

package org.example.GUI;

import org.example.logica.Deposito;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelDeposito extends JPanel {
    private Deposito dp;
    private BufferedImage img;
    private ImgDim dims;
    private String fna;
    public PanelDeposito(Deposito d, String fname, ImgDim di, int x, int y){
        super();
        dp = d;
        fna=fname;
        dims = di;
        try {img = ImageIO.read(new File("Tarea3/src/main/resources/"+fname));}
        catch (IOException e) {
            e.printStackTrace();
            img = null;
        }
        this.setBackground(new Color(0,0,0,0));
        this.setBounds(x,y,180,150);

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        AlphaComposite apc;
        int bs = 4;
        if (dp.getSize()<5) bs=dp.getSize()-1;
        //representa visualmente hasta 5 productos
        for (int i=bs; i>=0; i--){
                int px =this.getX()+(30*i);
                int py = this.getY()+dims.getMdy();
                apc = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (1-(0.2*i)));
                g2.setComposite(apc);
                g2.drawImage(img,px,py,dims.getWi(), (int) (dims.getHe()*(Math.pow(0.98,i))),null);
                if (i==0){
                    g2.setColor(Color.black);
                    g2.fillRect(px,py+ImgDim.BEBIDA.getHe()-30-dims.getMdy(),fna.length()*12,30);
                    g2.setFont(new Font("Arial",Font.BOLD,20));
                    g2.setColor(new Color(105,200,15));
                    g2.drawString(fna, px+5,py+ImgDim.DEPOSITO.getHe()-50-dims.getMdy());
                }
        }
        g2.setColor(Color.gray);
        g2.fillRect(this.getX(),this.getY()+ImgDim.DEPOSITO.getHe()-40, ImgDim.DEPOSITO.getWi(), 20);
        g2.setFont(new Font("Arial",Font.BOLD,16));
        g2.setColor(new Color(0,20,50));
        g2.drawString("Restantes: "+dp.getSize(),
                this.getX()+5,
                this.getY()+ImgDim.DEPOSITO.getHe()-25);

    }
}

package org.example.GUI;

import org.example.logica.Deposito;
import org.example.logica.Moneda;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelBilletera extends JPanel {
    private ArrayList<Moneda> dp;
    private ImgDim dims;
    private String fna;
    private int sel=0;
    public PanelBilletera(ArrayList d, int x, int y) {
        super();
        dp = d;
        dims = ImgDim.MONEDA;
        this.setBackground(new Color(0, 0, 0, 0));
        this.setBounds(x, y, 100, 50);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        AlphaComposite apc;
        int bs = 2;
        if (dp.size() < 15) bs = dp.size() - 1;
        //representa visualmente hasta 3 monedas
        for (int i = bs; i >= 0; i--) {
            int px = this.getX() + (100 * i);
            int py = this.getY();
            apc = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (1 - (0.1f * i)));
            g2.setComposite(apc);
            int v = dp.get(i).getValor();
            String fil = null;
            switch (v) {
                case 100:
                    fil = "src/main/resources/Moneda100.png";
                    break;
                case 500:
                    fil = "src/main/resources/Moneda500.png";
                    break;
                case 1000:
                    fil = "src/main/resources/Moneda1000.png";
                    break;
            }
            BufferedImage img;
            try {
                img = ImageIO.read(new File(fil));
            } catch (IOException e) {
                e.printStackTrace();
                img = null;
            }
            if (i==sel)
            {
                g2.drawImage(img, px, py-20, dims.getWi() * 4, (int) (dims.getHe() * 4 * (Math.pow(0.98, i))), null);
            }
            else{
                g2.drawImage(img, px, py, dims.getWi() * 4, (int) (dims.getHe() * 4 * (Math.pow(0.98, i))), null);
            }
        }
        g2.setColor(Color.gray);
        g2.setColor(new Color(0, 20, 50));
        g2.drawString("Restantes: " + dp.size(),
                this.getX() + 5,
                this.getY() + dims.getHe() + 120);

    }
    public void procesarClick(int px, int py) {
        if (px >= 200 && px <= 600 && py >= 600 && py <= 700) {
            int x = (px - 200) / 100 ;
            sel=x;
        }
    }
    public int getSel() {
        return sel;
    }
}

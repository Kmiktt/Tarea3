package org.example.GUI;

import org.example.logica.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelComprador extends JPanel {
    private BufferedImage img;
    private static Comprador c;
    public PanelComprador(){
        super();
        c = new Comprador(PanelExpendedor.getExpendedor());
        try {img = ImageIO.read(new File("src/main/resources/Comprador.png"));}
        catch (IOException e) {
            e.printStackTrace();
            img = null;
        }
        this.setBackground(new Color(220, 220, 250));

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int alt = ImgDim.COMPRADOR.getHe();
        int anc = ImgDim.COMPRADOR.getWi();
        g2.drawImage(img,(this.getWidth()/2-anc)+100,300 ,anc,alt,null);
        dibujarProductoEnMano(g2, anc, alt);
        dibujarOpciones(g2);
    }
    private void dibujarProductoEnMano(Graphics2D g2, int anc, int alt){
        Producto p = c.manoProd;
        if (p != null){
            String sabor = p.consumir();
            BufferedImage img2;
            try {img2 = ImageIO.read(new File("src/main/resources/"+sabor+".png"));}
            catch (IOException e) {
                e.printStackTrace();
                img2 = null;
            }
            if(!(sabor.equals("Super8") ||sabor.equals("Snickers"))){
                g2.drawImage(img2, (this.getWidth()/2-anc)+120,500 ,50,100,null);
            } else {
                g2.drawImage(img2, (this.getWidth()/2-anc)+100,570 ,100,40,null);
            }
        }
    }
    private void dibujarOpciones(Graphics2D g2){
        ButtonBounds.Sprite.dibujarOpcion(g2,"Comprar Sprite");
        ButtonBounds.Fanta.dibujarOpcion(g2,"Comprar Fanta");
        ButtonBounds.CocaCola.dibujarOpcion(g2,"Comprar Coca Cola");
        ButtonBounds.Snickers.dibujarOpcion(g2,"Comprar Snickers");
        ButtonBounds.Super8.dibujarOpcion(g2,"Comprar Super8");
    }
    public void procesarClick(int px, int py){
        int i = 1;
        for (ButtonBounds v : ButtonBounds.values()){
            if (px>=v.rx && px <=v.rx+v.rw && py>=v.ry && py<=v.ry+v.rh) break;
            i++;
        }
        if (i>=1 && i<=5) {
            try {
                c.ComprarBebida(0,i);
            } catch (PagoIncorrectoException e) {
                throw new RuntimeException(e);
            } catch (PagoInsuficienteException e) {
                throw new RuntimeException(e);
            } catch (NoHayProductoException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Comprador getC(){
        return c;
    }
}

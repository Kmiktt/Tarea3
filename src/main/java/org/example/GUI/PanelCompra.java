package org.example.GUI;

import org.example.logica.Deposito;
import org.example.logica.Producto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelCompra extends JPanel {
    private Producto p;
    private BufferedImage img;
    public PanelCompra (Producto d, int x, int y){
        p = d;
        this.setBackground(new Color(0,0,0,0));
        this.setBounds(x,y,300,50);

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        p = PanelExpendedor.getExpendedor().showProducto();
        String check = p.consumir();
        try {img = ImageIO.read(new File("src/main/resources/"+check+".png"));}
        catch (IOException e) {
            e.printStackTrace();
            img = null;
        }
        if(!(check.equals("Super8") ||check.equals("Snickers"))){
            double x = img.getWidth()/2.0;
            double y = img.getHeight()/2.0;
            AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(90),x,y);
            AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
            img = op.filter(img,null);
            g2.drawImage(img, this.getX(),this.getY(),100,70,null);
        } else {
            g2.drawImage(img, this.getX(),this.getY()+20,100,40,null);
    }

} }

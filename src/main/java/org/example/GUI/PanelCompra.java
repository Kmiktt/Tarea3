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

/**JPanel encargado de representar el último objeto que se compró de expendedor.*/
public class PanelCompra extends JPanel {
    private Producto p;
    private BufferedImage img;
    /**Metodo constructor de PanelCompra, guarda*/
    public PanelCompra (int x, int y){
        this.setBackground(new Color(0,0,0,0));
        this.setBounds(x,y,300,50);

    }
    /**Override de paintComponent, obtiene el producto de Expendedor usando el metodo
     * static de getExpendedor, utiliza el metodo de consumir para usar la imagen
     * correspondiente, y si es que el producto no es un Dulce, rota la imagen para que
     * se vea mejor dentro del espacio de PanelCompra*/
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        p = PanelExpendedor.getExpendedor().showProducto();
        if(p==null) return;
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

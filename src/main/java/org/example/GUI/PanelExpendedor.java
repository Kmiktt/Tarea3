package org.example.GUI;

import org.example.logica.Expendedor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**El JPanel encargado de procesar todas las interacciones del expendedor,
 * contiene paneles para cada Depósito y para el producto comprado*/
public class PanelExpendedor extends JPanel {
    private static Expendedor exp;
    private PanelDeposito pcoca;
    private PanelDeposito psprite;
    private PanelDeposito pfanta;
    private PanelDeposito psnickers;
    private PanelDeposito psuper8;
    private PanelMonedas pmonedas;
    private PanelCompra pcompra;
    private BufferedImage img;
    private ImgDim dim;
    /**Constructor del PanelExpendedor, crea a todos los PanelDeposito, al PanelMonedas
     * y PanelCompra y les asigna las coordenadas (absolutas) correspondientes. Ademas,
     * crea el expendedor que va a estar dentro del panel*/
    public PanelExpendedor() {
        super();
        dim = ImgDim.EXPENDEDOR;
        exp = new Expendedor(3);
        try {img = ImageIO.read(new File("src/main/resources/expendedor.png"));}
        catch (IOException e) {
            e.printStackTrace();
            img = null;
        }
        this.setLayout(null);
        this.setBackground(new Color(220,255,220,100));
        pcompra = new PanelCompra(exp.showProducto(),200,560);
        this.add(pcompra);
        pmonedas = new PanelMonedas(exp.getMonVuelto(),500,440);
        this.add(pmonedas);
        psprite = new PanelDeposito(exp.getSprite(), "Sprite.png", ImgDim.BEBIDA, 265, 55);
        this.add(psprite);
        pfanta = new PanelDeposito(exp.getFanta(), "Fanta.png", ImgDim.BEBIDA, 260, 210);
        this.add(pfanta);
        psnickers = new PanelDeposito(exp.getSnicker(), "Snickers.png", ImgDim.DULCE, 60, 210);
        this.add(psnickers);
        psuper8 = new PanelDeposito(exp.getSuper8(), "Super8.png", ImgDim.DULCE, 60, 365);
        this.add(psuper8);
        pcoca = new PanelDeposito(exp.getCoca(), "CocaCola.png", ImgDim.BEBIDA, 260, 365);
        this.add(pcoca);
    }
    /**Dibuja a la imagen de expendedor de fondo, y llama a todos los métodos
     * de paintComponent de todos los paneles que tiene contenidos, de modo que
     * se dibujen encima*/
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int alt = dim.getHe();
        int anc = dim.getWi();
        g2.drawImage(img,(1280/2-anc)/2,10,anc,alt,null);
        pfanta.paintComponent(g);
        psprite.paintComponent(g);
        psnickers.paintComponent(g);
        psuper8.paintComponent(g);
        pcoca.paintComponent(g);
        pmonedas.paintComponent(g);
        pcompra.paintComponent(g);
    }
    /** Metodo Estático para recibir la referencia al Expendedor creado en PanelExpendedor
     * @return Expendedor static que se crea en PanelExpendedor*/
    public static Expendedor getExpendedor(){
        return exp;
    }
}


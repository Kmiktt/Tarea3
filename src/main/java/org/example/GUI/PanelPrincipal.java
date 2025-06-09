package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

/**Encargado de contener tanto al panel de Expendedor como el de Comprador, los muestra con
 * display de Grid 1x2 para mantener las dimensiones.*/
public class PanelPrincipal extends JPanel implements MouseListener{
    private PanelExpendedor pe;
    private PanelComprador pc;
    public PanelPrincipal() {
        super();
        pe = new PanelExpendedor();
        pc = new PanelComprador();
        this.setBackground(Color.lightGray);
        this.setLayout(new GridLayout(1,2));
        this.add(pe);
        this.add(pc);
        this.addMouseListener(this);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pe.paintComponent(g);
        pe.setBounds(0,0,this.getWidth()/2,this.getHeight());
        pc.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x + " - " + y);
        if (x<this.getWidth()/2) pe.procesarClick(x,y);
        if (x>this.getWidth()/2){
            x=x/2;
            pc.procesarClick(x,y);
        }
        this.repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}

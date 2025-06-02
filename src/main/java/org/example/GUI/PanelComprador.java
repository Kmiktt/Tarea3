package org.example.GUI;

import org.example.logica.Comprador;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    public PanelComprador(){
        super();
        this.setSize(100,100);
        this.setBackground(Color.CYAN);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.yellow);
        g.drawRect(10,10,50,50);
        this.setSize(100,100);
    }
}

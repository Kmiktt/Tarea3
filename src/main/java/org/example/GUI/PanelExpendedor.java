package org.example.GUI;

import org.example.logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    Expendedor exp;
    public PanelExpendedor() {
        super();
        exp = new Expendedor(10);
        this.setSize(400,300);
        this.setBackground(new Color(100,100,100));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawRect(10,10,50,100);
        this.setSize(400,300);
    }
}

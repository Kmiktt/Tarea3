package org.example.vista;

import org.example.logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelPrincipal extends JPanel{
    private PanelComprador com;
    private PanelExpendedor exp;
    public PanelPrincipal () {
        exp = new PanelExpendedor();
        com = new PanelComprador();
        this.setBackground(Color.white);
    }
    public void paintComponent (Graphics g) {
        super.paintComponent(g); //llama al método paint al que hace override en la super clase
        // el de la super clase solo pinta el fondo (background)
        com.paintComponent(g);
        exp.paintComponent(g);
    }
}

class PanelComprador extends PanelPrincipal{
    public PanelComprador(){}
    public void paintComponent(Graphics g){
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.BLUE);
    }
}

class PanelExpendedor extends PanelPrincipal{
    public PanelExpendedor(){}
    public void paintComponent(Graphics g){
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.GREEN);
    }
}
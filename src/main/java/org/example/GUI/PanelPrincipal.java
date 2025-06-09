package org.example.GUI;

import javax.swing.*;
import java.awt.*;

/**Encargado de contener tanto al panel de Expendedor como el de Comprador, los muestra con
 * display de Grid 1x2 para mantener las dimensiones.*/
public class PanelPrincipal extends JPanel {
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
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pe.paintComponent(g);
        pe.setBounds(0,0,this.getWidth()/2,this.getHeight());

    }
}

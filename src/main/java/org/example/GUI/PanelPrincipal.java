package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelExpendedor pe;
    private PanelComprador pc;
    public PanelPrincipal() {
        super();
        this.setLayout(new BorderLayout());
        pe = new PanelExpendedor();
        pc = new PanelComprador();
        this.setSize(900,600);
        this.setBackground(Color.white);
        this.add(pe,BorderLayout.WEST);
        this.add(pc,BorderLayout.EAST);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pe.paintComponent(g);
        pc.paintComponent(g);

    }
}

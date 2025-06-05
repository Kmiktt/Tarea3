package org.example.GUI;

import javax.swing.*;
import java.awt.*;

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

    }
}

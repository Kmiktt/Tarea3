package org.example.GUI;
import javax.swing.JFrame;
import java.awt.*;

public class Ventana extends JFrame {
    private PanelPrincipal pp;
    public Ventana(){
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pp = new PanelPrincipal();
        this.add(pp);
        this.setSize(1280,800);
        this.setVisible(true);
    }
}

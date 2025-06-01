package org.example.GUI;
import javax.swing.JFrame;
import java.awt.*;

public class Ventana extends JFrame {
    private PanelPrincipal pp;
    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pp = new PanelPrincipal();
        this.add(pp,BorderLayout.CENTER);
        this.setSize(900,600);
        this.setVisible(true);
    }
}

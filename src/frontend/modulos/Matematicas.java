package frontend.modulos;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import usuarios.Estudiante;

public class Matematicas extends JPanel {
    private JFrame mainFrame;

    public Matematicas(JFrame mainFrame, Estudiante sesion){
        setPreferredSize (new Dimension (944, 569));
        setLayout (null);
    }
}

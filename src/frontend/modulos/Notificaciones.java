package frontend.modulos;

import javax.swing.JFrame;

public class Notificaciones extends JFrame {
    public Notificaciones() {
        setTitle("Ventana Estática");
        setSize(300, 200);

        setUndecorated(true);

        // Establecer posición específica (100, 100) en la pantalla
        setLocation(100, 100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
}

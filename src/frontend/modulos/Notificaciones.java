package frontend.modulos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import usuarios.Estudiante;

public class Notificaciones extends JFrame {

    private ArrayList<JLabel> mensajes = new ArrayList<>();
    private ArrayList<JLabel> titulos = new ArrayList<>();
    private JPanel panelNotificaciones;
    private JWindow fondoTransparente;

    public Notificaciones(Estudiante sesion) {        
        setTitle("");
        setSize(280, 400);

        setUndecorated(true);
        getContentPane().setBackground(new Color(100, 100, 100));
        setLocation(755, 35);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        // Configurar el layout de la ventana
        setLayout(new BorderLayout());

        // Etiqueta del título de la ventana
        JLabel tituloFrame = new JLabel("Notificaciones");
        tituloFrame.setHorizontalAlignment(SwingConstants.CENTER);
        tituloFrame.setOpaque(true);
        tituloFrame.setBackground(new Color(218, 210, 216));
        add(tituloFrame, BorderLayout.NORTH);

        panelNotificaciones = new JPanel();
        panelNotificaciones.setLayout(new GridLayout(0, 1, 0, 10)); // Layout en una columna
        add(panelNotificaciones, BorderLayout.CENTER);

        cargarNotificaciones(sesion);
        
        pack();
        setVisible(true);
    }

    private void agregarNotificacion(String title, String message) {
        // Crear un panel contenedor para cada notificación
        JPanel panelNotificacion = new JPanel(new BorderLayout());
        panelNotificacion.setBackground(new Color(227, 227, 227));
        panelNotificacion.add(Box.createVerticalStrut(20));
        
        
        // Título de la notificación
        JLabel titulo = new JLabel(title);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(237,237,237,237));
        panelNotificacion.add(titulo, BorderLayout.NORTH);

        // Mensaje de la notificación
        JLabel mensaje = new JLabel(message);
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        mensaje.setOpaque(true);
        mensaje.setBackground(new Color(227,227,227,227));
        panelNotificacion.add(mensaje, BorderLayout.CENTER);
        
        titulos.add(titulo);
        mensajes.add(mensaje);

        panelNotificaciones.add(panelNotificacion);

        revalidate();
        repaint();
    }

    private void cargarNotificaciones(Estudiante sesion) {
        String email = sesion.getCorreo();
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\almacenamiento\\data\\Enotificaciones.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                if(campos[0].equals(email)){
                    for(int i = 1;i<campos.length-1;i+=2){
                        String titulo = campos[i];
                        String mensaje = campos[i+1];
    
                        agregarNotificacion(titulo, mensaje);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontró el archivo de botones, iniciando sin botones guardados.");
        }
    }

}

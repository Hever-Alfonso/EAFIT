package frontend.modulos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import almacenamiento.AlmacenamientoME;
import recursos.MaterialEstudio;
import usuarios.Estudiante;

public class Fisica extends JPanel {
    public Matematicas(JFrame mainFrame, Estudiante sesion) {
        this.mainFrame = mainFrame;
        setPreferredSize(new Dimension(300, 500));
        setLayout(new BorderLayout());

        panelMateriales = new JPanel();
        panelMateriales.setLayout(new GridLayout(0, 1, 0, 10));
        add(panelMateriales, BorderLayout.CENTER);

        cargarMaterial(sesion);

        panelMateriales.revalidate();
        panelMateriales.repaint();
    }

    public void mostrarMaterial(MaterialEstudio material, Estudiante estudiante) {
        JPanel panelMaterial = new JPanel(new BorderLayout()); // Usar BorderLayout en lugar de FlowLayout
        panelMaterial.setPreferredSize(new Dimension(300, 100)); // Asegurarse de que tenga un tamaño visible
        ImageIcon pdfPNG = new ImageIcon("src\\frontend\\recursos\\pdf.png");
        
        JLabel titulo = new JLabel(material.getTitulo());
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(300, 30)); // Ajustar ancho

        JPanel buttonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton pdf = new JButton(material.getTema(), pdfPNG);
        pdf.setHorizontalAlignment(SwingConstants.CENTER);
        pdf.setVerticalAlignment(SwingConstants.CENTER);
        pdf.setBackground(Color.WHITE);
        pdf.setText(material.getTema());
        pdf.setHorizontalTextPosition(SwingConstants.CENTER); // Texto a la derecha del ícono
        pdf.setVerticalTextPosition(SwingConstants.CENTER);
        pdf.setPreferredSize(new Dimension(280, 70)); // Ajustar ancho
        pdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URI url = new URI(material.getEnlace());
                    Desktop.getDesktop().browse(url);

                    boolean materialUsado = AlmacenamientoME.verificarMarca(estudiante, material.getMarca());
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        panelMaterial.add(titulo, BorderLayout.NORTH); // Añadir el título en la parte superior
        buttonContainer.add(pdf); // Agregar el botón al contenedor centrado
        panelMaterial.add(buttonContainer, BorderLayout.CENTER); // Añadir el contenedor al centro del panelMaterial // Añadir el botón en el centro

        panelMateriales.add(panelMaterial);
        panelMateriales.revalidate();
        panelMateriales.repaint();
    }

    public void cargarMaterial(Estudiante estudiante) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\almacenamiento\\data\\materialestudio.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos[2].equals("Fisica")) {
                    MaterialEstudio material = new MaterialEstudio(campos[0], campos[2], campos[1], campos[4], campos[3]);
                    mostrarMaterial(material, estudiante);
                    System.out.println("Cargando material: " + material.getTitulo() + ", Tema: " + material.getTema());
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontró el archivo de botones, iniciando sin botones guardados.");
        }
    }
}

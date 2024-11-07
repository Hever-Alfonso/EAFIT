package frontend.modulos;

import java.awt.BorderLayout;
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

public class Matematicas extends JPanel {
    private JFrame mainFrame;
    private JPanel panelMateriales; // Sin static

    public Matematicas(JFrame mainFrame, Estudiante sesion) {
        this.mainFrame = mainFrame;
        setPreferredSize(new Dimension(280, 500));
        setLayout(new BorderLayout());

        panelMateriales = new JPanel();
        panelMateriales.setLayout(new GridLayout(0, 1, 0, 10));
        add(panelMateriales, BorderLayout.CENTER);

        cargarMaterial(sesion);

        panelMateriales.revalidate();
        panelMateriales.repaint();
    }

    public void mostrarMaterial(MaterialEstudio material, Estudiante estudiante) {
        ImageIcon pdfPNG = new ImageIcon("src\\frontend\\recursos\\pdf.png");
        JPanel panelMaterial = new JPanel();
        panelMaterial.setLayout(new FlowLayout(FlowLayout.LEFT)); // Layout para el panel
        panelMaterial.setPreferredSize(new Dimension(400, 50)); // Tamaño adecuado

        JLabel titulo = new JLabel(material.getTitulo());
        titulo.setHorizontalAlignment(SwingConstants.LEFT);

        JButton pdf = new JButton(material.getTema());
        pdf.setHorizontalAlignment(SwingConstants.CENTER);

        pdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URI url = new URI(material.getEnlace());
                    Desktop.getDesktop().browse(url);

                    boolean materialUsado = AlmacenamientoME.verificarMarca(estudiante, material.getMarca());

                    /* if (!materialUsado) {
                        AlmacenamientoUsuarios.actProgresoMate(estudiante);
                        jcomp10.setValue(estudiante.getProgresoMate());
                        AlmacenamientoME.recordarMaterial(estudiante, "Mate1");
                    } */

                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        panelMaterial.add(titulo);
        panelMaterial.add(pdf);

        panelMateriales.add(panelMaterial);
        panelMateriales.revalidate();
        panelMateriales.repaint();
    }

    public void cargarMaterial(Estudiante estudiante) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\almacenamiento\\data\\materialestudio.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos[2].equals("mate")) {
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

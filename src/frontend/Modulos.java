package frontend;

import almacenamiento.AlmacenamientoUsuarios;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import recursos.MaterialEstudio;
import usuarios.Estudiante;

public class Modulos extends JPanel {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JButton jcomp3;
    private JButton jcomp4;
    private JButton jcomp5;
    private JLabel jcomp6;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JProgressBar jcomp10;
    private JLabel jcomp11;
    private JLabel jcomp12;
    private JProgressBar jcomp13;
    private JLabel jcomp14;
    private JLabel jcomp15;
    private JLabel jcomp16;
    private JLabel jcomp17;
    private JLabel jcomp18;
    private JProgressBar jcomp19;
    private JLabel jcomp20;
    private JLabel jcomp21;
    private JCheckBox jcomp22;
    private JButton jcomp23;
    private JFrame mainFrame;

    private ImageIcon pdf = new ImageIcon("pdf.png"); 


    public Modulos(JFrame mainFrame, Estudiante estudiante) {
        this.mainFrame = mainFrame;

        //setear el progreso del estudiante
        estudiante.setProgresoMate(AlmacenamientoUsuarios.getProgresoMate(estudiante));
        estudiante.setProgresoProg(AlmacenamientoUsuarios.getProgresoProg(estudiante));
        estudiante.setProgresoFisica(AlmacenamientoUsuarios.getProgresoFisica(estudiante));

        //obtener email antes del arroba
        String[] divemail = estudiante.getCorreo().split("@");
        String nombreEstudiante = divemail[0];

        //construct components
        jcomp1 = new JLabel ("Bienvenido " + nombreEstudiante);
        jcomp2 = new JLabel ("Tus Modulos ->");
        jcomp3 = new JButton ("Matematicas");
        jcomp4 = new JButton ("Programacion");
        jcomp5 = new JButton ("Fisica");
        jcomp9 = new JLabel ("Tu progreso general");
        jcomp10 = new JProgressBar ();
        jcomp13 = new JProgressBar ();
        jcomp16 = new JLabel ("Matematicas");
        jcomp17 = new JLabel ("Programacion");
        jcomp18 = new JLabel ("Fisica");
        jcomp19 = new JProgressBar ();

        //set components properties
        jcomp10.setValue(estudiante.getProgresoMate());
        jcomp10.setStringPainted(true); // Muestra el porcentaje
        jcomp10.setIndeterminate(false);

        jcomp13.setValue(estudiante.getProgresoProg());
        jcomp13.setStringPainted(true); // Muestra el porcentaje
        jcomp13.setIndeterminate(false);

        jcomp19.setValue(estudiante.getProgresoFisica());
        jcomp19.setStringPainted(true); // Muestra el porcentaje
        jcomp19.setIndeterminate(false);
        

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 569));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp9);
        add (jcomp10);
        add (jcomp13);
        add (jcomp16);
        add (jcomp17);
        add (jcomp18);
        add (jcomp19);
        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (90, 90, 160, 25);
        jcomp2.setBounds (115, 150, 100, 25);
        jcomp3.setBounds (80, 215, 165, 40);
        jcomp4.setBounds (80, 275, 165, 40);
        jcomp5.setBounds (80, 335, 165, 40);
        jcomp9.setBounds (655, 190, 130, 25);
        jcomp10.setBounds (580, 260, 270, 45); //barra prog
        jcomp13.setBounds (580, 320, 270, 45); //barra mate
        jcomp16.setBounds (580, 240, 100, 25); //prog
        jcomp17.setBounds (580, 300, 100, 25);  //matematicas
        jcomp18.setBounds (580, 360, 100, 25);//fisica
        jcomp19.setBounds (580, 380, 270, 45); //barra fisica 

        //Botton cerrar sesion
        jcomp23 = new JButton("Cerrar Sesion");
        jcomp23.setForeground(Color.BLACK); // Texto en negro
        jcomp23.setBackground(Color.WHITE); // Fondo en blanco
        jcomp23.setFocusPainted(false);
        jcomp23.setBounds(795, 15, 150, 20);
        add(jcomp23);

        //logica cerrar sesion
        jcomp23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage.main(null); // Llamar el método main de LoginPage para mostrar la vista
                mainFrame.dispose();
            }
        });

        //logica modulo matematicas
        jcomp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JFrame mateModuloFrame = new JFrame("Matematicas");
                    mateModuloFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // cierra esta ventana
                    mateModuloFrame.setSize(279, 398);

                    JScrollPane scrollPane = new JScrollPane(matematicas(estudiante));
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Muestra la barra vertical si es necesaria
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // No muestra la barra horizontal

                    // Añadir el JScrollPane a la ventana
                    mateModuloFrame.add(scrollPane);
        
                    // Mostrar la ventana 
                    mateModuloFrame.setVisible(true);

            }
        });

        //logica modulo programacion
        jcomp4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JFrame mateModuloFrame = new JFrame("Programacion");
                    mateModuloFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // cierra esta ventana
                    mateModuloFrame.setSize(279, 398);

                    JScrollPane scrollPane = new JScrollPane(programacion());
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Muestra la barra vertical si es necesaria
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // No muestra la barra horizontal

                    // Añadir el JScrollPane a la ventana
                    mateModuloFrame.add(scrollPane);
        
                    // Mostrar la ventana 
                    mateModuloFrame.setVisible(true);

            }
        });


        //logica modulo fisica
        jcomp5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JFrame mateModuloFrame = new JFrame("Fisica");
                    mateModuloFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // cierra esta ventana
                    mateModuloFrame.setSize(279, 398);

                    JScrollPane scrollPane = new JScrollPane(fisica());
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Muestra la barra vertical si es necesaria
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // No muestra la barra horizontal

                    // Añadir el JScrollPane a la ventana
                    mateModuloFrame.add(scrollPane);
        
                    // Mostrar la ventana 
                    mateModuloFrame.setVisible(true);

            }
        });


    }

    private JButton jcomp30;
    private JLabel jcomp31;
    private JButton jcomp32;
    private JLabel jcomp33;

    private JPanel matematicas(Estudiante estudiante) {

        JPanel modMate = new JPanel();
        ArrayList<String> comprobarButton = new ArrayList<>();

        MaterialEstudio mate1 = new MaterialEstudio("Aprender Derivadas", "Matematicas", "Derivadas", "https://cursos.aiu.edu/Calculo%20Diferencial%20e%20Integral/PDF/Tema%204.pdf");

        //Temas
        jcomp30 = new JButton (mate1.getTema(), pdf);
        jcomp30.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
        jcomp30.setVerticalTextPosition(SwingConstants.CENTER); // Centra el texto verticalmente
        jcomp30.setText(mate1.getTema()); // Establece el texto del botón
        
        jcomp30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    URI url = new URI(mate1.getEnlace());
                    Desktop.getDesktop().browse(url);
                    

                    if(!comprobarButton.contains("Mate1")){
                        AlmacenamientoUsuarios.actProgresoMate(estudiante);
                        jcomp10.setValue(estudiante.getProgresoMate());
                        
                        comprobarButton.add("Mate1");
                    }
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }

            }
        });

        jcomp31 = new JLabel (mate1.getTitulo());


        jcomp32 = new JButton ("newButton");
        jcomp33 = new JLabel ("newLabel");

        //adjust size and set layout
        modMate.setPreferredSize (new Dimension (279, 398));
        modMate.setLayout (null);

        //add components
        modMate.add (jcomp30);
        modMate.add (jcomp31);


        modMate.add (jcomp32);
        modMate.add (jcomp33);

        //set component bounds (only needed by Absolute Positioning)
        jcomp30.setBounds (0, 25, 280, 60);
        jcomp31.setBounds (0, 0, 280, 25);
        jcomp32.setBounds (0, 110, 280, 60);
        jcomp33.setBounds (0, 85, 280, 25);

        return modMate;
    }

    private JButton progb1;
    private JLabel progt1;
    private JButton progb2;
    private JLabel progt2;

    private JPanel programacion() {

        JPanel modProg = new JPanel();

        MaterialEstudio mate1 = new MaterialEstudio("Aprender Derivadas", "Matematicas", "Derivadas", "https://cursos.aiu.edu/Calculo%20Diferencial%20e%20Integral/PDF/Tema%204.pdf");

        //Temas
        progb1 = new JButton (mate1.getTema(), pdf);
        progb1.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
        progb1.setVerticalTextPosition(SwingConstants.CENTER); // Centra el texto verticalmente
        progb1.setText(mate1.getTema()); // Establece el texto del botón

        progt1 = new JLabel (mate1.getTitulo());


        progb2 = new JButton ("newButton");
        progt2 = new JLabel ("newLabel");

        //adjust size and set layout
        modProg.setPreferredSize (new Dimension (279, 398));
        modProg.setLayout (null);

        //add components
        modProg.add (progb1);
        modProg.add (progt1);


        modProg.add (progb2);
        modProg.add (progb2);

        //set component bounds (only needed by Absolute Positioning)
        progb1.setBounds (0, 25, 280, 60);
        progt1.setBounds (0, 0, 280, 25);
        progb2.setBounds (0, 110, 280, 60);
        progt2.setBounds (0, 85, 280, 25);

        return modProg;
    }

    private JButton fisicb1;
    private JLabel fisict1;
    private JButton fisicb2;
    private JLabel fisict2;

    private JPanel fisica() {

        JPanel modFisic = new JPanel();

        MaterialEstudio mate1 = new MaterialEstudio("Aprender Derivadas", "Matematicas", "Derivadas", "https://cursos.aiu.edu/Calculo%20Diferencial%20e%20Integral/PDF/Tema%204.pdf");

        //Temas
        fisicb1 = new JButton (mate1.getTema(), pdf);
        fisicb1.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
        fisicb1.setVerticalTextPosition(SwingConstants.CENTER); // Centra el texto verticalmente
        fisicb1.setText(mate1.getTema()); // Establece el texto del botón

        fisict1 = new JLabel (mate1.getTitulo());


        fisicb2 = new JButton ("newButton");
        fisict2 = new JLabel ("newLabel");

        //adjust size and set layout
        modFisic.setPreferredSize (new Dimension (279, 398));
        modFisic.setLayout (null);

        //add components
        modFisic.add (fisicb1);
        modFisic.add (fisict1);


        modFisic.add (fisicb2);
        modFisic.add (fisicb2);

        //set component bounds (only needed by Absolute Positioning)
        progb1.setBounds (0, 25, 280, 60);
        progt1.setBounds (0, 0, 280, 25);
        progb2.setBounds (0, 110, 280, 60);
        progt2.setBounds (0, 85, 280, 25);

        return modFisic;
    }

}
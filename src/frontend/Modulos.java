package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import almacenamiento.AlmacenamientoUsuarios;
import frontend.modulos.Fisica;
import frontend.modulos.Matematicas;
import frontend.modulos.Notificaciones;
import frontend.modulos.Programacion;
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
    private JProgressBar barraMate;
    private JLabel jcomp11;
    private JLabel jcomp12;
    private JProgressBar barraProg;
    private JLabel jcomp14;
    private JLabel jcomp15;
    private JLabel jcomp16;
    private JLabel jcomp17;
    private JLabel jcomp18;
    private JProgressBar barraFisica;
    private JLabel jcomp20;
    private JLabel jcomp21;
    private JCheckBox jcomp22;
    private JButton jcomp23;
    private JFrame mainFrame;
    private JButton notificaciones;

    private ImageIcon pdf = new ImageIcon("src\\frontend\\recursos\\pdf.png");
    private ImageIcon campana = new ImageIcon("src\\frontend\\recursos\\campana.png");  


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
        barraMate = new JProgressBar ();
        barraProg = new JProgressBar ();
        jcomp16 = new JLabel ("Matematicas");
        jcomp17 = new JLabel ("Programacion");
        jcomp18 = new JLabel ("Fisica");
        barraFisica = new JProgressBar ();

        notificaciones = new JButton("N", campana);

        //set components properties
        barraMate.setValue(estudiante.getProgresoMate());
        barraMate.setStringPainted(true); // Muestra el porcentaje
        barraMate.setIndeterminate(false);

        barraProg.setValue(estudiante.getProgresoProg());
        barraProg.setStringPainted(true); // Muestra el porcentaje
        barraProg.setIndeterminate(false);

        barraFisica.setValue(estudiante.getProgresoFisica());
        barraFisica.setStringPainted(true); // Muestra el porcentaje
        barraFisica.setIndeterminate(false);
        

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
        add (barraMate);
        add (barraProg);
        add (jcomp16);
        add (jcomp17);
        add (jcomp18);
        add (barraFisica);
        add (notificaciones);
        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (90, 90, 160, 25);
        jcomp2.setBounds (115, 150, 100, 25);
        jcomp3.setBounds (80, 215, 165, 40);
        jcomp4.setBounds (80, 275, 165, 40);
        jcomp5.setBounds (80, 335, 165, 40);
        jcomp9.setBounds (655, 190, 130, 25);
        barraMate.setBounds (580, 260, 270, 45); //barra prog
        barraProg.setBounds (580, 320, 270, 45); //barra mate
        jcomp16.setBounds (580, 240, 100, 25); //prog
        jcomp17.setBounds (580, 300, 100, 25);  //matematicas
        jcomp18.setBounds (580, 360, 100, 25);//fisica
        barraFisica.setBounds (580, 380, 270, 45); //barra fisica 

        notificaciones.setBounds(705, 15, 40, 20);
        notificaciones.setBackground(new Color(0, 0, 0, 0));

        //Botton cerrar sesion
        jcomp23 = new JButton("Cerrar Sesion");
        jcomp23.setForeground(Color.BLACK); // Texto en negro
        jcomp23.setBackground(Color.WHITE); // Fondo en blanco
        jcomp23.setFocusPainted(false);
        jcomp23.setBounds(755, 15, 150, 20);
        add(jcomp23);

        Notificaciones notiPanel = new Notificaciones(estudiante);

        notificaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!notiPanel.isVisible()) {
                    notiPanel.setVisible(true);
                } else {
                    // Alterna la visibilidad
                    notiPanel.setVisible(!notiPanel.isVisible());
                }
            
            }

            
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (notiPanel.isVisible()) {
                    notiPanel.dispose();
                } 
            
            }
        });


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
                mateModuloFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                // Crear el panel de matemáticas
                Matematicas mate = new Matematicas(mateModuloFrame, estudiante, barraMate);
                
                // Crear JScrollPane y configurar la barra de desplazamiento
                JScrollPane scrollPane = new JScrollPane(mate);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                
                // Añadir el JScrollPane a la ventana
                mateModuloFrame.add(scrollPane);
                
                // Ajustar el tamaño del JFrame automáticamente o configurar un tamaño específico
                mateModuloFrame.pack(); // Ajusta al tamaño preferido
                mateModuloFrame.setVisible(true);
                

            }
        });

        //logica modulo programacion
        jcomp4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mateModuloFrame = new JFrame("Fisica");
                mateModuloFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                // Crear el panel de matemáticas
                Programacion mate = new Programacion(mateModuloFrame, estudiante, barraProg);
                
                // Crear JScrollPane y configurar la barra de desplazamiento
                JScrollPane scrollPane = new JScrollPane(mate);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                
                // Añadir el JScrollPane a la ventana
                mateModuloFrame.add(scrollPane);
                
                // Ajustar el tamaño del JFrame automáticamente o configurar un tamaño específico
                mateModuloFrame.pack(); // Ajusta al tamaño preferido
                mateModuloFrame.setVisible(true);
            }
        });


        //logica modulo fisica
        jcomp5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mateModuloFrame = new JFrame("Fisica");
                mateModuloFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                // Crear el panel de matemáticas
                Fisica mate = new Fisica(mateModuloFrame, estudiante, barraFisica);
                
                // Crear JScrollPane y configurar la barra de desplazamiento
                JScrollPane scrollPane = new JScrollPane(mate);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                
                // Añadir el JScrollPane a la ventana
                mateModuloFrame.add(scrollPane);
                
                // Ajustar el tamaño del JFrame automáticamente o configurar un tamaño específico
                mateModuloFrame.pack(); // Ajusta al tamaño preferido
                mateModuloFrame.setVisible(true);
            }
        });


    }
}
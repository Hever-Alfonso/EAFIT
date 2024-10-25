package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

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
    private JSlider jcomp10;
    private JLabel jcomp11;
    private JLabel jcomp12;
    private JSlider jcomp13;
    private JLabel jcomp14;
    private JLabel jcomp15;
    private JLabel jcomp16;
    private JLabel jcomp17;
    private JLabel jcomp18;
    private JSlider jcomp19;
    private JLabel jcomp20;
    private JLabel jcomp21;
    private JCheckBox jcomp22;
    private JButton jcomp23;
    private JFrame mainFrame;

    public Modulos(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        //construct components
        jcomp1 = new JLabel ("Bienvenido (x)");
        jcomp2 = new JLabel ("Tus Modulos ->");
        jcomp3 = new JButton ("Programacion");
        jcomp4 = new JButton ("Matematicas");
        jcomp5 = new JButton ("Fisica");
        jcomp6 = new JLabel ("https://www.ejemplo");
        jcomp7 = new JLabel ("https://www.ejemplo");
        jcomp8 = new JLabel ("https://www.ejemplo");
        jcomp9 = new JLabel ("Tu progreso general");
        jcomp10 = new JSlider (1, 100);
        jcomp11 = new JLabel ("0");
        jcomp12 = new JLabel ("100");
        jcomp13 = new JSlider (0, 45);
        jcomp14 = new JLabel ("0");
        jcomp15 = new JLabel ("100");
        jcomp16 = new JLabel ("Porgramacion");
        jcomp17 = new JLabel ("Matematicas");
        jcomp18 = new JLabel ("Fisica");
        jcomp19 = new JSlider (0, 20);
        jcomp20 = new JLabel ("0");
        jcomp21 = new JLabel ("100");
        jcomp22 = new JCheckBox ("Recordatorios");

        //set components properties
        jcomp10.setOrientation (JSlider.HORIZONTAL);
        jcomp10.setMinorTickSpacing (0);
        jcomp10.setMajorTickSpacing (11);
        jcomp10.setPaintTicks (true);
        jcomp10.setPaintLabels (false);
        jcomp13.setOrientation (JSlider.HORIZONTAL);
        jcomp13.setMinorTickSpacing (5);
        jcomp13.setMajorTickSpacing (10);
        jcomp13.setPaintTicks (true);
        jcomp13.setPaintLabels (false);
        jcomp19.setOrientation (JSlider.HORIZONTAL);
        jcomp19.setMinorTickSpacing (3);
        jcomp19.setMajorTickSpacing (10);
        jcomp19.setPaintTicks (true);
        jcomp19.setPaintLabels (false);

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 569));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);
        add (jcomp9);
        add (jcomp10);
        add (jcomp11);
        add (jcomp12);
        add (jcomp13);
        add (jcomp14);
        add (jcomp15);
        add (jcomp16);
        add (jcomp17);
        add (jcomp18);
        add (jcomp19);
        add (jcomp20);
        add (jcomp21);
        add (jcomp22);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (90, 90, 100, 25);
        jcomp2.setBounds (115, 150, 100, 25);
        jcomp3.setBounds (80, 215, 165, 40);
        jcomp4.setBounds (80, 275, 165, 40);
        jcomp5.setBounds (80, 335, 165, 40);
        jcomp6.setBounds (255, 225, 130, 20);
        jcomp7.setBounds (255, 283, 150, 25);
        jcomp8.setBounds (255, 345, 125, 25);
        jcomp9.setBounds (655, 190, 130, 25);
        jcomp10.setBounds (575, 260, 280, 40);
        jcomp11.setBounds (560, 262, 100, 24);
        jcomp12.setBounds (855, 262, 100, 25);
        jcomp13.setBounds (580, 315, 270, 45);
        jcomp14.setBounds (560, 320, 100, 25);
        jcomp15.setBounds (855, 318, 100, 25);
        jcomp16.setBounds (580, 240, 100, 25);
        jcomp17.setBounds (580, 295, 100, 25);
        jcomp18.setBounds (580, 360, 100, 25);
        jcomp19.setBounds (580, 380, 270, 40);
        jcomp20.setBounds (565, 380, 100, 25);
        jcomp21.setBounds (855, 382, 100, 25);
        jcomp22.setBounds (805, 15, 150, 20);

        //Botton cerrar sesion
        jcomp23 = new JButton("Cerrar Sesion");
        jcomp23.setForeground(Color.BLACK); // Texto en negro
        jcomp23.setBackground(Color.WHITE); // Fondo en blanco
        jcomp23.setFocusPainted(false);
        jcomp23.setBounds(100, 470, 200, 50);
        add(jcomp23);

        //logica cerrar sesion
        jcomp23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage.main(null); // Llamar el método main de LoginPage para mostrar la vista
                mainFrame.dispose();
            }
        });

    }

}
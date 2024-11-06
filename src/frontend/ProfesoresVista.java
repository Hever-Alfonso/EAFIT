package frontend;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import usuarios.AsesorAcademico;

public class ProfesoresVista extends JPanel{
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JButton jcomp3;
    private JButton jcomp4;
    private JButton jcomp5;
    private JLabel jcomp6;
    private JList jcomp7;
    private JButton jcomp8;
    private JFrame mainFrame;

    public ProfesoresVista(JFrame mainFrame, AsesorAcademico sesion) {
        this.mainFrame = mainFrame;
        //construct preComponents
        String[] jcomp7Items = {"Tomas", "Juan", "Hever", "Isabella", "Samuel", "Matias", "Santiago", "Sofia", "Martin", "Juanita", "Sara", "Felipe", "Julian", "David", "Angela", "Oscar"};

        //construct components
        jcomp1 = new JLabel ("Bienvenido Profesor");
        jcomp2 = new JLabel ("Tus Modulos ->");
        jcomp3 = new JButton ("Programacion");
        jcomp4 = new JButton ("Matematicas");
        jcomp5 = new JButton ("Fisica");
        jcomp6 = new JLabel ("Lista de tus estudiantes");
        jcomp7 = new JList (jcomp7Items);
        jcomp8 = new JButton ("Cerrar Sesion");

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

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (395, 80, 125, 20);
        jcomp2.setBounds (115, 150, 100, 25);
        jcomp3.setBounds (80, 215, 165, 40);
        jcomp4.setBounds (80, 275, 165, 40);
        jcomp5.setBounds (80, 335, 165, 40);
        jcomp6.setBounds (615, 155, 170, 25);
        jcomp7.setBounds (655, 200, 75, 165);
        jcomp8.setBounds (15, 10, 135, 20);
    }

}

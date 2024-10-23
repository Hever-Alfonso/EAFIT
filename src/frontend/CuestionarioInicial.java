package frontend;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CuestionarioInicial extends JPanel {
    private JLabel jcomp1;
    private JRadioButton jcomp2;
    private JRadioButton jcomp3;
    private JRadioButton jcomp4;
    private JLabel jcomp5;
    private JLabel jcomp6;
    private JRadioButton jcomp7;
    private JRadioButton jcomp8;
    private JRadioButton jcomp9;
    private JLabel jcomp10;
    private JRadioButton jcomp11;
    private JRadioButton jcomp12;
    private JRadioButton jcomp13;
    private JLabel jcomp14;
    private JLabel jcomp15;
    private JLabel jcomp16;
    private JLabel jcomp17;
    private JRadioButton jcomp18;
    private JRadioButton jcomp19;
    private JRadioButton jcomp20;
    private JLabel jcomp21;
    private JLabel jcomp22;
    private JLabel jcomp23;
    private JLabel jcomp24;
    private JRadioButton jcomp25;
    private JRadioButton jcomp26;
    private JRadioButton jcomp27;
    private JLabel jcomp28;
    private JLabel jcomp29;
    private JLabel jcomp30;
    private JLabel jcomp31;
    private JRadioButton jcomp32;
    private JRadioButton jcomp33;
    private JRadioButton jcomp34;

    public CuestionarioInicial() {
        //construct components
        jcomp1 = new JLabel ("Matematicas");
        jcomp2 = new JRadioButton ("2xe^(x^2}");
        jcomp3 = new JRadioButton ("(x^2}e^{x^2)");
        jcomp4 = new JRadioButton ("e^{x^2}");
        jcomp5 = new JLabel ("1. (Cálculo Diferencial): ¿Cuál es la derivada de f(x) = e^(x^2) con respecto a x? ");
        jcomp6 = new JLabel (" 2. (Cálculo Integral): ¿Cuál es el valor de la integral definida de 0 a 1 de j(2x+1)dx? ");
        jcomp7 = new JRadioButton ("2");
        jcomp8 = new JRadioButton ("1.5");
        jcomp9 = new JRadioButton ("1");
        jcomp10 = new JLabel ("3. (Algebra Lineal y Vectorial): ¿Cuál es el determinante de la matriz 2×2 (1 2 3 4)?");
        jcomp11 = new JRadioButton ("-2");
        jcomp12 = new JRadioButton ("0");
        jcomp13 = new JRadioButton ("2");
        jcomp14 = new JLabel ("Programacion");
        jcomp15 = new JLabel ("1. (Python): ¿Cuál es la salida del siguiente código en Python? ");
        jcomp16 = new JLabel ("lista = [1, 2, 3, 4, 5]");
        jcomp17 = new JLabel ("print(lista[1:4])");
        jcomp18 = new JRadioButton (" [2, 3, 4]");
        jcomp19 = new JRadioButton (" [1, 2, 3]");
        jcomp20 = new JRadioButton (" [2,3]");
        jcomp21 = new JLabel ("2. (Java): ¿Qué imprime el siguiente código en Java? ");
        jcomp22 = new JLabel ("int x = 5; ");
        jcomp23 = new JLabel ("int y = 10;");
        jcomp24 = new JLabel ("System.out.printin(x > y? Mayor : Menor); ");
        jcomp25 = new JRadioButton ("Mayor");
        jcomp26 = new JRadioButton ("Menor");
        jcomp27 = new JRadioButton ("Error de compilacion");
        jcomp28 = new JLabel ("3. (C++): ¿Cuál es la salida del siguiente código en C++?");
        jcomp29 = new JLabel (" int a = 3; ");
        jcomp30 = new JLabel ("int b = 4;");
        jcomp31 = new JLabel ("std::cout << a + b * 2 << std::endl;  ");
        jcomp32 = new JRadioButton ("14");
        jcomp33 = new JRadioButton ("11");
        jcomp34 = new JRadioButton ("10");

        //adjust size and set layout
        setPreferredSize (new Dimension (1060, 870));
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
        add (jcomp23);
        add (jcomp24);
        add (jcomp25);
        add (jcomp26);
        add (jcomp27);
        add (jcomp28);
        add (jcomp29);
        add (jcomp30);
        add (jcomp31);
        add (jcomp32);
        add (jcomp33);
        add (jcomp34);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (50, 40, 100, 25);
        jcomp2.setBounds (45, 90, 90, 20);
        jcomp3.setBounds (45, 110, 100, 20);
        jcomp4.setBounds (45, 125, 80, 25);
        jcomp5.setBounds (50, 65, 460, 25);
        jcomp6.setBounds (45, 155, 470, 25);
        jcomp7.setBounds (45, 180, 45, 25);
        jcomp8.setBounds (45, 200, 50, 25);
        jcomp9.setBounds (45, 220, 45, 25);
        jcomp10.setBounds (45, 245, 470, 25);
        jcomp11.setBounds (45, 270, 100, 25);
        jcomp12.setBounds (45, 290, 100, 25);
        jcomp13.setBounds (45, 310, 100, 25);
        jcomp14.setBounds (45, 365, 100, 25);
        jcomp15.setBounds (45, 385, 360, 30);
        jcomp16.setBounds (45, 405, 110, 25);
        jcomp17.setBounds (45, 420, 90, 25);
        jcomp18.setBounds (40, 445, 100, 25);
        jcomp19.setBounds (40, 465, 100, 25);
        jcomp20.setBounds (40, 485, 100, 25);
        jcomp21.setBounds (45, 525, 310, 25);
        jcomp22.setBounds (45, 545, 100, 25);
        jcomp23.setBounds (45, 560, 100, 25);
        jcomp24.setBounds (43, 580, 259, 25);
        jcomp25.setBounds (40, 605, 100, 25);
        jcomp26.setBounds (40, 625, 100, 25);
        jcomp27.setBounds (40, 645, 150, 25);
        jcomp28.setBounds (45, 690, 320, 20);
        jcomp29.setBounds (45, 705, 100, 25);
        jcomp30.setBounds (45, 725, 100, 25);
        jcomp31.setBounds (45, 745, 195, 25);
        jcomp32.setBounds (40, 770, 100, 25);
        jcomp33.setBounds (40, 790, 100, 25);
        jcomp34.setBounds (40, 810, 100, 25);
    }
}

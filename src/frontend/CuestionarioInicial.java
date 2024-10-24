package frontend;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class CuestionarioInicial extends JPanel {
    // Textos de introducción
    private JLabel jcomp35, jcomp36, jcomp37, jcomp38, jcomp39;

    // Componentes para Matemáticas
    private JLabel jcomp1, jcomp5, jcomp6,jcomp10;

    JRadioButton jcomp3;

    // Componentes para Programación
    private JLabel jcomp14, jcomp15, jcomp16, jcomp17,jcomp21, jcomp22, jcomp23, jcomp24,jcomp28, jcomp29, jcomp30, jcomp31;

    JRadioButton jcomp18,jcomp2, jcomp4, jcomp7, jcomp8, jcomp9, jcomp11,jcomp12,jcomp13,jcomp19,jcomp20,jcomp25,jcomp26,jcomp27,jcomp32,jcomp33,jcomp34,jcomp41,jcomp42,jcomp43,jcomp46,jcomp47,jcomp48,jcomp50,jcomp51,jcomp52;

    JLabel jcomp44;

    JLabel jcomp40;

    // Componentes para Física
    private JLabel jcomp45,jcomp49;

    public CuestionarioInicial() {
        // Inicializar componentes
        initLabels();
        
        // Configuración del panel y desplazamiento
        setPreferredSize(new Dimension(1500, 1700));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Añadir componentes al panel
        add(createIntroPanel());
        add(createMathPanel());
        add(createProgrammingPanel());
        add(createPhysicsPanel());
    }

    private void initLabels() {
        // Textos de introducción
        jcomp35 = new JLabel("Cuestionario Inicial: La ingeniería, un mundo de ciencias");
        jcomp36 = new JLabel("Bienvenido/a. Si estás aquí es porque decidiste que deseas reforzar esos conceptos clave para el estudio de cualquier enfoque de la ingeniería.");
        jcomp37 = new JLabel("Antes que todo, deseamos que identifiques por tu cuenta en cuáles de las bases de la ingeniería, tales como física, matemáticas y ciencias de la computación,");
        jcomp38 = new JLabel("se encuentran tus mayores falencias. Para ello, hemos diseñado un cuestionario con 3 secciones de las bases mencionadas anteriormente,");
        jcomp39 = new JLabel("cada sección conformada por 3 preguntas de nivel avanzado. Posteriormente, podrás ver el resultado de tu prueba y decidir en qué orden quieres enfocarte.");

        // Componentes para Matemáticas
        jcomp1 = new JLabel("Matemáticas");
        jcomp5 = new JLabel("1. (Cálculo Diferencial): ¿Cuál es la derivada de f(x) = e^(x^2) con respecto a x?");
        jcomp2 = new JRadioButton("2xe^(x^2)");
        jcomp3 = new JRadioButton("(x^2)e^(x^2)");
        jcomp4 = new JRadioButton("e^(x^2)");
        jcomp6 = new JLabel("2. (Cálculo Integral): ¿Cuál es el valor de la integral definida de 0 a 1 de j(2x+1)dx?");
        jcomp7 = new JRadioButton("2");
        jcomp8 = new JRadioButton("1.5");
        jcomp9 = new JRadioButton("1");
        jcomp10 = new JLabel("3. (Álgebra Lineal y Vectorial): ¿Cuál es el determinante de la matriz 2×2 (1 2 3 4)?");
        jcomp11 = new JRadioButton("-2");
        jcomp12 = new JRadioButton("0");
        jcomp13 = new JRadioButton("2");

        // Componentes para Programación
        jcomp14 = new JLabel("Programación");
        jcomp15 = new JLabel("1. (Python): ¿Cuál es la salida del siguiente código en Python?");
        jcomp16 = new JLabel("lista = [1, 2, 3, 4, 5]");
        jcomp17 = new JLabel("print(lista[1:4])");
        jcomp18 = new JRadioButton("[2, 3, 4]");
        jcomp19 = new JRadioButton("[1, 2, 3]");
        jcomp20 = new JRadioButton("[2, 3]");
        jcomp21 = new JLabel("2. (Java): ¿Qué imprime el siguiente código en Java?");
        jcomp22 = new JLabel("int x = 5;");
        jcomp23 = new JLabel("int y = 10;");
        jcomp24 = new JLabel("System.out.println(x > y ? \"Mayor\" : \"Menor\");");
        jcomp25 = new JRadioButton("Mayor");
        jcomp26 = new JRadioButton("Menor");
        jcomp27 = new JRadioButton("Error de compilación");
        jcomp28 = new JLabel("3. (C++): ¿Cuál es la salida del siguiente código en C++?");
        jcomp29 = new JLabel("int a = 3;");
        jcomp30 = new JLabel("int b = 4;");
        jcomp31 = new JLabel("std::cout << a + b * 2 << std::endl;");
        jcomp32 = new JRadioButton("14");
        jcomp33 = new JRadioButton("11");
        jcomp34 = new JRadioButton("10");

        // Componentes para Física
        jcomp40 = new JLabel("Física");
        jcomp44 = new JLabel("1. ¿Cuál es el principio de incertidumbre de Heisenberg?");
        jcomp41 = new JRadioButton("Es imposible conocer simultáneamente la posición exacta y el momento exacto de una partícula.");
        jcomp42 = new JRadioButton("La energía de un sistema cuántico se conserva a lo largo del tiempo.");
        jcomp43 = new JRadioButton("La aceleración de una partícula es proporcional a la fuerza aplicada.");
        jcomp45 = new JLabel("2. ¿Qué es una singularidad en el contexto de la relatividad general?");
        jcomp46 = new JRadioButton("Un punto en el espacio-tiempo donde la densidad de materia es infinita.");
        jcomp47 = new JRadioButton("Un lugar donde la gravedad es nula.");
        jcomp48 = new JRadioButton("Un punto en el espacio-tiempo donde la velocidad de la luz es infinita.");
        jcomp49 = new JLabel("3. ¿Cuál es la ecuación que describe el efecto fotoeléctrico según Einstein?");
        jcomp50 = new JRadioButton("E = mc^2");
        jcomp51 = new JRadioButton("E = hf - Φ");
        jcomp52 = new JRadioButton("E = (1/2)mv^2");
    }

    private JPanel createIntroPanel() {
        JPanel introPanel = new JPanel();
        introPanel.setLayout(new BoxLayout(introPanel, BoxLayout.Y_AXIS));
        introPanel.add(jcomp35);
        introPanel.add(Box.createVerticalStrut(20));
        introPanel.add(jcomp36);
        introPanel.add(jcomp37);
        introPanel.add(jcomp38);
        introPanel.add(jcomp39);
        introPanel.setBorder(new EmptyBorder(new Insets(20, 40, 20, 20))); // Añadir espacio interior
        return introPanel;
    }

    private JPanel createMathPanel() {
        JPanel mathPanel = new JPanel();
        mathPanel.setLayout(new BoxLayout(mathPanel, BoxLayout.Y_AXIS));
        mathPanel.add(jcomp1);
        mathPanel.add(Box.createVerticalStrut(20));
        mathPanel.add(jcomp5);
        mathPanel.add(jcomp2);
        mathPanel.add(jcomp3);
        mathPanel.add(jcomp4);
        mathPanel.add(Box.createVerticalStrut(20));
        mathPanel.add(jcomp6);
        mathPanel.add(jcomp7);
        mathPanel.add(jcomp8);
        mathPanel.add(jcomp9);
        mathPanel.add(Box.createVerticalStrut(20));
        mathPanel.add(jcomp10);
        mathPanel.add(jcomp11);
        mathPanel.add(jcomp12);
        mathPanel.add(jcomp13);
        mathPanel.setBorder(new EmptyBorder(new Insets(20, 40, 20, 20))); // Añadir espacio interior
        return mathPanel;
    }

    private JPanel createProgrammingPanel() {
        JPanel programmingPanel = new JPanel();
        programmingPanel.setLayout(new BoxLayout(programmingPanel, BoxLayout.Y_AXIS));
        programmingPanel.add(jcomp14);
        programmingPanel.add(Box.createVerticalStrut(20));
        programmingPanel.add(jcomp15);
        programmingPanel.add(jcomp16);
        programmingPanel.add(jcomp17);
        programmingPanel.add(jcomp18);
        programmingPanel.add(jcomp19);
        programmingPanel.add(jcomp20);
        programmingPanel.add(Box.createVerticalStrut(20));
        programmingPanel.add(jcomp21);
        programmingPanel.add(jcomp22);
        programmingPanel.add(jcomp23);
        programmingPanel.add(jcomp24);
        programmingPanel.add(jcomp25);
        programmingPanel.add(jcomp26);
        programmingPanel.add(jcomp27);
        programmingPanel.add(Box.createVerticalStrut(20));
        programmingPanel.add(jcomp28);
        programmingPanel.add(jcomp29);
        programmingPanel.add(jcomp30);
        programmingPanel.add(jcomp31);
        programmingPanel.add(jcomp32);
        programmingPanel.add(jcomp33);
        programmingPanel.add(jcomp34);
        programmingPanel.setBorder(new EmptyBorder(new Insets(20, 40, 20, 20))); // Añadir espacio interior
        return programmingPanel;
    }

    private JPanel createPhysicsPanel() {
        JPanel physicsPanel = new JPanel();
        physicsPanel.setLayout(new BoxLayout(physicsPanel, BoxLayout.Y_AXIS));
        physicsPanel.add(jcomp40);
        physicsPanel.add(Box.createVerticalStrut(20));
        physicsPanel.add(jcomp44);
        physicsPanel.add(jcomp41);
        physicsPanel.add(jcomp42);
        physicsPanel.add(jcomp43);
        physicsPanel.add(Box.createVerticalStrut(20));
        physicsPanel.add(jcomp45);
        physicsPanel.add(jcomp46);
        physicsPanel.add(jcomp47);
        physicsPanel.add(jcomp48);
        physicsPanel.add(Box.createVerticalStrut(20));
        physicsPanel.add(jcomp49);
        physicsPanel.add(jcomp50);
        physicsPanel.add(jcomp51);
        physicsPanel.add(jcomp52);
        physicsPanel.setBorder(new EmptyBorder(new Insets(20, 40, 20, 20))); // Añadir espacio interior
        return physicsPanel;
    }
}

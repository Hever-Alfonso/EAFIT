package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private JLabel jcomp14, jcomp15, jcomp16, jcomp17,jcomp21, jcomp22, jcomp23;

    private static JLabel jcomp24;

    private JLabel jcomp28;

    private JLabel jcomp29;

    private JLabel jcomp30;

    private JLabel jcomp31;

    JRadioButton jcomp18;

    static JRadioButton jcomp2;

    JRadioButton jcomp4;

    static JRadioButton jcomp7;

    JRadioButton jcomp8;

    JRadioButton jcomp9;

    static JRadioButton jcomp11;

    JRadioButton jcomp12;

    JRadioButton jcomp13;

    JRadioButton jcomp19;

    static JRadioButton jcomp20;

    static JRadioButton jcomp25;

    JRadioButton jcomp26;

    JRadioButton jcomp27;

    JRadioButton jcomp32;

    JRadioButton jcomp33;

    static JRadioButton jcomp34;

    static JRadioButton jcomp41;

    JRadioButton jcomp42;

    JRadioButton jcomp43;

    static JRadioButton jcomp46;

    JRadioButton jcomp47;

    JRadioButton jcomp48;

    JRadioButton jcomp50;

    static JRadioButton jcomp51;

    JRadioButton jcomp52;

    JLabel jcomp44;

    JLabel jcomp40;

    JButton finishTest;

    // Componentes para Física
    private JLabel jcomp45,jcomp49;
    
    //Grupo de la opsciones de respuestas
    static ButtonGroup mateRespuestas1 = new ButtonGroup();
    static ButtonGroup mateRespuestas2 = new ButtonGroup();
    static ButtonGroup mateRespuestas3 = new ButtonGroup();

    static ButtonGroup progRespuestas1 = new ButtonGroup();
    static ButtonGroup progRespuestas2 = new ButtonGroup();
    static ButtonGroup progRespuestas3 = new ButtonGroup();

    static ButtonGroup fisicaRespuestas1 = new ButtonGroup();
    static ButtonGroup fisicaRespuestas2 = new ButtonGroup();
    static ButtonGroup fisicaRespuestas3 = new ButtonGroup();

    //arreglo con todos los grupos para optimizar if
    static ButtonGroup[] grupos = {mateRespuestas1,mateRespuestas2,mateRespuestas3,progRespuestas1,progRespuestas2,progRespuestas3,fisicaRespuestas1,fisicaRespuestas2,fisicaRespuestas3};

    private JFrame mainFrame;

    public CuestionarioInicial() {
        // Inicializar componentes
        this.mainFrame = mainFrame;
        initLabels();
        
        // Configuración del panel y desplazamiento
        setPreferredSize(new Dimension(1500, 1600));
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
        jcomp34 = new JRadioButton("12");

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
        

        //AGRUPAR RESPUESTAS DE PREGUNTAS
        //grupos para preguntas de matematicas
        
        mateRespuestas1.add(jcomp2);
        mateRespuestas1.add(jcomp3);
        mateRespuestas1.add(jcomp4);

        mateRespuestas2.add(jcomp7);
        mateRespuestas2.add(jcomp8);
        mateRespuestas2.add(jcomp9);

        mateRespuestas3.add(jcomp11);
        mateRespuestas3.add(jcomp12);
        mateRespuestas3.add(jcomp13);

        //grupos para preguntas de programacion
        
        progRespuestas1.add(jcomp18);
        progRespuestas1.add(jcomp19);
        progRespuestas1.add(jcomp20);

        progRespuestas2.add(jcomp25);
        progRespuestas2.add(jcomp26);
        progRespuestas2.add(jcomp27);

        progRespuestas3.add(jcomp32);
        progRespuestas3.add(jcomp33);
        progRespuestas3.add(jcomp34);

        //grupos para preguntas de fisica
        
        fisicaRespuestas1.add(jcomp41);
        fisicaRespuestas1.add(jcomp42);
        fisicaRespuestas1.add(jcomp43);

        fisicaRespuestas2.add(jcomp46);
        fisicaRespuestas2.add(jcomp47);
        fisicaRespuestas2.add(jcomp48);

        fisicaRespuestas3.add(jcomp50);
        fisicaRespuestas3.add(jcomp51);
        fisicaRespuestas3.add(jcomp52);
        
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
        //Pregunta #1
        mathPanel.add(jcomp5);//enunciado
        mathPanel.add(jcomp2); //corecta
        mathPanel.add(jcomp3);
        mathPanel.add(jcomp4);
        mathPanel.add(Box.createVerticalStrut(20));
        //Pregunta #2
        mathPanel.add(jcomp6);//enunciado
        mathPanel.add(jcomp7);//correccta
        mathPanel.add(jcomp8);
        mathPanel.add(jcomp9);
        mathPanel.add(Box.createVerticalStrut(20));
        //Pregunta #3
        mathPanel.add(jcomp10);//enunciado
        mathPanel.add(jcomp11);//correcta
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
        //Pregunta #1
        programmingPanel.add(jcomp15);//enunciado
        programmingPanel.add(jcomp16);//enunciado
        programmingPanel.add(jcomp17);//enunciado
        programmingPanel.add(jcomp18);
        programmingPanel.add(jcomp19);
        programmingPanel.add(jcomp20);//correcta
        programmingPanel.add(Box.createVerticalStrut(20));
        //Pregunta #2
        programmingPanel.add(jcomp21);//enunciado
        programmingPanel.add(jcomp22);//enunciado
        programmingPanel.add(jcomp23);//enunciado
        programmingPanel.add(jcomp24);//enunciado
        programmingPanel.add(jcomp25);//correcta
        programmingPanel.add(jcomp26);
        programmingPanel.add(jcomp27);
        programmingPanel.add(Box.createVerticalStrut(20));
        //Pregunta #3
        programmingPanel.add(jcomp28);//enunciado
        programmingPanel.add(jcomp29);//enunciado
        programmingPanel.add(jcomp30);//enunciado
        programmingPanel.add(jcomp31);//enunciado
        programmingPanel.add(jcomp32);
        programmingPanel.add(jcomp33);
        programmingPanel.add(jcomp34);//correcta
        programmingPanel.setBorder(new EmptyBorder(new Insets(20, 40, 20, 20))); // Añadir espacio interior
        return programmingPanel;
    }

    private JPanel createPhysicsPanel() {
        JPanel physicsPanel = new JPanel();
        physicsPanel.setLayout(new BoxLayout(physicsPanel, BoxLayout.Y_AXIS));
        physicsPanel.add(jcomp40);

        

        //Pregunta #1
        physicsPanel.add(Box.createVerticalStrut(20));
        physicsPanel.add(jcomp44);//enunciado
        physicsPanel.add(jcomp41);//correcta
        physicsPanel.add(jcomp42);
        physicsPanel.add(jcomp43);
        physicsPanel.add(Box.createVerticalStrut(20));

        //Pregunta #2
        physicsPanel.add(jcomp45);//enunciado
        physicsPanel.add(jcomp46);//correcta
        physicsPanel.add(jcomp47);
        physicsPanel.add(jcomp48);
        physicsPanel.add(Box.createVerticalStrut(20));

        //Pregunta #3
        physicsPanel.add(jcomp49);//enunciado
        physicsPanel.add(jcomp50);
        physicsPanel.add(jcomp51);//correcta
        physicsPanel.add(jcomp52);
        physicsPanel.add(Box.createVerticalStrut(70));
        
        //Boton de terminar cuestionario
        finishTest = new JButton("Terminar cuestionario");
        finishTest.setForeground(Color.BLACK); // Texto en negro
        finishTest.setBackground(Color.WHITE); // Fondo en blanco
        finishTest.setFocusPainted(false);
        finishTest.setPreferredSize(new Dimension(150, 90));
        finishTest.setBounds(1400, 1650, 100, 50);
        physicsPanel.add(finishTest);

        //Logica de boton de terminar cuestionario
        finishTest.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (cuestionarioCompleto()){
                    JOptionPane.showMessageDialog(
                    physicsPanel, 
                    "Matematicas: [" + resultMatematicas() + "/3]\n" +
                    "Programacion: [" + resultProgramacion() + "/3]\n" +
                    "Fisica: [" + resultFisica() + "/3]\n", 
                "Cuestionario Terminado - Tu puntaje:", 
                    JOptionPane.INFORMATION_MESSAGE);

                //Enlazar ventana de Modulos 
                JFrame frameModulo = new JFrame("Modulos");
                frameModulo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameModulo.setSize(944, 569);

                Modulos vistaModulo = new Modulos();
                frameModulo.add(vistaModulo);

                // Mostrar la ventana del Modulo
                frameModulo.setVisible(true);

                //cerrar la ventana anterior
                mainFrame.dispose();
            
                } else{
                    JOptionPane.showMessageDialog(physicsPanel, "Responde todas las preguntas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
    });


        physicsPanel.setBorder(new EmptyBorder(new Insets(20, 40, 20, 20))); // Añadir espacio interior

        return physicsPanel;
    }

    static boolean cuestionarioCompleto(){
        for(ButtonGroup x: grupos){
            if(x.getSelection() == null){
                return false;
            }
        }

        return true;
    }

    //Contar respuestas correctas en cada campo
    static int resultMatematicas(){
        int correctas = 0;

        if(jcomp2.isSelected()){
            correctas++;
        }

        if(jcomp7.isSelected()){
            correctas++;
        }

        if(jcomp11.isSelected()){
            correctas++;
        }

        return correctas;
    }

    static int resultProgramacion(){
        int correctas = 0;

        if(jcomp20.isSelected()){
            correctas++;
        }

        if(jcomp25.isSelected()){
            correctas++;
        }

        if(jcomp34.isSelected()){
            correctas++;
        }

        return correctas;
    }

    static int resultFisica(){
        int correctas = 0;

        if(jcomp41.isSelected()){
            correctas++;
        }

        if(jcomp46.isSelected()){
            correctas++;
        }

        if(jcomp51.isSelected()){
            correctas++;
        }

        return correctas;
    }

}

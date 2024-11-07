package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import almacenamiento.AlmacenamientoME;
import recursos.MaterialEstudio;
import usuarios.AsesorAcademico;

public class ProfesoresVista extends JPanel{
    private JLabel bienvenida;
    private JLabel tusModulos;
    private JButton addMaterial;
    private JButton modMate;
    private JButton modFisica;
    private JLabel lblListade;
    private JList jcomp7;
    private JButton cerrarSesion;
    private JFrame mainFrame;

    public ProfesoresVista(JFrame mainFrame, AsesorAcademico sesion) {
        this.mainFrame = mainFrame;
        //construct preComponents

        ArrayList<String> listEstudiantes = new ArrayList<>();
        
        ArrayList<Integer> progresoEstudiantes = new ArrayList<>();

        try(BufferedReader lector = new BufferedReader(new FileReader("src\\almacenamiento\\data\\usuarios.txt"))) {
            String linea;
            while((linea = lector.readLine()) != null){
                String[] campos = linea.split(",");
                listEstudiantes.add(campos[0]);
                int prog1 = Integer.parseInt(campos[3]);
                int prog2 = Integer.parseInt(campos[4]);
                int prog3 = Integer.parseInt(campos[5]);

                int promedio = (prog1+prog2+prog3)/3;
                progresoEstudiantes.add(promedio);
            }


        } catch (Exception e) {
        }
        
        String[] listaEstudiantes = new String[listEstudiantes.size()];
        String[] listaProgreso = new String[progresoEstudiantes.size()];

        for(int i = 0;i<listEstudiantes.size();i++){
            listaEstudiantes[i] = listEstudiantes.get(i);
        }
        
        for(int i = 0;i<progresoEstudiantes.size();i++){
            listaProgreso[i] = String.valueOf( progresoEstudiantes.get(i) ) + "%";
        }

        //construct components
        bienvenida = new JLabel ("Bienvenido Profesor");
        tusModulos = new JLabel ("Tus Modulos ->");
        addMaterial = new JButton ("Añadir Material");
        lblListade = new JLabel ("Lista de tus estudiantes");
        cerrarSesion = new JButton ("Cerrar Sesion");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 569));
        setLayout (null);

        //add components
        add (bienvenida);
        add (tusModulos);
        add (lblListade);
        add (addMaterial);
        add (cerrarSesion);

        cargarEstudiantes(listaEstudiantes, listaProgreso);
        revalidate();
        repaint();

        //set component bounds (only needed by Absolute Positioning)
        bienvenida.setBounds (395, 80, 125, 20);
        tusModulos.setBounds (115, 150, 100, 25);
        addMaterial.setBounds (80, 215, 165, 40);
        lblListade.setBounds (615, 155, 170, 25);
        cerrarSesion.setBounds (15, 10, 135, 20);

        //cerrar sesion
        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage.main(null); // Llamar el método main de LoginPage para mostrar la vista
                mainFrame.dispose();
            }
        });

        //añadir material
        addMaterial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crear Material");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 300);  // Aumenté el tamaño para mayor espacio
        frame.setLayout(new BorderLayout());

        // Título principal
        JLabel titular = new JLabel("Crear nuevo material de estudio");
        titular.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(titular, BorderLayout.NORTH);

        // Panel para los campos de texto
        JPanel descripcioPanel = new JPanel(new GridLayout(6, 2, 10, 10));  // 3 filas, 2 columnas (etiqueta + campo de texto)
        descripcioPanel.setSize(300,300);

        // Crear las etiquetas y los campos de texto
        JLabel lblTitulo = new JLabel("Título:");
        JTextField titulo = new JTextField();
        
        JLabel lblTema = new JLabel("Tema:");
        JTextField tema = new JTextField();

        JLabel lblTipo = new JLabel("Asignatura:");
        String[] asignaturas = {"Matematicas","Programacion","Fisica"};
        JComboBox<String> tipo = new JComboBox<>(asignaturas);

        JLabel lblLink = new JLabel("Enlace:");
        JTextField link = new JTextField();

        // Añadir las etiquetas y los campos al panel
        descripcioPanel.add(Box.createVerticalStrut(10));
        descripcioPanel.add(Box.createVerticalStrut(10));

        descripcioPanel.add(lblTitulo, BorderLayout.CENTER);
        descripcioPanel.add(titulo, BorderLayout.CENTER);
        
        descripcioPanel.add(lblTema, BorderLayout.CENTER);
        descripcioPanel.add(tema, BorderLayout.CENTER);

        descripcioPanel.add(lblTipo, BorderLayout.CENTER);
        descripcioPanel.add(tipo, BorderLayout.CENTER);
        
        descripcioPanel.add(lblLink, BorderLayout.CENTER);
        descripcioPanel.add(link, BorderLayout.CENTER);
        
        descripcioPanel.add(Box.createVerticalStrut(20));

        // Añadir el panel al marco
        frame.add(descripcioPanel, BorderLayout.CENTER);

        // Botón para añadir material
        JButton add = new JButton("Añadir material");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strTitulo = titulo.getText().trim();
                String strTema = tema.getText().trim();
                String strTipo =(String) tipo.getSelectedItem();
                String strLink = link.getText().trim();
                String strMarca = strTipo + AlmacenamientoME.contarTipos(strTipo);

                MaterialEstudio material = new MaterialEstudio(strTitulo, strTipo, strTema, strLink, strMarca);
                AlmacenamientoME.agregarMaterial(material);
                JOptionPane.showMessageDialog(
            null, // No hay componente principal
            "Material añadido exitosamente", // Mensaje
            "Añadido material", // Título
            JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje
        );
        frame.dispose();
            }
        });

        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });



        JPanel botones = new JPanel();
        botones.add(add);
        botones.add(cancelar);
        frame.add(botones, BorderLayout.SOUTH);

        // Hacer visible el JFrame
        frame.setVisible(true);
            }
        });
        
    }

    public void cargarEstudiantes(String[] estudiantes, String[] progreso){
        JPanel listaPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        listaPanel.setBounds(555, 200, 300, 200);
        
        JList listaEstudiantes = new JList (estudiantes);
        listaPanel.add(listaEstudiantes, BorderLayout.CENTER);
        JList progresoEstudiantes = new JList (progreso);
        listaPanel.add(progresoEstudiantes, BorderLayout.CENTER);
        listaPanel.revalidate();
        listaPanel.repaint();

        add(listaPanel);

        
    }
    

}

package almacenamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AlmacenamientoME {
    static FileWriter archivo;
    static PrintWriter escritor;

    public static void registroEstudiante(String email){
        try {
            archivo = new FileWriter("src\\almacenamiento\\data\\usedmaterial.txt");
            escritor = new PrintWriter(archivo);

            escritor.println(email);
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    public static void recordarMaterial(Estudiante sesion, String marca){
        List<String> lineas = new ArrayList<>();

        String email = sesion.getCorreo();

        try (BufferedReader lector = new BufferedReader(new FileReader("src\\almacenamiento\\data\\usuarios.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] campos = linea.split(",");
                
                if (campos[0].equals(email)) {
                    linea = String.join(",", campos) + ","+ marca;
                }
                
                lineas.add(linea);
            } 
        } catch(IOException e){
            System.out.println("Error" + e);
        } 

        try (PrintWriter escritor = new PrintWriter(new FileWriter("src\\almacenamiento\\data\\usuarios.txt"))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
        } catch(IOException e){
            System.out.println("Error" + e);
        }
    }

    public static boolean verificarMarca(Estudiante sesion, String marca){

        String email = sesion.getCorreo();

        try (BufferedReader lector = new BufferedReader(new FileReader("src\\almacenamiento\\data\\usuarios.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] campos = linea.split(",");
                
                if (campos[0].equals(email)) {
                    for(String x: campos){
                        if(x.equals(marca)){
                            return true;
                        }
                    }
                }
                
            } 
        } catch(IOException e){
            System.out.println("Error" + e);
        }
        
        return false;
    }
}
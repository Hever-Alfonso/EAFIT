package almacenamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import recursos.MaterialEstudio;
import usuarios.Estudiante;

public class AlmacenamientoME {
    static FileWriter archivo;
    static PrintWriter escritor;

    public static void registroEstudiante(String email) throws IOException{
        try {
            archivo = new FileWriter("src\\almacenamiento\\data\\usedmaterial.txt");
            escritor = new PrintWriter(archivo);

            escritor.println(email);
        } catch (IOException e) {
            System.out.println("Error " + e);
        }finally{
            archivo.close();
        }
    }

    public static void recordarMaterial(Estudiante sesion, String marca){
        List<String> lineas = new ArrayList<>();

        String email = sesion.getCorreo();

        try (BufferedReader lector = new BufferedReader(new FileReader("src\\almacenamiento\\data\\usedmaterial.txt"))) {
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

        try (PrintWriter escritor = new PrintWriter(new FileWriter("src\\almacenamiento\\data\\usedmaterial.txt"))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
        } catch(IOException e){
            System.out.println("Error" + e);
        }
    }

    public static boolean verificarMarca(Estudiante sesion, String marca){

        String email = sesion.getCorreo();

        try (BufferedReader lector = new BufferedReader(new FileReader("src\\almacenamiento\\data\\usedmaterial.txt"))) {
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

    public static void agregarMaterial(MaterialEstudio material){
        try (PrintWriter escritor = new PrintWriter(new FileWriter("src\\almacenamiento\\data\\materialestudio.txt"))){
            String titulo = material.getTitulo();
            String tema = material.getTema();
            String marca = material.getMarca();
            String tipo = material.getTipo();
            String link = material.getEnlace();

            escritor.println(titulo+","+tema+","+tipo+","+marca+","+link);
        } catch (Exception e) {
        }
    }

    public static int contarTipos(String tipo){
        int suma = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader("src\\almacenamiento\\data\\materialestudio.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                String[] campos = linea.split(",");
                System.out.print(campos[2]);
                System.out.print(tipo);
                
                if (campos.length > 2 && campos[2].trim().equals(tipo.trim())) {
                    suma++;
                }
                
            }
            return suma; 
        } catch(IOException e){
            System.out.println("Error" + e);
            
        }
        return suma; 
    }
}
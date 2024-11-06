package almacenamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import comunicacion.Notificacion;
import usuarios.Usuario;

public class AlmacenamientoNotif {
    public static FileWriter archivo;
    public static PrintWriter escritor;

    public static void registroEstudiante(String email) throws IOException{
        try {
            archivo = new FileWriter("src\\almacenamiento\\data\\notificaciones.txt");
            escritor = new PrintWriter(archivo);

            escritor.println(email);
        } catch (IOException e) {
            System.out.println("Error " + e);
        }finally{
            archivo.close();
        }
    }

    public static void sendNotificacion(Usuario sesion, Notificacion notificacion){
        List<String> lineas = new ArrayList<>();

        String email = sesion.getCorreo();

        try (BufferedReader lector = new BufferedReader(new FileReader("src\\almacenamiento\\data\\Enotificaciones.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] campos = linea.split(",");
                
                if (campos[0].equals(email)) {
                    linea = String.join(",", campos) + ","+notificacion.getTitulo()+","+notificacion.getMensaje();
                }
                
                lineas.add(linea);
            } 
        } catch(IOException e){
            System.out.println("Error" + e);
        } 

        try (PrintWriter escritor = new PrintWriter(new FileWriter("src\\almacenamiento\\data\\Enotificaciones.txt"))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
        } catch(IOException e){
            System.out.println("Error" + e);
        }
    }

    public static void sendTodosEstudiantes(Notificacion notificacion){
        List<String> lineas = new ArrayList<>();



        try (BufferedReader lector = new BufferedReader(new FileReader("src\\almacenamiento\\data\\Enotificaciones.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] campos = linea.split(",");
                
                if (campos[2].equals("Estudiante")) {
                    linea = String.join(",", campos) + ","+notificacion.getTitulo()+","+notificacion.getMensaje();
                }
                
                lineas.add(linea);
            } 
        } catch(IOException e){
            System.out.println("Error" + e);
        } 

        try (PrintWriter escritor = new PrintWriter(new FileWriter("src\\almacenamiento\\data\\Enotificaciones.txt"))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
        } catch(IOException e){
            System.out.println("Error" + e);
        }
    }

    /*public static void sendTodosDocentes(Notificacion notificacion){
        List<String> lineas = new ArrayList<>();



        try (BufferedReader lector = new BufferedReader(new FileReader("src\\almacenamiento\\data\\Enotificaciones.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] campos = linea.split(",");
                
                if (campos[2].equals("Docente")) {
                    linea = String.join(",", campos) + ","+notificacion.getTitulo()+","+notificacion.getMensaje();
                }
                
                lineas.add(linea);
            } 
        } catch(IOException e){
            System.out.println("Error" + e);
        } 

        try (PrintWriter escritor = new PrintWriter(new FileWriter("src\\almacenamiento\\data\\Enotificaciones.txt"))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
        } catch(IOException e){
            System.out.println("Error" + e);
        }
    }*/
}

package almacenamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import usuarios.Estudiante;


public class AlmacenamientoUsuarios {
    FileWriter archivo;
    PrintWriter escritor;


    public static boolean verficarCorreo(String email){

        email = email.toLowerCase().trim();

        if(email.contains("@") && email.contains(".")){
            String[] sepArroba = email.split("@"); // dividir el correo en 2 (antes y despues de @)
            String[] sepPunto = sepArroba[1].split("\\."); //dividir la parte despues de @ (antes del . y despues)


            //verficar que haya algo antes y despues del arroba | verfucar que haya algo antes y despues del punto
            if(sepPunto.length < 2 || sepArroba.length < 2 || sepPunto[1].isEmpty() || sepPunto[0].isEmpty() ||  sepArroba[0].isEmpty() || sepArroba[1].isEmpty()){
                return false;
            }


            if(sepArroba.length == 2 && sepArroba.length == 2 ){
                if(sepPunto[1].equals("com") || sepPunto[1].equals("co")){
                    if(sepPunto[0].equals("eafit") || sepPunto[0].equals("gmail") || sepPunto[0].equals("outlook") || sepPunto[0].equals("icloud") || sepPunto[0].equals("hotmail")) {
                        return true;
                    }
                }
            }

        }
        return false;
    }


    public void guardarUsuarioInfo(String email, String contraseña, String rol) throws IOException{

        try {

            email = email.toLowerCase().trim();

            archivo = new FileWriter("usuarios.txt", true);
            escritor = new PrintWriter(archivo);

            escritor.println(email+","+contraseña+","+rol+",0,0,0"); //los 0 al final son el progreso de estudio en las distintas areas
            Estudiante e1 = new Estudiante(email, contraseña, rol);

        } catch (IOException e){
            System.out.println("Error: " + e);
        } finally{
            archivo.close();
        }
    }

    
    public boolean buscarUsuarioInfo(String email, String contraseña){
        try (BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"))){

            
            String renglon = "";

            while ((renglon= lector.readLine()) != null) { 

                String[] bloques = renglon.split(",");

                if(email.equals(bloques[0]) && contraseña.equals(bloques[1])){
                    return true;
                } 
            }
                return false;
        } catch (IOException e) {
            System.out.println("Error: " + e);

            return false;
        }
    }

    //Overload para verficar solo el mail
    public boolean buscarUsuarioInfo(String email){
        try (BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"))){

            
            String renglon = "";

            while ((renglon= lector.readLine()) != null) { 

                String[] bloques = renglon.split(",");

                if(email.equals(bloques[0])){
                    return true;
                } 
            }
                return false;
        } catch (IOException e) {
            System.out.println("Error: " + e);

            return false;
        }
    }

    public static boolean checkEstudiante(String email){
        try (BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"))){

            email = email.toLowerCase().trim();
            
            String renglon = "";

            while ((renglon= lector.readLine()) != null) { 

                String[] bloques = renglon.split(",");

                if(email.equals(bloques[0]) && bloques[2].trim().equals("Estudiante")){
                    return true;
                } 
                
            }
            return false;
        } catch (IOException e) {
            System.out.println("Error: " + e);

            return false;
        }
    }

    //buscar y modficar el progreso de asignaturas

    public static void actProgresoMate(Estudiante sesion){
        List<String> lineas = new ArrayList<>();

        String email = sesion.getCorreo();

        try (BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] campos = linea.split(",");
                
                if (campos[0].equals(email)) {

                    int progreso = Integer.parseInt(campos[3]);
                    progreso+=20;

                    campos[3] = String.valueOf(progreso); 
                    sesion.setProgresoMate(progreso);
                    
                    linea = String.join(",", campos);
                }
                
                lineas.add(linea);
            } 
        } catch(IOException e){
            System.out.println("Error" + e);
        } 

        try (PrintWriter escritor = new PrintWriter(new FileWriter("usuarios.txt"))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
        } catch(IOException e){
            System.out.println("Error" + e);
        }
    }

    public static int getProgresoMate(Estudiante sesion){
        try (BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"))){

            String email = sesion.getCorreo();
            String renglon = "";

            while ((renglon= lector.readLine()) != null) { 

                String[] bloques = renglon.split(",");

                if(email.equals(bloques[0]) && bloques[2].equals("Estudiante")){
                    int progreso = Integer.parseInt(bloques[3]);
                    return progreso;
                } 
            }
                return 0;
        } catch (IOException e) {
            System.out.println("Error: " + e);

            return 0;
        }
    }


    public static void actProgresoProg(Estudiante sesion){
        List<String> lineas = new ArrayList<>();

        String email = sesion.getCorreo();

        try (BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] campos = linea.split(",");
                
                if (campos[0].equals(email)) {

                    int progreso = Integer.parseInt(campos[4]);
                    progreso+=20;

                    campos[4] = String.valueOf(progreso); 
                    sesion.setProgresoProg(progreso);
                    
                    linea = String.join(",", campos);
                }
                
                lineas.add(linea);
            } 
        } catch(IOException e){
            System.out.println("Error" + e);
        } 

        try (PrintWriter escritor = new PrintWriter(new FileWriter("usuarios.txt"))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
        } catch(IOException e){
            System.out.println("Error" + e);
        }
    }

    public static int getProgresoProg(Estudiante sesion){
        try (BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"))){

            String email = sesion.getCorreo();
            String renglon = "";

            while ((renglon= lector.readLine()) != null) { 

                String[] bloques = renglon.split(",");

                if(email.equals(bloques[0]) && bloques[2].equals("Estudiante")){
                    int progreso = Integer.parseInt(bloques[4]);
                    return progreso;
                } 
            }
                return 0;
        } catch (IOException e) {
            System.out.println("Error: " + e);

            return 0;
        }
    }


    public static void actProgresoFisica(Estudiante sesion){
        List<String> lineas = new ArrayList<>();

        String email = sesion.getCorreo();

        try (BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] campos = linea.split(",");
                
                if (campos[0].equals(email)) {

                    int progreso = Integer.parseInt(campos[5]);
                    progreso+=20;

                    campos[5] = String.valueOf(progreso); 
                    
                    linea = String.join(",", campos);
                    sesion.setProgresoFisica(progreso);
                }
                
                lineas.add(linea);
            } 
        } catch(IOException e){
            System.out.println("Error" + e);
        } 

        try (PrintWriter escritor = new PrintWriter(new FileWriter("usuarios.txt"))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
        } catch(IOException e){
            System.out.println("Error" + e);
        }
    }

    public static int getProgresoFisica(Estudiante sesion){
        try (BufferedReader lector = new BufferedReader(new FileReader("usuarios.txt"))){

            String email = sesion.getCorreo();
            String renglon = "";

            while ((renglon= lector.readLine()) != null) { 

                String[] bloques = renglon.split(",");

                if(email.equals(bloques[0]) && bloques[2].equals("Estudiante")){
                    int progreso = Integer.parseInt(bloques[5]);
                    return progreso;
                } 
            }
                return 0;
        } catch (IOException e) {
            System.out.println("Error: " + e);

            return 0;
        }
    }

    
}

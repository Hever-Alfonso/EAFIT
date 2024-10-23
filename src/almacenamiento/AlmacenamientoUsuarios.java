package almacenamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import usuarios.Estudiante;


public class AlmacenamientoUsuarios {
    FileWriter archivo;
    PrintWriter escritor;



    public void guardarUsuarioInfo(String email, String contraseña, String rol) throws IOException{

        try {

            archivo = new FileWriter("usuarios.txt", true);
            escritor = new PrintWriter(archivo);

            escritor.println(email+","+contraseña+","+rol);
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
    
}

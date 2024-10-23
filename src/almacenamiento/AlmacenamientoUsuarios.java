package almacenamiento;

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
    
}

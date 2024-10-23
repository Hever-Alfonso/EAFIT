package almacenamiento;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AlmacenamientoUsuarios {
    FileWriter archivo;
    PrintWriter escritor;


    public void das() throws IOException{
        try {
            archivo = new FileWriter("C:\\usuarios.txt");
            escritor = new PrintWriter(archivo);

            escritor.println("cosa1,cosa2,cosa3");

        } catch (IOException e){
            System.out.println("Error: " + e);
        } finally{
            archivo.close();
        }
    }
    
}

package usuarios;

//import java.util.ArrayList;

public class Estudiante extends Usuario {

    private float progresoGeneral;
    private String preferencias;
    //ArrayList<MetaAprendizaje> metasAprendizaje = new ArrayList<>();
    //ArrayList<CalendarioEstudio> eventos = new ArrayList<>();

    //constructor
    public Estudiante(String nombre, String correoElectronico, String contraseña, String rol){
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    //setters
    private void setProgresoGeneral(float progresoGeneral){
        this.progresoGeneral = progresoGeneral;
    }

    private void setPreferencias(String preferencias){
        this.preferencias = preferencias;
    }

    //getters
    private float getProgresoGeneral(){
        return this.progresoGeneral;
    }

    private String getPreferencias(){
        return this.preferencias;
    }
}

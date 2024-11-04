package usuarios;

//import java.util.ArrayList;

public class Estudiante extends Usuario {

    private float progresoGeneral;
    private String preferencias;

    //Progreso de asingnaturas
    private int progresoMate = 0;
    private int progresoProg = 0;
    private int progresoFisica = 0;
    //ArrayList<MetaAprendizaje> metasAprendizaje = new ArrayList<>();
    //ArrayList<CalendarioEstudio> eventos = new ArrayList<>();

    //constructor
    public Estudiante(String correoElectronico, String contraseña, String rol){
        //this.nombre = nombre;
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

    //setters y getters del progreso

    public int getProgresoMate() {
        return progresoMate;
    }

    public void setProgresoMate(int progresoMate) {
        this.progresoMate = progresoMate;
    }

    public int getProgresoProg() {
        return progresoProg;
    }

    public void setProgresoProg(int progresoProg) {
        this.progresoProg = progresoProg;
    }

    public int getProgresoFisica() {
        return progresoFisica;
    }

    public void setProgresoFisica(int progresoFisica) {
        this.progresoFisica = progresoFisica;
    }

}

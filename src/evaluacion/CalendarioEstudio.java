package evaluacion;

public class CalendarioEstudio {
    private String nombre;
    private String areaEstudio;

    //Constructor
    public CalendarioEstudio(String nombre, String areaEstudio){
        this.nombre = nombre;
        this.areaEstudio = areaEstudio;
    }

    //setters
    private void setNombre(String nombre){
        this.nombre = nombre;
    }

    private void setAreaEstudio(String areaEstudio){
        this.areaEstudio = areaEstudio;
    }

    //getters
    private String getNombre(){
        return this.nombre;
    }

    private String getAreaEstudio(){
        return this.areaEstudio;
    }
}

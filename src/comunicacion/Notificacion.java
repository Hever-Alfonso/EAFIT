package comunicacion;


public class Notificacion {
    private String mensaje;
    private String titulo;

    //Constructor
    public Notificacion(String mensaje, String titulo) {
        this.mensaje = mensaje;
        this.titulo = titulo;
    }


    //setters
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    //getters
    public String getMensaje(){
        return this.mensaje;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
}

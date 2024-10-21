package comunicacion;
import java.time.LocalDate;

public class Notificacion {
    private String mensaje;
    private LocalDate fechaEnvio;

    //Constructor
    public Notificacion(String mensaje, LocalDate fechaEnvio) {
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
    }

    //Override del Constructor
    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
        this.fechaEnvio = LocalDate.now();
    }

    //setters
    private void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    private void setFecha(LocalDate fechaEnvio){
        this.fechaEnvio = fechaEnvio;
    }

    //getters
    private String getMensaje(){
        return this.mensaje;
    }
    
    private LocalDate getFechaEnvio(){
        return this.fechaEnvio;
    }
}

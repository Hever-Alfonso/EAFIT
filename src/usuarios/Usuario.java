package usuarios;

import java.util.ArrayList;

import comunicacion.Notificacion;


public class Usuario {
    protected String nombre;
    protected String correoElectronico;
    protected String contraseña;
    protected String rol;
    ArrayList<Notificacion> notificicaciones = new ArrayList<>(); 

    //setters
    protected void setNombre(String nombre){
        this.nombre = nombre;
    }

    protected void setCorreo(String correoElectronico){
        this.correoElectronico = correoElectronico;
    }

    protected void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    //getters
    protected String getNombre(){
        return this.nombre;
    }

    public String getCorreo(){
        return this.correoElectronico;
    }

    /*protected String getContraseña(){
        return this.contraseña;
    }*/

    protected String getRol(){
        return this.rol;
    }
}

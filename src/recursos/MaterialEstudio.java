package recursos;

public class MaterialEstudio {
    private String titulo;
    private String tipo;
    private String tema;
    private String enlace;

    public MaterialEstudio(String titulo, String tipo, String tema, String enlace){
        this.titulo = titulo;
        this.tipo = tipo;
        this.tema = tema;
        this.enlace = enlace;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}

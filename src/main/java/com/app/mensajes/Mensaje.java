package com.app.mensajes;

public class Mensaje {
    private String mensaje;
    private int id;
    private String autor;
    private String fecha;

    public Mensaje(String mensaje, String autor) {
        this.mensaje = mensaje;
        this.autor = autor;
    }

    public Mensaje(int id) {
        this.id = id;
    }

    public Mensaje() {
    }

    public Mensaje(String mensaje, int id, String autor) {
        this.mensaje = mensaje;
        this.id = id;
        this.autor = autor;
    }

    public Mensaje(String mensaje, int id, String autor, String fecha) {
        this.mensaje = mensaje;
        this.id = id;
        this.autor = autor;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mensaje{");
        sb.append("mensaje=").append(mensaje);
        sb.append(", id=").append(id);
        sb.append(", autor=").append(autor);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
    
    
}

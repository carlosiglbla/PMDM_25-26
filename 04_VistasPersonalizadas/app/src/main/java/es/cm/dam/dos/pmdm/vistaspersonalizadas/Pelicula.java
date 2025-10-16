package es.cm.dam.dos.pmdm.vistaspersonalizadas;

public class Pelicula {


    private String titulo;
    private String genero;
    private int imagen;

    public Pelicula(String titulo, String genero, int imagen) {
        this.titulo = titulo;
        this.genero = genero;
        this.imagen = imagen;
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getImagen() { return imagen; }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
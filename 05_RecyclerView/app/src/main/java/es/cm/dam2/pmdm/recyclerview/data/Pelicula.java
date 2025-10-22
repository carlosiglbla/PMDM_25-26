package es.cm.dam2.pmdm.recyclerview.data;

public class Pelicula {
    private Integer recursoImagen;
    private String nombre;
    private Integer anio;

    public Pelicula(String nom, Integer an){
        this.nombre = nom;
        this.anio = an;
    }
    public Pelicula(String nom, Integer an, Integer rutaImagen){
        this.nombre = nom;
        this.anio = an;
        this.recursoImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "recursoImagen='" + recursoImagen + '\'' +
                ", nombre='" + nombre + '\'' +
                ", anio=" + anio +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getRecursoImagen() {
        return recursoImagen;
    }

    public void setRecursoImagen(Integer recursoImagen) {
        this.recursoImagen = recursoImagen;
    }
}

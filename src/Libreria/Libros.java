package Libreria;

public class Libros {
    private int clave;
    private int cantidad;
    private double precio;
    private String tituloLibro;
    private String Autor;
    private String Editorial;

    public Libros(int clave, String tituloLibro, String nombreAutor, String editorial,
                  int cantidad, double precio) {
        this.clave = clave;
        this.tituloLibro = tituloLibro;
        this.Autor = nombreAutor;
        this.Editorial = editorial;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getClave() {
        return clave;
    }
    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }
    public void setNombreLibro(String nombreLibro) {
        this.tituloLibro = nombreLibro;
    }
    public String getNombreAutor() {
        return Autor;
    }
    public void setNombreAutor(String nombreAutor) {
        this.Autor = nombreAutor;
    }
    public String getEditorial() {
        return Editorial;
    }
    public void setEditorial(String editorial) {
        this.Editorial = editorial;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String formatoArchivo() {
        return clave + "|" + tituloLibro + "|" + Autor + "|" + Editorial + "|" + cantidad + "|" + precio;
    }

    @Override
    public String toString() {
        return "Libreria.Libros{" +
                "clave=" + clave +
                ", Nombre del libro='" + tituloLibro + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Editorial='" + Editorial + '\'' +
                ", Cantidad='" + cantidad + '\'' +
                ", Precio=" + precio +
                '}';
    }

}
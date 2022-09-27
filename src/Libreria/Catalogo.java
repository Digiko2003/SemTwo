package Libreria;

import java.util.ArrayList;
import java.util.Iterator;
public class Catalogo {
    private ArrayList<Libros> listaLibros;

    public Catalogo () {
        listaLibros = new ArrayList <>();
    }
    public void setListaLibros (ArrayList <Libros> lista){
        this.listaLibros = lista;
    }
    public ArrayList<Libros> getListaLibros(){
        return listaLibros;
    }
    public void insertarLibro (Libros Librox) {
        listaLibros.add(Librox);
    }
    public void mostrarLibro (int indice){
        Libros aux = listaLibros.get(indice);


        System.out.printf("%-8s|%-30s|%-30s|%-16s|%-10s|%-18s\n","clave", "Nombre del libro", "Autor", "Precio","Editorial","Cantidad");
        System.out.println("--------|------------------------------|" + "------------------------------|-------");
        System.out.printf("%-8s|%-30s|%-30s|%-16s|%-10s|%-18s\n",
                aux.getClave(), aux.getTituloLibro(),
                aux.getNombreAutor(), aux.getPrecio(), aux.getEditorial(), aux.getCantidad());
    }
    public int buscarLibroPorClaveSecuencial (int claveABuscar){ // Búsqueda secuencial
        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getClave() == claveABuscar){
                return i;
            }
        }
        return -1;
    }
    public void borrarCancion (int clave){ //fin de borrar libro
        Iterator<Libros> LibroIterator = listaLibros.iterator();
        while (LibroIterator.hasNext()){
            Libros cancionx = LibroIterator.next();
            if (clave == cancionx.getClave()){
                LibroIterator.remove();
            }
        }
    }//fin de borrar libro
    public void cambiarPrecioLibro(int indice, int nuevoPrecio){
        Libros LibrosAux = listaLibros.get(indice);
        LibrosAux.setPrecio(nuevoPrecio);
    }//fin de cambiarNombre

    public int buscarLibroPorNombre(String nombreABuscar){//Búsqueda secuencial
        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getTituloLibro().equals(nombreABuscar)){
                return i;
            }
        }
        return -1;
    }

    public int buscarLibroPorClaveBinaria(int claveABuscar){ //Búsqueda binaria
        int bajo = 0;
        int alto = listaLibros.size() -1;
        int buscando;
        while (bajo <= alto){
            int mitad = (bajo + alto) / 2;
            buscando = listaLibros.get(mitad).getClave();
            if (buscando == claveABuscar){
                return mitad;
            } else if (buscando > claveABuscar){
                alto = mitad -1;
            } else if (buscando < claveABuscar){
                bajo = mitad + 1;
            }
        }
        return -1;
    }

    public void ordenarClaves() { // Ordena por método de burbuja
        Libros aux;
        int N = listaLibros.size();
        for (int i = 0; i <= N -2; i++){
            for (int j = 0; j <= N -2; j++){
                if (listaLibros.get(j).getClave() > listaLibros.get(j + 1).getClave()){
                    aux = listaLibros.get(j);
                    listaLibros.set(j, listaLibros.get(j + 1));
                    listaLibros.set(j + 1, aux);
                }
            }
        }
    }


    public void ordenarPrecio(){ // Ordenar por precio
        Libros aux;
        int N = listaLibros.size();
        for (int i = 0; i <= N -2; i++){
            for (int j = 0; j <= N -2; j++){
                if (listaLibros.get(j).getPrecio() > listaLibros.get(j + 1).getPrecio()){
                    aux = listaLibros.get(j);
                    listaLibros.set(j, listaLibros.get(j + 1));
                    listaLibros.set(j + 1, aux);
                }
            }
        }
    }

    public void mostrarTotalInventario(){ //Metodo mostrar inventario
        double totalInventario = 0;
        for(Libros aux : listaLibros){
            totalInventario += aux.getCantidad()*aux.getPrecio();
        }
        System.out.println(totalInventario);
    }
    public void verCatalogo(){ //metodo ver catalogo
        System.out.printf("%-8s|%-30s|%-30s|%-16s|%-10s|%-18s\n", "Clave", "Titulo del Libro", "Autor", "Editorial",
                "Cantidad","Precio");
        System.out.println("--------|------------------------------|" + "------------------------------|----------------|" +
                "----------|-------------------");

        for (Libros aux : listaLibros){
            //aqui si lleva el % según el tipo
            System.out.printf("%-8s|%-30s|%-30s|%-16s|%-10s|%-18s\n",
                    aux.getClave(), aux.getTituloLibro(),
                    aux.getNombreAutor(),aux.getEditorial(),aux.getCantidad(), aux.getPrecio());
        }
    }
}
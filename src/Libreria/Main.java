package Libreria;

import java.util.Scanner;
public class Main {
    static Catalogo catalogoTienda = new Catalogo();
    static  Scanner entrada = new Scanner(System.in);

    public static void main(String[] args){
        //Para enzazar el archivo de texto
        Archivo archivox = new Archivo("Libreria.Libros.txt");
        //Para crear si no existe el archivo
        archivox.crearArchivo();
        catalogoTienda.verCatalogo();

        //------Variable para imprimir------------
        catalogoTienda.setListaLibros(archivox.leerDeArchivo());


        int opcion, indice;
        int clave;
        String nombreLibro;
        do{
            menu();
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    pedirDatosLibro();
                    archivox.escribirEnArchivo(catalogoTienda.getListaLibros());
                    break;
                case 2:
                    catalogoTienda.verCatalogo();
                    break;
                case 3:
                    System.out.print("Dame la clave del libro a buscar: ");
                    clave = entrada.nextInt();
                    indice = catalogoTienda.buscarLibroPorClaveSecuencial(clave);
                    if (indice != -1) {
                        catalogoTienda.mostrarLibro(indice);
                    } else {
                        System.out.println("No se encontró");
                    }
                    break;
                case 4:
                    System.out.println("Buscar un libro (B.Binaria");
                    //Primero se ordenan los elementos y luego se hace la búsqueda
                    catalogoTienda.ordenarClaves();
                    System.out.print("Dame la clave del libro: ");
                    clave = entrada.nextInt();
                    indice = catalogoTienda.buscarLibroPorClaveBinaria(clave);
                    if (indice != -1){
                        catalogoTienda.mostrarLibro(indice);
                    } else {
                        System.out.println("No se encontró");
                    }
                    break;
                case 5:
                    System.out.println("Buscar un libro (B. Secuencial");
                    System.out.print("Dame el nombre del libro: ");
                    // Deben coincidir los nombre en mayúsculas y minúsculas
                    nombreLibro = entrada.nextLine();
                    indice = catalogoTienda.buscarLibroPorNombre(nombreLibro);
                    if (indice != -1){
                        catalogoTienda.mostrarLibro(indice);
                    } else {
                        System.out.println("No se encontró");
                    }
                    break;
                case 6:
                    System.out.print("Dame la clave del libro a borrar: ");
                    clave = entrada.nextInt();
                    indice = catalogoTienda.buscarLibroPorClaveSecuencial(clave);
                    if (indice == -1){
                        System.out.println("La clave no existe. Repite la operación");

                    } else {
                        catalogoTienda.borrarCancion(clave);
                        System.out.println("El libro se ha eliminado");
                        catalogoTienda.verCatalogo();
                    }
                    break;
                case 7:
                    cambiarNombreLibro();
                    break;
                case 8:
                    System.out.println("Mostrar el total");
                    catalogoTienda.mostrarTotalInventario();
                    break;
                case 9:
                    System.out.println("Ordenar por precio");
                    catalogoTienda.ordenarPrecio();
                    catalogoTienda.verCatalogo();
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No válido");
                    break;
            } // fin de switch
        } while (opcion != 10);
    }

    private static void menu() {
        imprimirLinea();
        System.out.println("Operaciones sobre Libreria.Libros");
        System.out.println("1.- Añadir un Libro a la lista");
        System.out.println("2.- Mostrar Lista de Libreria.Libros");
        System.out.println("3.- Buscar libro por clave (B.Secuencial)");
        System.out.println("4.- Buscar libro por clave (B.Binaria)");
        System.out.println("5.- Buscar libro por nombre (B.Secuencial)");
        System.out.println("6.- Borrar un libro");
        System.out.println("7.- Cambiar el precio del libro");
        System.out.println("8.- Mostrar el total de todo el inventario");
        System.out.println("9.- Ordenar por precio");
        System.out.println("10.- Salir");
        System.out.println("Elige tu opción: ");
    } //fin de menu

    public static void pedirDatosLibro(){
        int clave, cantidad;
        String nombreLibro, nombreAutor, editorial;
        double precio;

        System.out.print("Dame la clave del libro: ");
        clave = entrada.nextInt();

        entrada.nextLine();
        System.out.print("Dame el titulo del libro: ");
        nombreLibro = entrada.nextLine();

        System.out.println("Dame el nombre del autor: ");
        nombreAutor = entrada.nextLine();

        System.out.print("Dame el editorial: ");
        editorial = entrada.nextLine();

        System.out.print("Dame la cantidad: ");
        cantidad = entrada.nextInt();

        System.out.print("Dame el precio del libro: ");
        precio = entrada.nextDouble();

        Libros LibroX = new Libros(clave, nombreLibro, nombreAutor, editorial,cantidad,precio);
        catalogoTienda.insertarLibro(LibroX);
    }
    public static void imprimirLinea(){
        System.out.println("------------------------------" +
                "-------------------");
    }
    private static void cambiarNombreLibro () {
        int clave, indice;
        System.out.println("Cambiar nombre");
        System.out.print("Dame la clave del libro: ");
        clave = entrada.nextInt();
        indice = catalogoTienda.buscarLibroPorClaveSecuencial(clave);
        if (indice == -1) {
            System.out.println("La clave no existe. Repite la operación");
            System.out.println();
        } else {
            entrada.nextLine();
            System.out.println("Datos del libro");
            catalogoTienda.mostrarLibro(indice);
            System.out.println();
            System.out.print("Dame el nuevo precio del libro: ");
            int nuevoPrecio = entrada.nextInt();
            catalogoTienda.cambiarPrecioLibro(indice, nuevoPrecio);
            System.out.println("Cambios guardados");
            System.out.println();
        }
    }
}
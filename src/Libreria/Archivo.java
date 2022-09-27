package Libreria;

import java.io.File;
import java.io.PrintWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    private String nombreArchivo;

    public Archivo(String nombreA){
        this.nombreArchivo = nombreA;
    }
    public void crearArchivo(){
        File archivo = new File(nombreArchivo);
        if(!archivo.exists()){
            try {
                PrintWriter salidaArchivo = new PrintWriter(nombreArchivo);
                System.out.println("El archivo "+ nombreArchivo + " se ha creado.");
                salidaArchivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void escribirEnArchivo(ArrayList<Libros>listaLibros){
        try {
            PrintWriter salidaArchivo = new PrintWriter(nombreArchivo);
            for(Libros librox : listaLibros){
                salidaArchivo.println(librox.formatoArchivo());
            }
            salidaArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//Fin de escribir en archivo
    public ArrayList<Libros> leerDeArchivo(){
        ArrayList <Libros> listaLibros = new ArrayList<>();
        try{
            //Abrir el archivo
            File archivoLectura = new File(nombreArchivo);
            Scanner leerArchivo = new Scanner(archivoLectura);
            //Leer el archivo
            while(leerArchivo.hasNext()){
                String linea = leerArchivo.nextLine();
                String [] valores = linea.split("\\|");//Dividor por |
                int clave = Integer.parseInt(valores[0]);
                String tituloLibro = valores[1];
                String nombreAutor = valores[2];
                String editorial = valores[3];
                int cantidad= Integer.parseInt(valores[4]);
                double precio = Double.parseDouble(valores[5]);
                Libros Librosx = new Libros(clave, tituloLibro, nombreAutor, editorial, cantidad, precio);
                listaLibros.add(Librosx);
            }
            //Cerrar el archivo
            leerArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaLibros;
    }
}
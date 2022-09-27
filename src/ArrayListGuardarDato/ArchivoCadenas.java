package ArrayListGuardarDato;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoCadenas {
    protected Scanner entradaArchivo;
    protected PrintWriter salidaArchivo;
    protected String nombreArchivo = "";
    protected ArrayList<String> listaRegistros;

    //Constructor
    public ArchivoCadenas(String nombreArchivoEntrada) {
        this.nombreArchivo = nombreArchivoEntrada;
        //Asegura de crear el archivo si no exste
        crearArchivo();
        listaRegistros = new ArrayList<>();
    }

    private void escribir() {
        for (String registro : listaRegistros) {
            salidaArchivo.format("%s\n", registro);
        }
    }

    protected void leer() {
        while (entradaArchivo.hasNext()) {
            String linea = entradaArchivo.nextLine();
            listaRegistros.add(linea);
        }// end while
    }

    public ArrayList<String> EscribirEnArchivo(ArrayList<String> lista) {
        listaRegistros = lista;
        //Abrir el archivo
        try {
            salidaArchivo = new PrintWriter(nombreArchivo);
        } catch (FileNotFoundException fileEx) {
            System.err.println("Error en crear el archivo");
            System.exit(1);
        }
        //Escribir en el archivo
        try {
            escribir();
            salidaArchivo.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }// cierra el archivo
        if (salidaArchivo != null) {
            salidaArchivo.close();
        }
        return listaRegistros;
    }//Fin de escribir en archivo

        //Permite leer el achivo
        public ArrayList<String> LeerArchivo () {
            //Abre el Archivo
            try {
                File archivo = new File(nombreArchivo);
                entradaArchivo = new Scanner(archivo);
            } catch (FileNotFoundException fileEx) {
                System.err.println("Error al abrir el archivo");
                System.exit(1);
            }
            //lee archivo
            try {
                leer();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(1);

            }

            //Cierra el archivo
            if (entradaArchivo != null) {
                entradaArchivo.close();
            }
            return listaRegistros;
        }//fin de leer archivo


        //crear archivo que no existe
        private void crearArchivo() {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                try {
                    PrintWriter nuevoArchivo = new PrintWriter(nombreArchivo);
                    nuevoArchivo.close();
                } catch (FileNotFoundException fileEx) {
                    System.err.println("Error al crear el archivo.");
                    System.exit(1);
                }
            }
        }
    }

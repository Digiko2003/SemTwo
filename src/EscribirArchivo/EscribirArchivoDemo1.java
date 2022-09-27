package EscribirArchivo;

import java.io.IOException;
import java.io.PrintWriter;

public class EscribirArchivoDemo1 {
    public static void main(String[] args) throws IOException{

        //Abrir el archivo
        PrintWriter salidaArchivo = new PrintWriter("salida.txt");
        //Escribir sobrte el archivo
        salidaArchivo.println("Hola mundo");
        //Cerrar el archivo
        salidaArchivo.close();



        System.out.println("Datos grabados en el archivo");

    }
}

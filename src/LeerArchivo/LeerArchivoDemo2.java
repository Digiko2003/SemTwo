package LeerArchivo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeerArchivoDemo2 {
    public static void main(String []args) throws IOException {
        Scanner entrada =  new Scanner(System.in);

        //Obtener nombre del archivo
        System.out.print("Introduce el nombre del archivo: ");
        String nombreArchivo = entrada.nextLine();

        //Abrir archivo
        File archivo = new File(nombreArchivo);
        Scanner entradaArchivo = new Scanner(archivo);

        //Leer la primera linea
        String linea = entradaArchivo.nextLine();

        //Despegar la linea
        System.out.println("La primera linea del archivo es: ");
        System.out.println(linea);

        //Close
        entradaArchivo.close();
    }
    }


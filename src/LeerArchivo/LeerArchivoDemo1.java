package LeerArchivo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeerArchivoDemo1 {
    public static void main(String []args) throws IOException{
        //Abrir archivo
        File archivo = new File("Salida.txt");
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

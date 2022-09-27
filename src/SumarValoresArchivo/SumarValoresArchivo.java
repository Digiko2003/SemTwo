package SumarValoresArchivo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SumarValoresArchivo {
    public static void main(String []args) throws IOException{
        double suma = 0.0; //Acumulador en cero

        //Abre el archivo
        File archivo = new File("Numbers.txt");
        Scanner entradaArchivo = new Scanner(archivo);

        //Lee todos los valores desde el archivo
        //calcula su total
        while (entradaArchivo.hasNext()){
            //lee un valor desde el archivo
            double numero = entradaArchivo.nextDouble();

            //Añade el sumero a suma
            suma = suma + numero;
        }
        //cierra
        entradaArchivo.close();

        // muestra la suma de los numeros
        System.out.println("La suma de los numeros del archivo  " + "Numbers.txt es: " + suma);

    }
}

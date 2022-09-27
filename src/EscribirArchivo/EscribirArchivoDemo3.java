package EscribirArchivo;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
public class EscribirArchivoDemo3 {

    public static void main(String[] args) throws IOException {
        String nombreArchivo; //nombre del archivo
        String nombreAmigo;
        int numAmigos;

        Scanner entrada = new Scanner(System.in);

        // Obtener numero de amigos
        System.out.print("¿Cuantos amigos tienes?");
        numAmigos = entrada.nextInt();

        //Consume the remaining newline character
        entrada.nextLine();

        //Obtener nombre del archivo
        System.out.print("Indroduce el nombre del archivo: ");
        nombreArchivo = entrada.nextLine();

        //Asegurarse que el achivo no exsta
        File archivo= new File(nombreArchivo);
        if(archivo.exists()){
            System.out.println("El archivo" + nombreArchivo+ "ya exiate");
            System.exit(0);

        }
        //Abrir
        PrintWriter salidaArchivo = new PrintWriter(nombreArchivo);

        //Obtener lo datos y escribir en el archivo
        for(int i=1; i<=numAmigos; i++){
            //Obtener el numero de un amigo
            System.out.print("Introduce el nombre del amigo" + "numero " + i + " : ");
            nombreAmigo = entrada.nextLine();

            //Escribir nombre del archivo
            salidaArchivo.println(nombreAmigo);
        }
        //cerrar
        salidaArchivo.close();
        System.out.println("Datos escritos");
        


    }
}

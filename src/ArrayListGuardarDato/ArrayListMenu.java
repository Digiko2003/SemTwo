package ArrayListGuardarDato;

import java.util.ArrayList;
import java.util.Scanner;
import static java.util.Collections.sort;

public class ArrayListMenu {
    private static  ArrayList<String> listaAsignaciones = new ArrayList<>();
    private static Scanner entrada = new Scanner(System.in);
    static ArchivoCadenas archivo;
    public static void main(String[] args){
        archivo= new ArchivoCadenas("Asignaciones.txt");
        listaAsignaciones=archivo.LeerArchivo();
        sort(listaAsignaciones);
        mostrarListaFrutas();
        int opcion, indice;
        String nombreF;
        do{
            menu();
            opcion=entrada.nextInt();
            switch (opcion){
                case 1:
                    System.out.print("Dime el nombre de la Asignacion: ");
                    nombreF=entrada.next();
                    meterFrutas(nombreF);
                    archivo.EscribirEnArchivo(listaAsignaciones);
                    break;
                case 2:
                    sort(listaAsignaciones);
                    mostrarListaFrutas();
                    break;
                case 3:
                    System.out.print("Dame el nombre de la Asignacion a buscar: ");
                    nombreF= entrada.next();
                    indice=buscarFruta(nombreF);
                    if(indice !=-1){
                        System.out.println("Encontrado en la posocion: "+ indice);
                    } else{
                        System.out.println("No encontrado");
                    }
                    break;
                case 4:
                    sort(listaAsignaciones);
                    mostrarListaFrutas();
                    System.out.print("Dame el nombre de la Asignacion a borrar: ");
                    nombreF= entrada.next();
                    indice= buscarFruta(nombreF);

                    if(indice!=-1){
                        listaAsignaciones.remove(indice);
                        archivo.EscribirEnArchivo(listaAsignaciones);
                        System.out.print("Asignacion eliminada");
                    } else {
                        System.out.print("No encontrado");
                    }
                    break;
                case 5:
                    sort(listaAsignaciones);
                    mostrarListaFrutas();
                    System.out.println("Dame el nombre de la Asignacion a cambiar");
                    nombreF = entrada.next();
                    indice = buscarFruta(nombreF);
                    if (indice !=-1){
                        System.out.print("Dame nuevo nombre de la Asignacion:");
                        nombreF=entrada.next();
                        listaAsignaciones.set(indice, nombreF);
                        archivo.EscribirEnArchivo(listaAsignaciones);
                        System.out.println("Nombre cambiado:");
                    }else{
                        System.out.println("No encontrado");
                    }
                    break;
                case 6:
                    System.out.println("SALIENDO");
                    break;
                default:
                    System.out.println("No valido");
                    break;
            }// final se swich
        }while(opcion !=6);
    }
    private static void menu() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Uso de Array list para una lista de Asignaciones");
        System.out.println("1. Añadir una Asignacion a la lista");
        System.out.println("2. Mostrar Asignaciones");
        System.out.println("3. Buscar una Asignacion");
        System.out.println("4. Borrar una Asignacion");
        System.out.println("5. Cambiar una Asignacion");
        System.out.println("6. Salir");
        System.out.println("Elige tu opcion");

    }
    private static void meterFrutas(String nombreFruta){
        listaAsignaciones.add(nombreFruta);
    }
    private static void mostrarListaFrutas(){
        System.out.println("Lista de asignatura:");
        for(String fruta : listaAsignaciones){
            System.out.print(fruta + "");

        }
        System.out.println();
    }
    private static int buscarFruta(String nombreFruta){
        for(int index=0; index<listaAsignaciones.size(); index ++){
            if(nombreFruta.equals(listaAsignaciones.get(index))){
                return index;
            }
        }
        return -1;
    }
}

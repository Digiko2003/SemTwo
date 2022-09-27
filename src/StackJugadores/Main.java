package StackJugadores;

import StackJugadores.Jugador;

import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args){
        int opcion;
        Stack<Jugador>pilaJugadores = new Stack<>();
        Jugador j1 =new Jugador(1,"Jose","Defensa",3);
        Jugador j2 =new Jugador(2,"Rogelio","Defensa",5);
        Jugador j3 =new Jugador(3,"Fernando","Medio",5);
        Jugador j4 =new Jugador(4,"Luis","Medio", 6);
        Jugador j5 =new Jugador(5,"Mario","Delantero",4);

        pilaJugadores.push(j1);
        pilaJugadores.push(j2);
        pilaJugadores.push(j3);
        pilaJugadores.push(j4);
        pilaJugadores.push(j5);

        Scanner entrada=new Scanner(System.in);
        do {
            menu();
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    int numero, goles;
                    String nombre, posicion;
                    System.out.println("Dame el numero: ");
                    numero = entrada.nextInt();
                    System.out.println("Dame el nombre: ");
                    nombre = entrada.nextLine();
                    nombre = entrada.nextLine();
                    System.out.println("Dame la posicion: ");
                    posicion = entrada.nextLine();
                    System.out.println("Dame los goles: ");
                    goles = entrada.nextInt();
                    Jugador jugador = new Jugador(numero, nombre, posicion, goles);
                    pilaJugadores.push(jugador);
                    break;

                case 2:
                    if (pilaJugadores.isEmpty()) {
                        System.out.printf("La pila esta vacio%n%n");
                    } else {
                        Jugador jugadorEliminado = pilaJugadores.pop();
                        System.out.printf("Se saco %s%n", jugadorEliminado);

                    }
                    break;

                case 3:
                    if (pilaJugadores.isEmpty()) {
                        System.out.printf("La pila esta vacia%n%n");
                    } else {//la pila no esta vacia
                        System.out.printf("La pila contiene: %s (cima)%n", pilaJugadores);
                    }
                    break;

                case 4:
                    if(pilaJugadores.isEmpty()){
                        System.out.printf("La pila esta vacia%N%n");
                    }else {//la pila no esta vacia
                        System.out.println("En cima esta" + pilaJugadores.peek());
                    }
                    break;

                case 5:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("No valido  ");
                    break;
            }// fin swich
        }while(opcion !=5);
    }
    private static void menu(){
        System.out.println("Operaciones sobre Jugadores");
        System.out.println("1. Meter jugador");
        System.out.println("2. Sacar jugador");
        System.out.println("3. Imprimar pila de jugadores");
        System.out.println("4. Consultar top");
        System.out.println("5. Salir");
        System.out.print("Elige tu opcion");
    }//fin
}

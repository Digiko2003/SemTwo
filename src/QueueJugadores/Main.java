package QueueJugadores;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        int opcion;
        Queue<Jugador> colaJugadores = new LinkedList<>();
        Jugador j1 =new Jugador(11,"Jose","Defensa",3);
        Jugador j2 =new Jugador(12,"Rogelio","Defensa",5);
        Jugador j3 =new Jugador(13,"Fernando","Medio",5);
        Jugador j4 =new Jugador(14,"Luis","Medio", 6);
        Jugador j5 =new Jugador(15,"Mario","Delantero",4);

        colaJugadores.add(j1);
        colaJugadores.add(j2);
        colaJugadores.add(j3);
        colaJugadores.add(j4);
        colaJugadores.add(j5);

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
                    colaJugadores.add(jugador);
                    break;

                case 2:
                    if (colaJugadores.isEmpty()) {
                        System.out.printf("La cola esta vacio%n%n");
                    } else {
                        Jugador jugadorEliminado = colaJugadores.remove();
                        System.out.printf("Se saco %s%n", jugadorEliminado);

                    }
                    break;

                case 3:
                    if (colaJugadores.isEmpty()) {
                        System.out.printf("La cola esta vacia%n%n");
                    } else {//la pila no esta vacia
                        System.out.printf("La cola contiene: (frente) %s (final) %n", colaJugadores);
                    }
                    break;

                case 4:
                    if(colaJugadores.isEmpty()){
                        System.out.printf("La cola esta vacia%N%n");
                    }else {//la pila no esta vacia
                        System.out.println("En cima esta" + colaJugadores.peek());
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

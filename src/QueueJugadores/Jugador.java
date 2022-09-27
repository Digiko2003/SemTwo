package QueueJugadores;

public class Jugador {
    private int numero;
    private String nombre;
    private String posición;
    private int goles;

    public Jugador(int numero, String nombre, String posición, int goles){
        this.numero = numero;
        this.nombre = nombre;
        this.posición = posición;
        this.goles = goles;
    }

    @Override
    public String toString() {
        return "StackJugadores.QueueJugadores.Jugador{" +
                "numero=" + numero + ", nombre=" + nombre +
                ", posición=" + posición + ", goles=" + goles + '}';
    }
}

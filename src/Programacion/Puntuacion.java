package Programacion;

import java.io.Serializable;

/**
 *
 * @author quino_ku
 */

public class Puntuacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private String iniciales;
    private int puntos;

    // constructor por defecto

    public Puntuacion(){}

    // constructor con parámetros

    public Puntuacion(String iniciales, int puntos) {

        this.iniciales = iniciales;
        this.puntos = puntos;
    }

    // métodos getter para acceder al valor de las variables

    public int getPuntos() {

        return puntos;
    }

    public String getPuntuaciones() {

        return "Jugador " + iniciales + " - puntuación: " + puntos + " puntos";
    }
}
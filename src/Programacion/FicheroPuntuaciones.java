package Programacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author quino_ku
 */

public class FicheroPuntuaciones {

    public static void main(String[] args) {

        // creo un array con 10 huecos para las 10 mejores puntuaciones

        Puntuacion[] puntosJugadores = new Puntuacion[10];

        puntosJugadores[0] = new Puntuacion("AAA", 90);
        puntosJugadores[1] = new Puntuacion("AAA", 91);
        puntosJugadores[2] = new Puntuacion("AAA", 92);
        puntosJugadores[3] = new Puntuacion("AAA", 93);
        puntosJugadores[4] = new Puntuacion("AAA", 94);
        puntosJugadores[5] = new Puntuacion("AAA", 95);
        puntosJugadores[6] = new Puntuacion("AAA", 96);
        puntosJugadores[7] = new Puntuacion("AAA", 97);
        puntosJugadores[8] = new Puntuacion("AAA", 98);
        puntosJugadores[9] = new Puntuacion("AAA", 99);

        // creo el archivo con el array de 10 huecos

        try {

            ObjectOutputStream guardado = new ObjectOutputStream(new FileOutputStream("src/juego/Ficheros/Puntuaciones.txt"));

            guardado.writeObject(puntosJugadores);
            guardado.close();

        } catch(IOException e) {

            e.printStackTrace();

        }
    }
}
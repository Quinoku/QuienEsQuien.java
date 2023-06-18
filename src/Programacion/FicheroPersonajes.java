package Programacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author quino_ku
 */

public class FicheroPersonajes {

    public static void main(String[] args) {

        // creo mi array con los personajes y los instancio

        Personaje[] misPersonajes = new Personaje[9];

        misPersonajes[0] = new Personaje("Mario", true, false, false, true, true, true, true, false, false, true);
        misPersonajes[1] = new Personaje("Luigi", true, false, true, false, true, true, true, false, false, true);
        misPersonajes[2] = new Personaje("Bowser", true, false, true, false, false, false, false, false, false, false);
        misPersonajes[3] = new Personaje("Toad", true, false, false, true, false, true, false, false, false, false);
        misPersonajes[4] = new Personaje("Link", true, false, true, false, true, true, true, false, true, false);
        misPersonajes[5] = new Personaje("Peach", false, true, true, false, true, false, false, true, true, false);
        misPersonajes[6] = new Personaje("Toaddete", false, true, false, true, false, true, false, false, false, false);
        misPersonajes[7] = new Personaje("Daisy", false, true, true, false, true, false, false, true, false, false);
        misPersonajes[8] = new Personaje("Canela", false, true, false, true, false, false, false, false, true, false);

        // guardo los personajes en un archivo de texto

        try {

            ObjectOutputStream almacenar = new ObjectOutputStream(new FileOutputStream("src/juego/Ficheros/Personajes.txt"));

            almacenar.writeObject(misPersonajes);
            almacenar.close();

        } catch (IOException e) {

            System.out.println("No se encuentra la ruta indicada");

        }
    }
}
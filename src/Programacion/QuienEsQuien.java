package Programacion;

import java.io.*;
import java.util.Scanner;

public class QuienEsQuien {

    // 0. variables y objetos de clase necesarios

    static Scanner teclado = new Scanner(System.in);
    static int indice;
    static Personaje[] listaPersonajes;
    static Personaje personajeAleatorio;
    static Puntuacion[] puntuaciones;
    static String iniciales;
    static String nombre;
    static int numEleccion = 11;
    static int contador = 0;
    static boolean numValido = false;
    static Puntuacion partida;

    public static void main(String[] args) {

        // 1. leer los personajes del archivo y pegarlos en un array

        try {

            ObjectInputStream leoPersonajes = new ObjectInputStream(new FileInputStream("src/Programacion/Ficheros/Personajes.txt"));

            listaPersonajes = (Personaje[]) leoPersonajes.readObject();
            leoPersonajes.close();

            // 2. se elije un personaje de forma aleatoria y se pega en un Personaje

            indice = (int) (Math.random() * listaPersonajes.length);

            personajeAleatorio = listaPersonajes[indice];

            // 3. introducción y primer menú: iniciar Programacion, sacar por pantalla  las puntuaciones o cerrar Programacion

            try {

                primerMenu();

            } catch (Exception e) {

                System.out.println("No has introducido un número válido, el programa se cerrará");
                System.exit(0);
            }


            // 4. inicio del Programacion: pide iniciales y muestra personajes

            setIniciles();
            nombresPersonajes();

            // 5. desarrollo del Programacion: progreso del Programacion (con sus opciones)

            while(numEleccion !=0) {

                do { // para controlar si el usuario no introduce un número entero

                    verOpciones();

                    if(teclado.hasNextInt()) {

                        numEleccion = teclado.nextInt();

                        opcionesJuego();
                        numValido = true;

                    } else {

                        System.out.println("No has introducido un número válido");
                        teclado.next();
                    }

                }while(!numValido);


                if(numEleccion < 0 || numEleccion > 10){
                    System.out.println("Elige un número válido");
                }

                contador++;

            }

            // 6. muestra la puntuación obtenida y la guarda

            resolver();

            partida = new Puntuacion(iniciales, contador);

            savePuntuacion(partida);

        } catch (IOException e) {

            System.out.println("Fichero de personajes no encontrado, no se puede iniciar el juego");
            System.exit(0);

        } catch (ClassNotFoundException e) {

            System.out.println("No se puede iniciar el juego");
            System.exit(0);

        }
    }

    // EXTRA. métodos necesarios

    // método de inicio del Programacion

    private static void primerMenu() {

        System.out.println("""
            ¡Bienvenido al juego Quien es Quien con personajes de Nintendo!
            ¿Qué deseas hacer? (indica el número)
                                            
            1. Iniciar el juego
            2. Mostrar las mejores puntuaciones
            3. Salir del juego
            """);

        numEleccion = teclado.nextInt();

        switch (numEleccion) {

            case 1:
                System.out.println("¡Comienza el juego!");
                break;

            case 2:
                verPuntuaciones();
                break;

            case 3:
                 salir();
                 break;
        }
    }

    // método para mostrar las puntuaciones

    private static void verPuntuaciones() {

        try {

            ObjectInputStream leoPuntuaciones = new ObjectInputStream(new FileInputStream("src/Programacion/Ficheros/Puntuaciones.txt"));

            puntuaciones = (Puntuacion[]) leoPuntuaciones.readObject();
            leoPuntuaciones.close();

            for(int i = 0; i < puntuaciones.length; i++) {

                System.out.println(puntuaciones[i].getPuntuaciones());
            }

        } catch (IOException e){

            System.out.println("Se ha producido un error, el juego se cerrará");

        } catch (ClassNotFoundException e) {

            System.out.println("Se ha producido un error, el juego se cerrará");

        } finally {

            System.exit(0);

        }

    }

    // método para salir del Programacion

    private static void salir() {

        System.out.println("¡Hasta la próxima!");
        System.exit(0);

    }

    // método de iniciales del jugador

    private static void setIniciles() {

        System.out.println("Escribe tus iniciales");
        iniciales = teclado.next();

        while(iniciales.length() < 2 || iniciales.length() > 5) {

            System.out.println("Deben ser entre 2 y 5 caracteres");

            iniciales = teclado.next();

        }
    }

    // método imprimir personajes por pantalla

    private static void nombresPersonajes() {

        System.out.println("Los personajes son:");

        for (int i = 0; i < listaPersonajes.length; i++){

            System.out.println(listaPersonajes[i].getOnlyNombre());

        }
    }

    // método con las opciones de Programacion

    private static void verOpciones(){

        System.out.println("""
                
                ¿Qué pregunta vas a hacer (indica el número)?
                0. QUIERO RESOLVER
                1. ¿Es un hombre?
                2. ¿Es una mujer?
                3. ¿Es alto?
                4. ¿Es bajo?
                5. ¿El personaje es humano?
                6. ¿Lleva pantalones?
                7. ¿Lleva gorra?
                8. ¿Lleva corona?
                9. ¿Tiene el pelo rubio?
                10. ¿Es moreno?
                """);
    }

    // método del desarrollo del Programacion

    private static void opcionesJuego() {

        switch (numEleccion) {

            case 1:
                System.out.println(personajeAleatorio.isHombre());
                break;
            case 2:
                System.out.println(personajeAleatorio.isMujer());
                break;
            case 3:
                System.out.println(personajeAleatorio.isAlto());
                break;
            case 4:
                System.out.println(personajeAleatorio.isBajo());
                break;
            case 5:
                System.out.println(personajeAleatorio.isHumano());
                break;
            case 6:
                System.out.println(personajeAleatorio.isLlevaPantalones());
                break;
            case 7:
                System.out.println(personajeAleatorio.isLlevaGorra());
                break;
            case 8:
                System.out.println(personajeAleatorio.isLlevaCorona());
                break;
            case 9:
                System.out.println(personajeAleatorio.isRubio());
                break;
            case 10:
                System.out.println(personajeAleatorio.isMoreno());
                break;
        }
    }

    // método para resolver

    private static void resolver() {

        System.out.println("¿Qué personaje es?");
        nombre = teclado.next();

        if (nombre.equalsIgnoreCase(personajeAleatorio.getOnlyNombre())) {

            System.out.println("¡CORRECTO!" + personajeAleatorio.getNombre() + ". " + iniciales + " has obtenido " + contador + " puntos.");

        } else {

            System.out.println("¡GAME OVER!" + personajeAleatorio.getNombre() + ".");
            System.exit(0);
        }
    }

    // método para guardar las puntuaciones

    private static void savePuntuacion(Puntuacion partida){

        try {

            // leo las puntuaciones y las guardo en un array

            ObjectInputStream leoPuntuaciones = new ObjectInputStream(new FileInputStream("src/Programacion/Ficheros/Puntuaciones.txt"));

            puntuaciones = (Puntuacion[]) leoPuntuaciones.readObject();
            leoPuntuaciones.close();

            // si los puntos del último puesto del array son mayores que los de la partida actual, este es sustituido

            if(puntuaciones[puntuaciones.length-1].getPuntos() > partida.getPuntos()) {

                puntuaciones[puntuaciones.length-1] = partida;
            }

            // ordena el array

            for(int i = 0; i < puntuaciones.length-1; i++) {
                for(int j = 0; j < puntuaciones.length-i-1; j++) {

                    if(puntuaciones[j].getPuntos() > puntuaciones[j+1].getPuntos()) {

                        Puntuacion temp = puntuaciones[j];

                        puntuaciones[j] = puntuaciones [j+1];
                        puntuaciones[j+1] = temp;
                    }

                }
            }

            try {

                // sobreescribo el fichero con el array ordenado

                ObjectOutputStream nuevaPuntuacion = new ObjectOutputStream(new FileOutputStream("src/Programacion/Ficheros/Puntuaciones.txt"));

                nuevaPuntuacion.writeObject(puntuaciones);
                nuevaPuntuacion.close();

            } catch(IOException e) {

                System.out.println("Se ha producido un error de escritura");

            }

        } catch (Exception e) {

            System.out.println("Se ha producido un error de lectura");

        }
    }
}
package Programacion;

import java.io.Serializable;

/**
 *
 * @author quino_ku
 */

public class Personaje implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private boolean hombre;
    private boolean mujer;
    private boolean alto;
    private boolean bajo;
    private boolean humano;
    private boolean llevaPantalones;
    private boolean llevaGorra;
    private boolean llevaCorona;
    private boolean rubio;
    private boolean moreno;

    // contructor por defecto

    public Personaje(){}

    // constructor con parámetros

    public Personaje(String nombre, boolean hombre, boolean mujer, boolean alto, boolean bajo, boolean humano,
                     boolean llevaPantalones, boolean llevaGorra, boolean llevaCorona, boolean rubio, boolean moreno) {

        this.nombre = nombre;
        this.hombre = hombre;
        this.mujer = mujer;
        this.alto = alto;
        this.bajo = bajo;
        this.humano = humano;
        this.llevaPantalones = llevaPantalones;
        this.llevaGorra = llevaGorra;
        this.llevaCorona = llevaCorona;
        this.rubio = rubio;
        this.moreno = moreno;
    }

    // métodos getter para acceder el valor de los diferentes atributos

    public String getOnlyNombre() {

        return nombre;
    }

    public String getNombre() {

        return "\nEl personaje es " + nombre;
    }

    public String isHombre(){
        if(hombre){
            return "\nEl personaje es un hombre";
        } else {
            return "\nEl personaje no es un hombre";
        }
    }

    public String isMujer(){
        if(mujer){
            return "\nEl personaje es una mujer";
        } else {
            return "\nEl personaje no es una mujer";
        }
    }

    public String isAlto(){
        if(alto){
            return "\nEl personaje es alto";
        } else {
            return "\nEl personaje es no es alto";
        }
    }

    public String isBajo(){
        if(bajo){
            return "\nEl personaje es bajo";
        } else {
            return "\nEl personaje es no es bajo";
        }
    }

    public String isHumano(){
        if(humano){
            return "\nEl personaje es humano";
        } else {
            return "\nEl personaje no es humano, aunque puede tener características humanoides";
        }
    }

    public String isLlevaPantalones(){
        if(llevaPantalones){
            return "\nEl personaje sí lleva pantalones";
        } else {
            return "\nEl personaje no lleva pantalones";
        }
    }

    public String isLlevaGorra(){
        if(llevaGorra){
            return "\nEl personaje lleva gorra";
        } else {
            return "\nEl personaje no lleva gorra";
        }
    }

    public String isLlevaCorona(){
        if(llevaCorona){
            return "\nEl personaje lleva corona";
        } else {
            return "\nEl personaje no lleva corona";
        }
    }

    public String isRubio(){
        if(rubio){
            return "\nEl personaje es rubio";
        } else {
            return "\nEl personaje no es rubio";
        }
    }

    public String isMoreno(){
        if(moreno){
            return "\nEl personaje es moreno";
        } else {
            return "\nEl personaje no es moreno";
        }
    }
}
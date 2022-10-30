package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Tripulacion
 */

public class Tripulacion {
    /**
     * Declaracion de atributos del objeto
     */
    private String codigo;
    private String nombreClave;
    private ArrayList<Tripulante> tripulantes;

//Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Tripulacion() {
    }

/**
 * Este es el constructor con todos los atributos
 * @param codigo es de tipo String y corresponde al codigo de la tripulacion
 * @param nombreClave es de tipo String y corresponde al nombre clave de la tripulacion
 * @param tripulantes es de tipo ArrayList<Tripulante> y corresponde a la lista de los tripulantes de la tripulacion
 */
    public Tripulacion(String codigo, String nombreClave, ArrayList<Tripulante> tripulantes) {
        this.codigo = codigo;
        this.nombreClave = nombreClave;
        this.tripulantes = tripulantes;
    }

    /**
     * Getters y setters de los atributos del objeto
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreClave() {
        return nombreClave;
    }

    public void setNombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }

    public ArrayList<Tripulante> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(ArrayList<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Tripulacion{" +
                "codigo='" + codigo + '\'' +
                ", nombreClave='" + nombreClave + '\'' +
                ", tripulantes=" + tripulantes +
                '}';
    }
}

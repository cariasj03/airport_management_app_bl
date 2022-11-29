package cr.ac.ucenfotec.entidades;

import java.time.LocalDate;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Tiquete
 */

public class Tiquete {
    /**
     * Declaracion de atributos del objeto
     */
    private LocalDate fecha;
    private String numeroAsiento;
    private String tipoAsiento;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Tiquete() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param fecha es de tipo LocalDate y corresponde a la fecha del tiquete
     * @param numeroAsiento es de tipo String y corresponde al numero de asiento del tiquete
     * @param tipoAsiento es de tipo String y corresponde al tipo de asiento del tiquete
     */
    public Tiquete(LocalDate fecha, String numeroAsiento, String tipoAsiento) {
        this.fecha = fecha;
        this.numeroAsiento = numeroAsiento;
        this.tipoAsiento = tipoAsiento;
    }

    /**
     * Getters y setters de los atributos del objeto
     */
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Tiquete{" +
                "fecha=" + fecha +
                ", numeroAsiento='" + numeroAsiento + '\'' +
                ", tipoAsiento='" + tipoAsiento + '\'' +
                '}';
    }
}

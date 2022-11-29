package cr.ac.ucenfotec.entidades;

import java.util.Objects;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Aeronave
 */

public class Aeronave {
    /**
     * Declaracion de atributos del objeto
     */
    private String placa;
    private String marcaFabricante;
    private String modelo;
    private int capacidad;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Aeronave() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param placa es de tipo String y corresponde a la placa de la aeronave
     * @param marcaFabricante es de tipo String y corresponde a la marca del fabricante de la aeronave
     * @param modelo es de tipo String y corresponde al modelo de la aeronave
     * @param capacidad es de tipo int y corresponde a la capacidad de la aeronave
     */
    public Aeronave(String placa, String marcaFabricante, String modelo, int capacidad) {
        this.placa = placa;
        this.marcaFabricante = marcaFabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    /**
     * Getters y setters de los atributos del objeto
     */
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarcaFabricante() {
        return marcaFabricante;
    }

    public void setMarcaFabricante(String marcaFabricante) {
        this.marcaFabricante = marcaFabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Aeronave{" +
                "placa='" + placa + '\'' +
                ", marcaFabricante='" + marcaFabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeronave aeronave = (Aeronave) o;
        return Objects.equals(placa, aeronave.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }
}
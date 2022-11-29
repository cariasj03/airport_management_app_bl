package cr.ac.ucenfotec.entidades;

import java.util.Objects;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Puerta
 */

public class Puerta {
    /**
     * Declaracion de atributos del objeto
     */
    private String codigo;
    private String nombre;
    private Ubicacion ubicacion;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Puerta() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param codigo es de tipo String y corresponde al codigo de la puerta
     * @param nombre es de tipo String y corresponde al nombre de la puerta
     */
    public Puerta(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = new Ubicacion();
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Puerta{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacion=" + ubicacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puerta puerta = (Puerta) o;
        return Objects.equals(codigo, puerta.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}

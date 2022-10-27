package cr.ac.ucenfotec.bl;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Pais
 */

public class Pais {
    /**
     * Declaracion de atributos del objeto
     */
    private String codigo;
    private String nombre;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Pais() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param codigo es de tipo String y corresponde al codigo del pais
     * @param nombre es de tipo String y corresponde al nombre del pais
     */
    public Pais(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Pais{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

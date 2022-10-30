package cr.ac.ucenfotec.bl;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Aeropuerto
 */

public class Aeropuerto {
    /**
     * Declaracion de atributos del objeto
     */
    private String nombre;
    private String codigo;
    private Pais pais;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Aeropuerto() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param nombre es de tipo String y corresponde al nombre del aeropuerto
     * @param codigo es de tipo String y corresponde al codigo del aeropuerto
     * @param pais es de tipo Pais y corresponde al pais donde esta ubicado el aeropuerto
     */
    public Aeropuerto(String nombre, String codigo, Pais pais) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.pais = pais;
    }

    /**
     * Este es un constructor con los atributos de tipo nativo
     * @param nombre es de tipo String y corresponde al nombre del aeropuerto
     * @param codigo es de tipo String y corresponde al codigo del aeropuerto
     */
    public Aeropuerto(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    /**
     * Getters y setters de los atributos del objeto
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", pais=" + pais +
                '}';
    }
}

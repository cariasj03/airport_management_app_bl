package cr.ac.ucenfotec.bl;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Ubicacion
 */

public class Ubicacion {
    /**
     * Declaracion de atributos del objeto
     */
    private String codigo;
    private int nivel;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Ubicacion() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param codigo es de tipo String y corresponde al codigo de la ubicacion
     * @param nivel es de tipo String y corresponde al nivel de la ubicacion
     */
    public Ubicacion(String codigo, int nivel) {
        this.codigo = codigo;
        this.nivel = nivel;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Ubicacion{" +
                "codigo='" + codigo + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}

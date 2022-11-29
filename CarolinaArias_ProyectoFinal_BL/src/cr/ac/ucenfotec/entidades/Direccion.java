package cr.ac.ucenfotec.entidades;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Direccion
 */

public class Direccion {
    /**
     * Declaracion de atributos del objeto
     */
    private String provincia;
    private String canton;
    private String distrito;
    private String detalleDireccion;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Direccion() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param provincia es de tipo String y corresponde a la provincia de residencia de la persona
     * @param canton es de tipo String y corresponde al canton de residencia de la persona
     * @param distrito es de tipo String y corresponde al distrito de residencia de la persona
     * @param detalleDireccion es de tipo String y corresponde al detalle de la direccion de la residencia de la persona
     */
    public Direccion(String provincia, String canton, String distrito, String detalleDireccion) {
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.detalleDireccion = detalleDireccion;
    }

    /**
     * Getters y setters de los atributos del objeto
     */
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDetalleDireccion() {
        return detalleDireccion;
    }

    public void setDetalleDireccion(String detalleDireccion) {
        this.detalleDireccion = detalleDireccion;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Direccion{" +
                "provincia='" + provincia + '\'' +
                ", canton='" + canton + '\'' +
                ", distrito='" + distrito + '\'' +
                ", detalleDireccion='" + detalleDireccion + '\'' +
                '}';
    }
}
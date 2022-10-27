package cr.ac.ucenfotec.bl;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Aerolinea
 */

public class Aerolinea {
    /**
     * Declaracion de atributos del objeto
     */
    private String nombreComercial;
    private int cedulaJuridica;
    private String nombreEmpresaDuenna;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Aerolinea() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param nombreComercial es de tipo String y corresponde al nombre comercial de la aerolinea
     * @param cedulaJuridica es de tipo int y corresponde a la cedula juridica de la aerolinea
     * @param nombreEmpresaDuenna es de tipo String y corresponde al nombre de la empresa duenna de la aerolinea
     */
    public Aerolinea(String nombreComercial, int cedulaJuridica, String nombreEmpresaDuenna) {
        this.nombreComercial = nombreComercial;
        this.cedulaJuridica = cedulaJuridica;
        this.nombreEmpresaDuenna = nombreEmpresaDuenna;
    }

    /**
     * Getters y setters de los atributos del objeto
     */
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public int getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(int cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getNombreEmpresaDuenna() {
        return nombreEmpresaDuenna;
    }

    public void setNombreEmpresaDuenna(String nombreEmpresaDuenna) {
        this.nombreEmpresaDuenna = nombreEmpresaDuenna;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Aerolinea{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", cedulaJuridica=" + cedulaJuridica +
                ", nombreEmpresaDuenna='" + nombreEmpresaDuenna + '\'' +
                '}';
    }
}

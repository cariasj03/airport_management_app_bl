package cr.ac.ucenfotec.entidades;

import java.util.Objects;

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
    private String logo;

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
     * @param logo es te tipo String y corresponde al logo de la aerolinea
     */
    public Aerolinea(String nombreComercial, int cedulaJuridica, String nombreEmpresaDuenna, String logo) {
        this.nombreComercial = nombreComercial;
        this.cedulaJuridica = cedulaJuridica;
        this.nombreEmpresaDuenna = nombreEmpresaDuenna;
        this.logo = logo;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
                ", logo='" + logo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aerolinea aerolinea = (Aerolinea) o;
        return Objects.equals(nombreComercial, aerolinea.nombreComercial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreComercial);
    }
}
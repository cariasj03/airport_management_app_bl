package cr.ac.ucenfotec.bl;

import java.time.LocalDate;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Tripulante
 */
public class Tripulante extends Persona{
    /**
     * Declaracion de atributos del objeto
     */
    private int aniosExperiencia;
    private LocalDate fechaGraduacion;
    private String numeroLicencia;
    private String puesto;
    private String telefono;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Tripulante() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param id es de tipo String y corresponde al id del tripulante
     * @param nombre es de tipo String y corresponde al nombre del tripulante
     * @param apellidos es de tipo String y corresponde a los apellidos del tripulante
     * @param nacionalidad es de tipo String y corresponde a la nacionalidad del tripulante
     * @param fechaNacimiento es de tipo LocalDate y corresponde a la fecha de nacimiento del tripulante
     * @param edad es de tipo int y corresponde la edad del tripulante
     * @param genero es de tipo String y corresponde al genero del tripulante
     * @param correoElectronico es de tipo String y corresponde al correo electronico del tripulante
     * @param provincia es de tipo String y corresponde a la provincia de residencia del tripulante
     * @param canton es de tipo String y corresponde al canton de residencia del tripulante
     * @param distrito es de tipo String y corresponde al distrito de residencia del tripulante
     * @param detalleDireccion es de tipo String y corresponde al detalle de la direccion de la residencia del tripulante
     * @param aniosExperiencia es de tipo int y corresponde a los anios de experiencia del tripulante
     * @param fechaGraduacion es de tipo LocalDate y corresponde a la fecha de graduacion del tripulante
     * @param numeroLicencia es de tipo String y corresponde al numero de licencia del tripulante
     * @param puesto es de tipo String y corresponde al puesto del tripulante
     * @param telefono es de tipo String y corresponde al telefono del tripulante
     */
    public Tripulante(String id, String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String correoElectronico, String provincia, String canton, String distrito, String detalleDireccion, int aniosExperiencia, LocalDate fechaGraduacion, String numeroLicencia, String puesto, String telefono) {
        super(id, nombre, apellidos, nacionalidad, fechaNacimiento, edad, genero, correoElectronico, provincia, canton, distrito, detalleDireccion);
        this.aniosExperiencia = aniosExperiencia;
        this.fechaGraduacion = fechaGraduacion;
        this.numeroLicencia = numeroLicencia;
        this.puesto = puesto;
        this.telefono = telefono;
    }

    /**
     * Getters y setters de los atributos del objeto
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public LocalDate getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(LocalDate fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Tripulante{" +
                "persona=" + super.toString() +
                "aniosExperiencia=" + aniosExperiencia +
                ", fechaGraduacion=" + fechaGraduacion +
                ", numeroLicencia='" + numeroLicencia + '\'' +
                ", puesto='" + puesto + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

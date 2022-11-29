package cr.ac.ucenfotec.entidades;

import java.time.LocalDate;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Administrador
 */

public class Administrador extends Persona{
    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Administrador() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param id es de tipo String y corresponde al id del administrador
     * @param nombre es de tipo String y corresponde al nombre del administrador
     * @param apellidos es de tipo String y corresponde a los apellidos del administrador
     * @param nacionalidad es de tipo String y corresponde a la nacionalidad del administrador
     * @param fechaNacimiento es de tipo LocalDate y corresponde a la fecha de nacimiento del administrador
     * @param edad es de tipo int y corresponde la edad del administrador
     * @param genero es de tipo String y corresponde al genero del administrador
     * @param correoElectronico es de tipo String y corresponde al correo electronico del administrador
     * @param direccion es de tipo Direccion y corresponde a la direccion del administrador
     * @param contrasena es de tipo String y corresponde a la contrasena del administrador
     */
    public Administrador(String id, String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String correoElectronico, Direccion direccion, String contrasena) {
        super(id, nombre, apellidos, nacionalidad, fechaNacimiento, edad, genero, correoElectronico, direccion, contrasena);
    }

    /**
     * Este es el constructor con solo el id y la contrasena
     * @param id es de tipo String y corresponde a la identificacion del administrador
     * @param contrasena es de tipo String y corresponde a la contrasena del administrador
     */
    public Administrador(String id, String contrasena) {
        super(id, contrasena);
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Administrador{" +
                "persona=" + super.toString() +
                '}';
    }
}

package cr.ac.ucenfotec.bl;

import java.time.LocalDate;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Usuario
 */

public class Usuario extends Persona{
    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Usuario() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param id es de tipo String y corresponde al id del usuario
     * @param nombre es de tipo String y corresponde al nombre del usuario
     * @param apellidos es de tipo String y corresponde a los apellidos del usuario
     * @param nacionalidad es de tipo String y corresponde a la nacionalidad del usuario
     * @param fechaNacimiento es de tipo LocalDate y corresponde a la fecha de nacimiento del usuario
     * @param edad es de tipo int y corresponde la edad del usuario
     * @param genero es de tipo String y corresponde al genero del usuario
     * @param correoElectronico es de tipo String y corresponde al correo electronico del usuario
     * @param provincia es de tipo String y corresponde a la provincia de residencia del usuario
     * @param canton es de tipo String y corresponde al canton de residencia del usuario
     * @param distrito es de tipo String y corresponde al distrito de residencia del usuario
     * @param detalleDireccion es de tipo String y corresponde al detalle de la direccion de la residencia del usuario
     */
    public Usuario(String id, String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String correoElectronico, String provincia, String canton, String distrito, String detalleDireccion) {
        super(id, nombre, apellidos, nacionalidad, fechaNacimiento, edad, genero, correoElectronico, provincia, canton, distrito, detalleDireccion);
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "persona=" + super.toString() +
                '}';
    }
}

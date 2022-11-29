package cr.ac.ucenfotec.entidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Persona
 */
public class Persona {
    /**
     * Declaracion de atributos del objeto
     */
    private String id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    private int edad;
    private String genero;
    private String correoElectronico;
    private Direccion direccion;
    private String contrasena;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Persona() {
    }

    /**
     * Este es el constructor con todos los atributos
     * @param id es de tipo String y corresponde a la identificacion de la persona
     * @param nombre es de tipo String y corresponde al nombre de la persona
     * @param apellidos es de tipo String y corresponde a los apellidos de la persona
     * @param nacionalidad es de tipo String y corresponde a la nacionalidad de la persona
     * @param fechaNacimiento es de tipo LocalDate y corresponde a la fecha de nacimiento de la persona
     * @param edad es de tipo int y corresponde la edad de la persona
     * @param genero es de tipo String y corresponde al genero de la persona
     * @param correoElectronico es de tipo String y corresponde al correo electronico de la persona
     * @param direccion es de tipo Direccion y corresponde a la direccion de la persona
     * @param contrasena es de tipo String y corresponde a la contrasena de la persona
     */
    public Persona(String id, String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String correoElectronico, Direccion direccion, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.genero = genero;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    /**
     * Este es el constructor con solo el id y la contrasena
     * @param id es de tipo String y corresponde a la identificacion de la persona
     * @param contrasena es de tipo String y corresponde a la contrasena de la persona
     */
    public Persona(String id, String contrasena) {
        this.id = id;
        this.contrasena = contrasena;
    }

    /**
     * Getters y setters de los atributos del objeto
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", direccion=" + direccion +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
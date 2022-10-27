package cr.ac.ucenfotec.bl;

import java.time.LocalDate;

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
    private String provincia;
    private String canton;
    private String distrito;
    private String detalleDireccion;

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
     * @param provincia es de tipo String y corresponde a la provincia de residencia de la persona
     * @param canton es de tipo String y corresponde al canton de residencia de la persona
     * @param distrito es de tipo String y corresponde al distrito de residencia de la persona
     * @param detalleDireccion es de tipo String y corresponde al detalle de la direccion de la residencia de la persona
     */
    public Persona(String id, String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String correoElectronico, String provincia, String canton, String distrito, String detalleDireccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.genero = genero;
        this.correoElectronico = correoElectronico;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.detalleDireccion = detalleDireccion;
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
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", provincia='" + provincia + '\'' +
                ", canton='" + canton + '\'' +
                ", distrito='" + distrito + '\'' +
                ", detalleDireccion='" + detalleDireccion + '\'' +
                '}';
    }
}

package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.DAO.AdministradorDAO;
import cr.ac.ucenfotec.DAO.PersonaDAO;
import cr.ac.ucenfotec.DAO.TripulanteDAO;
import cr.ac.ucenfotec.DAO.UsuarioDAO;
import cr.ac.ucenfotec.entidades.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar la manipulacion de los objetos Persona
 */

public class GestorPersonas {
    private PersonaDAO personaDAO;
    private AdministradorDAO administradorDAO;
    private UsuarioDAO usuarioDAO;
    private TripulanteDAO tripulanteDAO;

    public GestorPersonas() {
        personaDAO = new PersonaDAO();
        administradorDAO = new AdministradorDAO();
        usuarioDAO = new UsuarioDAO();
        tripulanteDAO = new TripulanteDAO();
    }

    /**
     * Metodo para crear un administrador
     * @param tmpAdministrador es de tipo Administrador y corresponde al administrador por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se creo con exito el administrador o no
     */
    public String insertarAdministrador(Administrador tmpAdministrador) {
        String mensaje;
        if (existePersona(tmpAdministrador.getId())) {
            mensaje = "El administrador no puede ser creado debido a que ya existe en el sistema una persona registrada con ese ID.";
        } else {
            administradorDAO.insertarAdministrador(tmpAdministrador);
            mensaje = "El administrador fue creado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para actualizar un administrador
     * @param tmpAdministrador es de tipo Administrador y corresponde al administrador por actualizar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se actualizo con exito el administrador o no
     */
    public String actualizarAdministrador(Administrador tmpAdministrador) {
        String mensaje;
        if (!existeAdministrador(tmpAdministrador.getId())) {
            mensaje = "El administrador no puede ser actualizado debido a que no existe en el sistema un administrador registrado con ese ID.";
        } else {
            administradorDAO.actualizarAdministrador(tmpAdministrador);
            mensaje = "El administrador fue actualizado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un administrador
     * @param tmpAdministrador es de tipo Administrador y corresponde al administrador por eliminar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se elimino con exito el administrador o no
     */
    public String eliminarAdministrador(Administrador tmpAdministrador) {
        String mensaje;
        if (!existeAdministrador(tmpAdministrador.getId())) {
            mensaje = "El administrador no puede ser eliminado debido a que no existe en el sistema un administrador registrado con ese ID.";
        } else {
            administradorDAO.eliminarAdministrador(tmpAdministrador);
            mensaje = "El administrador fue eliminado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para listar los administradores
     */
    public ArrayList<Administrador> listarAdministradores() {
        return administradorDAO.listarAdministradores();
    }

    /**
     * Metodo para crear un usuario
     * @param tmpUsuario es de tipo Usuario y corresponde al usuario por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se creo con exito el usuario o no
     */
    public String insertarUsuario(Usuario tmpUsuario) {
        String mensaje;
        if (existePersona(tmpUsuario.getId())) {
            mensaje = "El usuario no puede ser creado debido a que ya existe en el sistema una persona registrada con ese ID.";
        } else {
            usuarioDAO.insertarUsuario(tmpUsuario);
            mensaje = "El usuario fue creado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para actualizar un usuario
     * @param tmpUsuario es de tipo Usuario y corresponde al usuario por actualizar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se actualizo con exito el usuario o no
     */
    public String actualizarUsuario(Usuario tmpUsuario) {
        String mensaje;
        if (!existeUsuario(tmpUsuario.getId())) {
            mensaje = "El usuario no puede ser actualizado debido a que no existe en el sistema un usuario registrado con ese ID.";
        } else {
            usuarioDAO.actualizarUsuario(tmpUsuario);
            mensaje = "El usuario fue actualizado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un usuario
     * @param tmpUsuario es de tipo Usuario y corresponde al usuario por eliminar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se elimino con exito el usuario o no
     */
    public String eliminarUsuario(Usuario tmpUsuario) {
        String mensaje;
        if (!existeUsuario(tmpUsuario.getId())) {
            mensaje = "El usuario no puede ser eliminado debido a que no existe en el sistema un usuario registrado con ese ID.";
        } else {
            usuarioDAO.eliminarUsuario(tmpUsuario);
            mensaje = "El usuario fue eliminado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para listar los usuarios
     */
    public ArrayList<Usuario> listarUsuarios() {
        return usuarioDAO.listarUsuarios();
    }

    /**
     * Metodo para crear un tripulante
     * @param tmpTripulante es de tipo Tripulante y corresponde al tripulante por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se creo con exito el tripulante o no
     */
    public String insertarTripulante(Tripulante tmpTripulante) {
        String mensaje;
        if (existePersona(tmpTripulante.getId())) {
            mensaje = "El tripulante no puede ser creado debido a que ya existe en el sistema una persona registrada con ese ID.";
        } else {
            tripulanteDAO.insertarTripulante(tmpTripulante);
            mensaje = "El tripulante fue creado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para actualizar un tripulante
     * @param tmpTripulante es de tipo Tripulante y corresponde al tripulante por actualizar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se actualizo con exito el tripulante o no
     */
    public String actualizarTripulante(Tripulante tmpTripulante) {
        String mensaje;
        if (!existeTripulante(tmpTripulante.getId())) {
            mensaje = "El tripulante no puede ser actualizado debido a que no existe en el sistema un tripulante registrado con ese ID.";
        } else {
            tripulanteDAO.actualizarTripulante(tmpTripulante);
            mensaje = "El tripulante fue actualizado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un tripulante
     * @param tmpTripulante es de tipo Tripulante y corresponde al tripulante por eliminar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se elimino con exito el tripulante o no
     */
    public String eliminarTripulante(Tripulante tmpTripulante) {
        String mensaje;
        if (!existeTripulante(tmpTripulante.getId())) {
            mensaje = "El tripulante no puede ser eliminado debido a que no existe en el sistema un tripulante registrado con ese ID.";
        } else {
            tripulanteDAO.eliminarTripulante(tmpTripulante);
            mensaje = "El tripulante fue eliminado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para listar los tripulantes
     */
    public ArrayList<Tripulante> listarTripulantes() {
        return tripulanteDAO.listarTripulantes();
    }

    /**
     * Metodo para verificar si la persona ya se encuentra registrado en el sistema
     * @param idPersona es de tipo String y corresponde al ID de la persona por verificar
     * @return existePersona es de tipo boolean y devuelve si la persona ya existe en el sistema
     */
    public boolean existePersona(String idPersona) {
        boolean existePersona = false;

        for (Persona persona : personaDAO.listarPersonas()) {
            if (persona.getId().equals(idPersona)) {
                existePersona = true;
                break;
            }
        }
        return existePersona;
    }

    /**
     * Metodo para verificar si el usuario ya se encuentra registrado en el sistema
     * @param idUsuario es de tipo String y corresponde al ID del usuario por verificar
     * @return existeUsuario es de tipo boolean y devuelve si el usuario ya existe en el sistema
     */
    public boolean existeUsuario(String idUsuario) {
        boolean existeUsuario = false;

        for (Usuario usuario : usuarioDAO.listarUsuarios()) {
            if (usuario.getId().equals(idUsuario)) {
                existeUsuario = true;
                break;
            }
        }
        return existeUsuario;
    }

    /**
     * Metodo para verificar si el administrador ya se encuentra registrado en el sistema
     * @param idAdministrador es de tipo String y corresponde al ID del administrador por verificar
     * @return existeAdministrador es de tipo boolean y devuelve si el administrador ya existe en el sistema
     */
    public boolean existeAdministrador(String idAdministrador) {
        boolean existeAdministrador = false;

        for (Administrador administrador : administradorDAO.listarAdministradores()) {
            if (administrador.getId().equals(idAdministrador)) {
                existeAdministrador = true;
                break;
            }
        }
        return existeAdministrador;
    }

    /**
     * Metodo para verificar si el tripulante ya se encuentra registrado en el sistema
     * @param idTripulante es de tipo String y corresponde al ID del tripulante por verificar
     * @return existeTripulante es de tipo boolean y devuelve si el tripulante ya existe en el sistema
     */
    public boolean existeTripulante(String idTripulante) {
        boolean existeTripulante = false;

        for (Tripulante tripulante : tripulanteDAO.listarTripulantes()) {
            if (tripulante.getId().equals(idTripulante)) {
                existeTripulante = true;
                break;
            }
        }
        return existeTripulante;
    }

    /**
     * Metodo para verificar que las credenciales de la persona sean correctas
     * @param tmpPersona es de tipo Persona y corresponde a la persona por verificar
     * @return login es de tipo boolean y devuelve si las credenciales de la persona son correctas
     */
    public boolean verificarCredenciales (Persona tmpPersona) {
        ArrayList<Persona> personas = personaDAO.listarPersonas();
        boolean login = false;
        for (Persona persona : personas) {
            if(persona.equals(tmpPersona)) {
                if(persona.getContrasena().equals(tmpPersona.getContrasena())){
                    login = true;
                }
            }
        }
        return login;
    }

    /**
     * Metodo para verificar que las credenciales de la persona sean correctas
     * @param tmpPersona es de tipo Persona y corresponde a la persona por verificar
     * @return login es de tipo boolean y devuelve si las credenciales de la persona son correctas
     */
    public boolean loginPersona (Persona tmpPersona) {
        boolean login = false;
        if(existePersona(tmpPersona.getId())) {
            login = verificarCredenciales(tmpPersona);
        }
        return login;
    }

    /**
     * Metodo para buscar una persona dada su identificacion
     * @param idPersona es de tipo String y corresponde a la identificacion de la persona por buscar
     * @return persona es de tipo Persona y corrresponde a la persona buscada
     */
    public Persona buscarPersona (String idPersona) {
        Persona persona = new Persona();
        if(existePersona(idPersona)){
            persona = personaDAO.buscarPersona(idPersona);
        } else {
            persona = null;
        }
        return persona;
    }

    /**
     * Metodo para saber el tipo de la persona
     * @param tmpPersona es de tipo Persona y corresponde a la persona por verificar
     * @return tipoPersona es de tipo int y devuelve el tipo de la persona
     */
    public int tipoPersona(Persona tmpPersona){
        int tipoPersona = 0;

        for (Administrador administrador:administradorDAO.listarAdministradores()) {
            if (administrador.getId().equals(tmpPersona.getId())){
                tipoPersona = 1;
                break;
            }
        }
        for (Usuario usuario : usuarioDAO.listarUsuarios()) {
            if (usuario.getId().equals(tmpPersona.getId())) {
                tipoPersona = 2;
                break;
            }
        }
        for (Tripulante tripulante : tripulanteDAO.listarTripulantes()) {
            if (tripulante.getId().equals(tmpPersona.getId())) {
                tipoPersona = 3;
                break;
            }
        }
        return tipoPersona;
    }

    /**
     * Metodo para actualizar una persona
     * @param tmpPersona es de tipo Persona y corresponde a la persona por actualizar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se actualizo con exito los datos de la persona o no
     */
    public String actualizarPersona(Persona tmpPersona) {
        String mensaje;
        if (!existePersona(tmpPersona.getId())) {
            mensaje = "Los datos del perfil no pueden ser actualizados debido a que no existe en el sistema una persona registrada con ese ID.";
        } else {
            personaDAO.actualizarPersona(tmpPersona);
            mensaje = "Los datos del perfil fueron actualizados con éxito.";
        }
        return mensaje;
    }
}
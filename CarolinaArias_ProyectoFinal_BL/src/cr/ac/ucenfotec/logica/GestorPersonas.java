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
     * Metodo para verificar que las credenciales del administrador sean correctas
     * @param tmpAdministrador es de tipo Administrador y corresponde al administrador por verificar
     * @return login es de tipo boolean y devuelve si las credenciales del administrador son correctas
     */
    public boolean loginAdministrador (Administrador tmpAdministrador) {
        boolean login = administradorDAO.loginAdministrador(tmpAdministrador);
        return login;
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
}
package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.entidades.*;
import java.util.ArrayList;

public class Gestor {
    private AdministradorDAO administradorDAO;
    private AeropuertoDAO aeropuertoDAO;

    public Gestor() {
        administradorDAO = new AdministradorDAO();
        aeropuertoDAO = new AeropuertoDAO();
    }

    /**
     * Metodo para crear un administrador
     * @param tmpAdministrador es de tipo Administrador y corresponde al administrador por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se creo con exito el administrador o no
     */
    public String insertarAdministrador(Administrador tmpAdministrador) {
        String mensaje;
        if (existeAdministrador(tmpAdministrador)) {
            mensaje = "El administrador no puede ser creado debido a que ya existe en el sistema un administrador registrado con ese ID.";
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
        if (!existeAdministrador(tmpAdministrador)) {
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
        if (!existeAdministrador(tmpAdministrador)) {
            mensaje = "El administrador no puede ser eliminado debido a que no existe en el sistema un administrador registrado con ese ID.";
        } else {
            administradorDAO.eliminarAdministrador(tmpAdministrador);
            mensaje = "El administrador fue eliminado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si el administrador ya se encuentra registrado en el sistema
     * @param tmpAdministrador es de tipo Administrador y corresponde al administrador por verificar
     * @return existeAdministrador es de tipo boolean y devuelve si el administrador ya existe en el sistema
     */
    public boolean existeAdministrador(Administrador tmpAdministrador) {
        boolean existeAdministrador = false;

        for (Administrador administrador : administradorDAO.listarAdministradores()) {
            if (administrador.equals(tmpAdministrador)) {
                existeAdministrador = true;
                break;
            }
        }
        return existeAdministrador;
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
     * Metodo para crear un aeropuerto
     * @param tmpAeropuerto es de tipo Aeropuerto y corresponde al aeropuerto por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se insertó con exito el aeropuerto o no
     */
    public String insertarAeropuerto (Aeropuerto tmpAeropuerto)
    {
        String mensaje;
        if (existeAeropuerto(tmpAeropuerto)) {
            mensaje = "El aeropuerto no puede ser registrado debido a que ya existe en el sistema un aeropuerto registrado con ese código.";
        } else {
            aeropuertoDAO.insertarAeropuerto(tmpAeropuerto);
            mensaje = "El aeropuerto fue registrado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si el aeropuerto ya se encuentra registrado en el sistema
     * @param tmpAeropuerto es de tipo Aeropuerto y corresponde al aeropuerto por verificar
     * @return existeAdministrador es de tipo boolean y devuelve si el aeropuerto ya existe en el sistema
     */
    public boolean existeAeropuerto (Aeropuerto tmpAeropuerto) {
        boolean existeAeropuerto = false;

        for(Aeropuerto aeropuerto:aeropuertoDAO.listarAeropuertos()) {
            if (aeropuerto.equals(tmpAeropuerto)) {
                existeAeropuerto = true;
                break;
            }
        }
        return existeAeropuerto;
    }

    /**
     * Metodo para listar los aeropuertos
     */
    public ArrayList<Aeropuerto> listarAeropuertos() {
        return aeropuertoDAO.listarAeropuertos();
    }

    /**
     * Metodo para actualizar un aeropuerto
     * @param tmpAeropuerto es de tipo Aeropuerto y corresponde al aeropuerto por actualizar
     */
    public String actualizarAeropuerto(Aeropuerto tmpAeropuerto) {
        String mensaje;
        if (!existeAeropuerto(tmpAeropuerto)) {
            mensaje = "El aeropuerto no puede ser actualizado debido a que no existe en el sistema un administrador registrado con ese ID.";
        } else {
            aeropuertoDAO.actualizarAeropuerto(tmpAeropuerto);
            mensaje = "El aeropuerto fue actualizado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un aeropuerto
     * @param tmpAeropuerto es de tipo Aeropuerto y corresponde al aeropuerto por eliminar
     */
    public String eliminarAeropuerto(Aeropuerto tmpAeropuerto) {
        String mensaje;
        if (!existeAeropuerto(tmpAeropuerto)) {
            mensaje = "El aeropuerto no puede ser eliminado debido a que no existe en el sistema un administrador registrado con ese ID.";
        } else {
            aeropuertoDAO.eliminarAeropuerto(tmpAeropuerto);
            mensaje = "El aeropuerto fue eliminado con éxito.";
        }
        return mensaje;
    }
}
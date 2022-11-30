package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.entidades.*;
import java.util.ArrayList;

public class Gestor {
    private AdministradorDAO administradorDAO;
    private AeropuertoDAO aeropuertoDAO;
    private VueloDAO vueloDAO;
    private UbicacionDAO ubicacionDAO;

    public Gestor() {
        administradorDAO = new AdministradorDAO();
        aeropuertoDAO = new AeropuertoDAO();
        vueloDAO = new VueloDAO();
        ubicacionDAO = new UbicacionDAO();
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
     * @return existeAeropuerto es de tipo boolean y devuelve si el aeropuerto ya existe en el sistema
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

    /**
     * Metodo para crear un vuelo
     * @param tmpVuelo es de tipo Vuelo y corresponde al vuelo por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se insertó con exito el vuelo o no
     */
    public String insertarVuelo (Vuelo tmpVuelo)
    {
        String mensaje;
        if (existeVuelo(tmpVuelo)) {
            mensaje = "El vuelo no puede ser registrado debido a que ya existe en el sistema un vuelo registrado con ese número.";
        } else {
            vueloDAO.insertarVuelo(tmpVuelo);
            mensaje = "El vuelo fue registrado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si el vuelo ya se encuentra registrado en el sistema
     * @param tmpVuelo es de tipo Vuelo y corresponde al vuelo por verificar
     * @return existeVuelo es de tipo boolean y devuelve si el vuelo ya existe en el sistema
     */
    public boolean existeVuelo (Vuelo tmpVuelo) {
        boolean existeVuelo = false;

        for(Vuelo vuelo:vueloDAO.listarVuelos()) {
            if (vuelo.equals(tmpVuelo)) {
                existeVuelo = true;
                break;
            }
        }
        return existeVuelo;
    }

    /**
     * Metodo para listar los vuelos
     */
    public ArrayList<Vuelo> listarVuelos() {
        return vueloDAO.listarVuelos();
    }

    /**
     * Metodo para actualizar un vuelo
     * @param tmpVuelo es de tipo Vuelo y corresponde al vuelo por actualizar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se actualizo con exito el vuelo o no
     */
    public String actualizarVuelo (Vuelo tmpVuelo)
    {
        String mensaje;
        if (!existeVuelo(tmpVuelo)) {
            mensaje = "El vuelo no puede ser actualizado debido a que no existe en el sistema un vuelo registrado con ese número.";
        } else {
            vueloDAO.actualizarVuelo(tmpVuelo);
            mensaje = "El vuelo fue actualizado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un vuelo
     * @param tmpVuelo es de tipo Vuelo y corresponde al vuelo por eliminar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se elimino con exito el vuelo o no
     */
    public String eliminarVuelo (Vuelo tmpVuelo)
    {
        String mensaje;
        if (!existeVuelo(tmpVuelo)) {
            mensaje = "El vuelo no puede ser eliminado debido a que no existe en el sistema un vuelo registrado con ese número.";
        } else {
            vueloDAO.eliminarVuelo(tmpVuelo);
            mensaje = "El vuelo fue eliminado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para crear una ubicacion
     * @param tmpUbicacion es de tipo Ubicacion y corresponde a la ubicacion por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se inserto con exito la ubicacion o no
     */
    public String insertarUbicacion (Ubicacion tmpUbicacion)
    {
        String mensaje;
        if (existeUbicacion(tmpUbicacion)) {
            mensaje = "La ubicación no puede ser registrada debido a que ya existe en el sistema una ubicación registrada con ese código.";
        } else {
            ubicacionDAO.insertarUbicacion(tmpUbicacion);
            mensaje = "La ubicación fue registrada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si la ubicacion ya se encuentra registrada en el sistema
     * @param tmpUbicacion es de tipo Ubicacion y corresponde a la ubicacion por verificar
     * @return existeUbicacion es de tipo boolean y devuelve si la ubicacion ya existe en el sistema
     */
    public boolean existeUbicacion (Ubicacion  tmpUbicacion) {
        boolean existeUbicacion = false;

        for(Ubicacion  ubicacion:ubicacionDAO.listarUbicaciones()) {
            if (ubicacion.equals(tmpUbicacion)) {
                existeUbicacion = true;
                break;
            }
        }
        return existeUbicacion;
    }

    /**
     * Metodo para listar las ubicaciones
     */
    public ArrayList<Ubicacion> listarUbicaciones() {
        return ubicacionDAO.listarUbicaciones();
    }

    /**
     * Metodo para actualizar una ubicacion
     * @param tmpUbicacion es de tipo Ubicacion y corresponde a la ubicacion por actualizar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se actualizo con exito la ubicacion o no
     */
    public String actualizarUbicacion (Ubicacion tmpUbicacion)
    {
        String mensaje;
        if (!existeUbicacion(tmpUbicacion)) {
            mensaje = "La ubicación no puede ser actualizada debido a que no existe en el sistema una ubicación registrada con ese código.";
        } else {
            ubicacionDAO.actualizarUbicacion(tmpUbicacion);
            mensaje = "La ubicación fue actualizada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar una ubicacion
     * @param tmpUbicacion es de tipo Ubicacion y corresponde a la ubicacion por eliminar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se elimino con exito la ubicacion o no
     */
    public String eliminarUbicacion (Ubicacion tmpUbicacion)
    {
        String mensaje;
        if (!existeUbicacion(tmpUbicacion)) {
            mensaje = "La ubicación no puede ser eliminada debido a que no existe en el sistema una ubicación registrada con ese código.";
        } else {
            ubicacionDAO.eliminarUbicacion(tmpUbicacion);
            mensaje = "La ubicación fue eliminada con éxito.";
        }
        return mensaje;
    }
}
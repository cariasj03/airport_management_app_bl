package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.DAO.UbicacionDAO;
import cr.ac.ucenfotec.entidades.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar la manipulacion de los objetos Ubicacion
 */

public class GestorUbicaciones {
    private UbicacionDAO ubicacionDAO;

    public GestorUbicaciones() {
        ubicacionDAO = new UbicacionDAO();
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
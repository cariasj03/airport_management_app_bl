package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.DAO.AeropuertoDAO;
import cr.ac.ucenfotec.entidades.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar la manipulacion de los objetos Aeropuerto
 */

public class GestorAeropuertos {
    private AeropuertoDAO aeropuertoDAO;

    public GestorAeropuertos() {
        aeropuertoDAO = new AeropuertoDAO();
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
            mensaje = "El aeropuerto no puede ser actualizado debido a que no existe en el sistema un aeropuerto registrado con ese código.";
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
            mensaje = "El aeropuerto no puede ser eliminado debido a que no existe en el sistema un aeropuerto registrado con ese código.";
        } else {
            aeropuertoDAO.eliminarAeropuerto(tmpAeropuerto);
            mensaje = "El aeropuerto fue eliminado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para ver si un aeropuerto tiene vuelos asignados
     * @param aeropuerto es de tipo Aeropuerto y corresponde al aeropuerto por verificar
     */
    public boolean tieneVuelosAsignados(Aeropuerto aeropuerto) {
        return aeropuertoDAO.tieneVuelosAsignados(aeropuerto);
    }
}

package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.entidades.Tripulacion;
import cr.ac.ucenfotec.DAO.TripulacionDAO;
import cr.ac.ucenfotec.entidades.Tripulante;
import cr.ac.ucenfotec.DAO.TripulanteDAO;

import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar la manipulacion de los objetos Tripulacion
 */

public class GestorTripulaciones {
    private TripulacionDAO tripulacionDAO;
    private TripulanteDAO tripulanteDAO;

    public GestorTripulaciones() {
        tripulacionDAO = new TripulacionDAO();
        tripulanteDAO = new TripulanteDAO();
    }

    /**
     * Metodo para crear un tripulacion
     * @param tmpTripulacion es de tipo Tripulacion y corresponde al tripulacion por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se insertó con exito el tripulacion o no
     */
    public String insertarTripulacion (Tripulacion tmpTripulacion)
    {
        String mensaje;
        if (existeTripulacion(tmpTripulacion)) {
            mensaje = "La tripulación no puede ser registrada debido a que ya existe en el sistema una tripulación registrada con ese código.";
        } else {
            tripulacionDAO.insertarTripulacion(tmpTripulacion);
            mensaje = "La tripulación fue registrada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si el tripulacion ya se encuentra registrado en el sistema
     * @param tmpTripulacion es de tipo Tripulacion y corresponde al tripulacion por verificar
     * @return existeTripulacion es de tipo boolean y devuelve si el tripulacion ya existe en el sistema
     */
    public boolean existeTripulacion (Tripulacion tmpTripulacion) {
        boolean existeTripulacion = false;

        for(Tripulacion tripulacion:tripulacionDAO.listarTripulaciones()) {
            if (tripulacion.equals(tmpTripulacion)) {
                existeTripulacion = true;
                break;
            }
        }
        return existeTripulacion;
    }

    /**
     * Metodo para listar las tripulaciones
     */
    public ArrayList<Tripulacion> listarTripulaciones() {
        return tripulacionDAO.listarTripulaciones();
    }

    /**
     * Metodo para actualizar un tripulacion
     * @param tmpTripulacion es de tipo Tripulacion y corresponde al tripulacion por actualizar
     */
    public String actualizarTripulacion(Tripulacion tmpTripulacion) {
        String mensaje;
        if (!existeTripulacion(tmpTripulacion)) {
            mensaje = "La tripulación no puede ser actualizada debido a que no existe en el sistema una tripulación registrada con ese código.";
        } else {
            tripulacionDAO.actualizarTripulacion(tmpTripulacion);
            mensaje = "La tripulación fue actualizada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un tripulacion
     * @param tmpTripulacion es de tipo Tripulacion y corresponde al tripulacion por eliminar
     */
    public String eliminarTripulacion(Tripulacion tmpTripulacion) {
        String mensaje;
        if (!existeTripulacion(tmpTripulacion)) {
            mensaje = "La tripulación no puede ser eliminada debido a que no existe en el sistema una tripulación registrada con ese código.";
        } else {
            tripulacionDAO.eliminarTripulacion(tmpTripulacion);
            mensaje = "La tripulación fue eliminada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para agregar un tripulante a una tripulacion
     * @param tmpTripulante es de tipo Tripulantes y corresponde al tripulante a agregar
     * @param tmpTripulacion es de tipo Tripulacion y corresponde a la tripulacion a la que se va a agregar el tripulante
     */
    public String agregarTripulanteATripulacion(Tripulante tmpTripulante, Tripulacion tmpTripulacion) {
        String mensaje;
        if (existeTripulanteEnTripulacion(tmpTripulante.getId(), tmpTripulacion)) {
            mensaje = "El tripulante no puede ser agregado a la tripulación porque ya se encuentra en ella.";
        } else {
            if(tieneTripulacion(tmpTripulante.getId(), tmpTripulacion)) {
                mensaje = "El tripulante no puede ser agregado a la tripulación porque ya se encuentra en otra tripulación.";
            } else {
                tripulanteDAO.agregarTripulanteATripulacion(tmpTripulante, tmpTripulacion);
                mensaje = "El tripulante " + tmpTripulante.getNombre() + " " + tmpTripulante.getApellidos() + " fue agregado con éxito a la tripulación " + tmpTripulacion.getNombreClave() + ".";
            }
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un tripulante de una tripulacion
     * @param tmpTripulante es de tipo Tripulantes y corresponde al tripulante a agregar
     * @param tmpTripulacion es de tipo Tripulacion y corresponde a la tripulacion a la que se va a agregar el tripulante
     */
    public String eliminarTripulanteDeTripulacion(Tripulante tmpTripulante, Tripulacion tmpTripulacion) {
        String mensaje;
        if (!existeTripulanteEnTripulacion(tmpTripulante.getId(), tmpTripulacion)) {
            mensaje = "El tripulante no puede ser eliminado de la tripulación porque no se encuentra en ella.";
        } else {
                tripulanteDAO.eliminarTripulanteDeTripulacion(tmpTripulante, tmpTripulacion);
                mensaje = "El tripulante " + tmpTripulante.getNombre() + " " + tmpTripulante.getApellidos() + " fue eliminado con éxito de la tripulación " + tmpTripulacion.getNombreClave() + ".";
            }
        return mensaje;
    }

    /**
     * Metodo para verificar si el tripulante ya se encuentra en una tripulacion en especifico
     * @param idTripulante es de tipo String y corresponde al ID del tripulante por verificar
     * @param tripulacion es de tipo Tripulacion y corresponde a la tripulacion por verificar
     * @return existeTripulante es de tipo boolean y devuelve si el tripulante ya se encuentra en una tripulacion en especifico
     */
    public boolean existeTripulanteEnTripulacion(String idTripulante, Tripulacion tripulacion) {
        boolean existeTripulante = false;

        for (Tripulante tripulante : tripulanteDAO.listarTripulantesDeTripulacion(tripulacion)) {
            if (tripulante.getId().equals(idTripulante)) {
                existeTripulante = true;
                break;
            }
        }
        return existeTripulante;
    }

    /**
     * Metodo para verificar si el tripulante ya se encuentra en una tripulacion
     * @param idTripulante es de tipo String y corresponde al ID del tripulante por verificar
     * @param tripulacion es de tipo Tripulacion y corresponde a la tripulacion por verificar
     * @return existeTripulante es de tipo boolean y devuelve si el tripulante ya se encuentra en una tripulacion
     */
    public boolean tieneTripulacion(String idTripulante, Tripulacion tripulacion) {
        boolean tieneTripulacion = false;

        for (Tripulante tripulante : tripulanteDAO.listarTripulantesAsignadosATripulacion(tripulacion)) {
            if (tripulante.getId().equals(idTripulante)) {
                tieneTripulacion = true;
                break;
            }
        }
        return tieneTripulacion;
    }

    /**
     * Metodo para verificar si una tripulacion tiene tripulantes
     * @param tripulacion es de tipo Tripulacion y corresponde a la tripulacion por verificar
     * @return existeTripulante es de tipo boolean y devuelve si la tripulacion tiene tripulantes
     */
    public boolean tieneTripulantes(Tripulacion tripulacion) {
        boolean tieneTripulantes = false;
        int cantidadTripulantes = tripulacionDAO.cantidadTripulantes(tripulacion);
        if (cantidadTripulantes > 0) {
            tieneTripulantes = true;
        }
        return tieneTripulantes;
    }

    /**
     * Metodo para listar los tripulantes de una tripulacion
     */
    public ArrayList<Tripulante> listarTripulantesDeTripulacion(Tripulacion tripulacion) {
        return tripulanteDAO.listarTripulantesDeTripulacion(tripulacion);
    }
}

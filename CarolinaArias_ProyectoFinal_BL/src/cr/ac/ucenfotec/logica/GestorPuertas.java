package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.DAO.PuertaDAO;
import cr.ac.ucenfotec.entidades.Puerta;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar la manipulacion de los objetos Puerta
 */

public class GestorPuertas {
    private PuertaDAO puertaDAO;

    public GestorPuertas() {
        puertaDAO = new PuertaDAO();
    }

    /**
     * Metodo para crear una puerta
     * @param tmpPuerta es de tipo Puerta y corresponde a la puerta por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se insertó con exito la puerta o no
     */
    public String insertarPuerta (Puerta tmpPuerta)
    {
        String mensaje;
        if (existePuerta(tmpPuerta)) {
            mensaje = "La puerta no puede ser registrada debido a que ya existe en el sistema una puerta registrada con ese código.";
        } else {
            puertaDAO.insertarPuerta(tmpPuerta);
            mensaje = "La puerta fue registrada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si la puerta ya se encuentra registrado en el sistema
     * @param tmpPuerta es de tipo Puerta y corresponde a la puerta por verificar
     * @return existePuerta es de tipo boolean y devuelve si la puerta ya existe en el sistema
     */
    public boolean existePuerta (Puerta tmpPuerta) {
        boolean existePuerta = false;

        for(Puerta puerta:puertaDAO.listarPuertas()) {
            if (puerta.equals(tmpPuerta)) {
                existePuerta = true;
                break;
            }
        }
        return existePuerta;
    }

    /**
     * Metodo para listar las puertas
     */
    public ArrayList<Puerta> listarPuertas() {
        return puertaDAO.listarPuertas();
    }

    /**
     * Metodo para actualizar una puerta
     * @param tmpPuerta es de tipo Puerta y corresponde a la puerta por actualizar
     */
    public String actualizarPuerta(Puerta tmpPuerta) {
        String mensaje;
        if (!existePuerta(tmpPuerta)) {
            mensaje = "La puerta no puede ser actualizada debido a que no existe en el sistema una puerta registrada con ese código.";
        } else {
            puertaDAO.actualizarPuerta(tmpPuerta);
            mensaje = "La puerta fue actualizada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar una puerta
     * @param tmpPuerta es de tipo Puerta y corresponde a la puerta por eliminar
     */
    public String eliminarPuerta(Puerta tmpPuerta) {
        String mensaje;
        if (!existePuerta(tmpPuerta)) {
            mensaje = "La puerta no puede ser eliminada debido a que no existe en el sistema una puerta registrada con ese código.";
        } else {
            puertaDAO.eliminarPuerta(tmpPuerta);
            mensaje = "La puerta fue eliminada con éxito.";
        }
        return mensaje;
    }
}

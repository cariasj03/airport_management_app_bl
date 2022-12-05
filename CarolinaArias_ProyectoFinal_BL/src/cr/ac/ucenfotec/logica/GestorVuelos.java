package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.DAO.VueloDAO;
import cr.ac.ucenfotec.entidades.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar la manipulacion de los objetos Vuelo
 */

public class GestorVuelos {
    private VueloDAO vueloDAO;

    public GestorVuelos() {
        vueloDAO = new VueloDAO();
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
}
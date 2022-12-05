package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.DAO.PaisDAO;
import cr.ac.ucenfotec.entidades.Pais;

import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar la manipulacion de los objetos Pais
 */

public class GestorPaises {
    private PaisDAO paisDAO;

    public GestorPaises() {
        paisDAO = new PaisDAO();
    }

    /**
     * Metodo para crear un pais
     * @param tmpPais es de tipo Pais y corresponde al pais por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se insertó con exito el pais o no
     */
    public String insertarPais (Pais tmpPais)
    {
        String mensaje;
        if (existePais(tmpPais)) {
            mensaje = "El país no puede ser registrado debido a que ya existe en el sistema un pais registrado con ese código.";
        } else {
            paisDAO.insertarPais(tmpPais);
            mensaje = "El país fue registrado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si el pais ya se encuentra registrado en el sistema
     * @param tmpPais es de tipo Pais y corresponde al pais por verificar
     * @return existePais es de tipo boolean y devuelve si el pais ya existe en el sistema
     */
    public boolean existePais (Pais tmpPais) {
        boolean existePais = false;

        for(Pais pais:paisDAO.listarPaises()) {
            if (pais.equals(tmpPais)) {
                existePais = true;
                break;
            }
        }
        return existePais;
    }

    /**
     * Metodo para listar los paises
     */
    public ArrayList<Pais> listarPaises() {
        return paisDAO.listarPaises();
    }

    /**
     * Metodo para actualizar un pais
     * @param tmpPais es de tipo Pais y corresponde al pais por actualizar
     */
    public String actualizarPais(Pais tmpPais) {
        String mensaje;
        if (!existePais(tmpPais)) {
            mensaje = "El país no puede ser actualizado debido a que no existe en el sistema un país registrado con ese código.";
        } else {
            paisDAO.actualizarPais(tmpPais);
            mensaje = "El país fue actualizado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un pais
     * @param tmpPais es de tipo Pais y corresponde al pais por eliminar
     */
    public String eliminarPais(Pais tmpPais) {
        String mensaje;
        if (!existePais(tmpPais)) {
            mensaje = "El país no puede ser eliminado debido a que no existe en el sistema un país registrado con ese código.";
        } else {
            paisDAO.eliminarPais(tmpPais);
            mensaje = "El país fue eliminado con éxito.";
        }
        return mensaje;
    }
}

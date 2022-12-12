package cr.ac.ucenfotec.logica;

import cr.ac.ucenfotec.DAO.AerolineaDAO;
import cr.ac.ucenfotec.entidades.Aerolinea;
import cr.ac.ucenfotec.entidades.Tripulacion;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar la manipulacion de los objetos Aerolinea
 */

public class GestorAerolineas {
    private AerolineaDAO aerolineaDAO;

    public GestorAerolineas() {
        aerolineaDAO = new AerolineaDAO();
    }

    /**
     * Metodo para crear una aerolinea
     * @param tmpAerolinea es de tipo Aerolinea y corresponde a la aerolinea por insertar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se inserto con exito la aerolinea o no
     */
    public String insertarAerolinea (Aerolinea tmpAerolinea)
    {
        String mensaje;
        if (existeAerolinea(tmpAerolinea)) {
            mensaje = "La aerolínea no puede ser registrada debido a que ya existe en el sistema una aerolínea registrada con esa cédula jurídica.";
        } else {
            aerolineaDAO.insertarAerolinea(tmpAerolinea);
            mensaje = "La aerolínea fue registrada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si la aerolinea ya se encuentra registrada en el sistema
     * @param tmpAerolinea es de tipo Aerolinea y corresponde a la aerolinea por verificar
     * @return existeAerolinea es de tipo boolean y devuelve si la aerolinea ya existe en el sistema
     */
    public boolean existeAerolinea (Aerolinea  tmpAerolinea) {
        boolean existeAerolinea = false;

        for(Aerolinea  aerolinea:aerolineaDAO.listarAerolineas()) {
            if (aerolinea.equals(tmpAerolinea)) {
                existeAerolinea = true;
                break;
            }
        }
        return existeAerolinea;
    }

    /**
     * Metodo para listar las aerolineaes
     */
    public ArrayList<Aerolinea> listarAerolineas() {
        return aerolineaDAO.listarAerolineas();
    }

    /**
     * Metodo para actualizar los datos de una aerolinea
     * @param tmpAerolinea es de tipo Aerolinea y corresponde a la aerolinea por actualizar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se actualizo con exito la aerolinea o no
     */
    public String actualizarAerolinea (Aerolinea tmpAerolinea)
    {
        String mensaje;
        if (!existeAerolinea(tmpAerolinea)) {
            mensaje = "La aerolínea no puede ser actualizada debido a que no existe en el sistema una aerolínea registrada con esa cédula jurídica.";
        } else {
            aerolineaDAO.actualizarAerolinea(tmpAerolinea);
            mensaje = "La aerolínea fue actualizada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para actualizar el logo de una aerolinea
     * @param tmpAerolinea es de tipo Aerolinea y corresponde a la aerolinea por actualizar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se actualizo con exito la aerolinea o no
     */
    public String actualizarLogoAerolinea (Aerolinea tmpAerolinea)
    {
        String mensaje;
        if (!existeAerolinea(tmpAerolinea)) {
            mensaje = "El logo de la aerolínea no puede ser actualizado debido a que no existe en el sistema una aerolínea registrada con esa cédula jurídica.";
        } else {
            aerolineaDAO.actualizarLogoAerolinea(tmpAerolinea);
            mensaje = "El logo de la aerolínea fue actualizado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar una aerolinea
     * @param tmpAerolinea es de tipo Aerolinea y corresponde a la aerolinea por eliminar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se elimino con exito la aerolinea o no
     */
    public String eliminarAerolinea (Aerolinea tmpAerolinea)
    {
        String mensaje;
        if (!existeAerolinea(tmpAerolinea)) {
            mensaje = "La aerolínea no puede ser eliminada debido a que no existe en el sistema una aerolínea registrada con esa cédula jurídica.";
        } else {
            aerolineaDAO.eliminarAerolinea(tmpAerolinea);
            mensaje = "La aerolínea fue eliminada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para buscar una aerolinea dada su cedula juridica
     * @param cedulaJuridica es de tipo String y corresponde a la cedula juridica de la aerolinea por buscar
     */
    public Aerolinea buscarAerolinea (String cedulaJuridica)
    {
        return aerolineaDAO.buscarAerolinea(cedulaJuridica);
    }

    /**
     * Metodo para ver si una aerolinea tiene vuelos asignados
     * @param aerolinea es de tipo Aerolinea y corresponde a la aerolinea por verificar
     */
    public boolean tieneVuelosAsignados(Aerolinea aerolinea) {
        return aerolineaDAO.tieneVuelosAsignados(aerolinea);
    }
    }

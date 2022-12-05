package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Tripulacion;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Tripulacion
 */

public class TripulacionDAO {
    /**
     * Metodo para insertar un tripulacion
     * @param tripulacion es de tipo Tripulacion y corresponde al tripulacion por insertar
     */
    public void insertarTripulacion(Tripulacion tripulacion) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "INSERT INTO TRIPULACION (CODIGO_TRIPULACION, NOMBRE_CLAVE) VALUES(?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tripulacion.getCodigo());
            stmt.setString(2,tripulacion.getNombreClave());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar las tripulaciones
     */
    public ArrayList<Tripulacion> listarTripulaciones()
    {
        ArrayList<Tripulacion> tripulaciones = new ArrayList<Tripulacion>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM TRIPULACION";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Tripulacion tripulacion = new Tripulacion();
                tripulacion.setCodigo(rs.getString("CODIGO_TRIPULACION"));
                tripulacion.setNombreClave(rs.getString("NOMBRE_CLAVE"));
                tripulaciones.add(tripulacion);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tripulaciones;
    }

    /**
     * Metodo para actualizar un tripulacion
     * @param tripulacion es de tipo Tripulacion y corresponde al tripulacion por actualizar
     */
    public void actualizarTripulacion(Tripulacion tripulacion) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE TRIPULACION SET NOMBRE_CLAVE=? WHERE CODIGO_TRIPULACION=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tripulacion.getNombreClave());
            stmt.setString(2,tripulacion.getCodigo());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar un tripulacion
     * @param tripulacion es de tipo Tripulacion y corresponde al tripulacion por eliminar
     */
    public void eliminarTripulacion(Tripulacion tripulacion) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            String query = "DELETE FROM TRIPULACION WHERE CODIGO_TRIPULACION=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tripulacion.getCodigo());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar las tripulaciones
     */
    public int cantidadTripulantes (Tripulacion tripulacion)
    {
        int cantidadTripulantes = 0;
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            //La funcion count devuelve el numero de registros que tiene el resultado de la consulta
            String query = "SELECT COUNT(CODIGO_TRIPULACION) AS 'CANTIDAD' FROM Tripulante WHERE CODIGO_TRIPULACION =?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tripulacion.getCodigo());
            stmt.execute();
            rs = stmt.executeQuery();
            while (rs.next()) {
                cantidadTripulantes = rs.getInt(1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return cantidadTripulantes;
    }
}



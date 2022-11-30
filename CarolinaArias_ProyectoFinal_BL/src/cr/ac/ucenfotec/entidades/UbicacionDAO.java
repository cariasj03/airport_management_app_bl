package cr.ac.ucenfotec.entidades;

import cr.ac.ucenfotec.config.Configuracion;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 24/11/2022
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Ubicacion
 */

public class UbicacionDAO {

    /**
     * Metodo para insertar una ubicacion
     * @param ubicacion es de tipo Ubicacion y corresponde a la ubicacion por insertar
     */
    public void insertarUbicacion(Ubicacion ubicacion) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "INSERT INTO UBICACION (CODIGO_UBICACION,NIVEL) VALUES(?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,ubicacion.getCodigo());
            stmt.setInt(2,ubicacion.getNivel());
            stmt.execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar las ubicaciones
     */
    public ArrayList<Ubicacion> listarUbicaciones()
    {
        ArrayList<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM UBICACION";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Ubicacion ubicacion = new Ubicacion();
                ubicacion.setCodigo(rs.getString("CODIGO_UBICACION"));
                ubicacion.setNivel(rs.getInt("NIVEL"));
                ubicaciones.add(ubicacion);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ubicaciones;
    }

    /**
     * Metodo para actualizar una ubicacion
     * @param ubicacion es de tipo Ubicacion y corresponde a la ubicacion por actualizar
     */
    public void actualizarUbicacion(Ubicacion ubicacion) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE UBICACION SET NIVEL=? WHERE CODIGO_UBICACION=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, ubicacion.getNivel());
            stmt.setString(2, ubicacion.getCodigo());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar una ubicacion
     * @param ubicacion es de tipo Ubicacion y corresponde a la ubicacion por eliminar
     */
    public void eliminarUbicacion(Ubicacion ubicacion) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            String query = "DELETE FROM UBICACION WHERE CODIGO_UBICACION=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,ubicacion.getCodigo());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

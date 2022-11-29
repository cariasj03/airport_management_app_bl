package cr.ac.ucenfotec.entidades;

import cr.ac.ucenfotec.config.Configuracion;

import java.sql.*;
import java.util.ArrayList;

public class AeropuertoDAO {
    /**
     * Metodo para insertar un aeropuerto
     * @param aeropuerto es de tipo Aeropuerto y corresponde al aeropuerto por insertar
     */
    public void insertarAeropuerto(Aeropuerto aeropuerto) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query1 = "INSERT INTO AEROPUERTO (NOMBRE,CODIGO) VALUES(?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query1);
            stmt.setString(1,aeropuerto.getNombre());
            stmt.setString(2,aeropuerto.getCodigo());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar los aeropuertos
     */
    public ArrayList<Aeropuerto> listarAeropuertos()
    {
        ArrayList<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM AEROPUERTO";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Aeropuerto aeropuerto    = new Aeropuerto();
                Direccion direccion = new Direccion();
                aeropuerto.setNombre(rs.getString("NOMBRE"));
                aeropuerto.setCodigo(rs.getString("CODIGO"));
                aeropuertos.add(aeropuerto);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return aeropuertos;
    }

    /**
     * Metodo para actualizar un aeropuerto
     * @param aeropuerto es de tipo Aeropuerto y corresponde al aeropuerto por actualizar
     */
    public void actualizarAeropuerto(Aeropuerto aeropuerto)
    {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE AEROPUERTO SET NOMBRE=? WHERE CODIGO=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeropuerto.getNombre());
            stmt.setString(2,aeropuerto.getCodigo());
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar un aeropuerto
     * @param aeropuerto es de tipo Aeropuerto y corresponde al aeropuerto por eliminar
     */
    public void eliminarAeropuerto(Aeropuerto aeropuerto)
    {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM AEROPUERTO WHERE CODIGO = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeropuerto.getCodigo());
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();

        }
    }
}

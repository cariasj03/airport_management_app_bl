package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Aeropuerto;
import cr.ac.ucenfotec.entidades.Pais;

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
            String query1 = "INSERT INTO AEROPUERTO (NOMBRE,CODIGO_AEROPUERTO,CODIGO_PAIS) VALUES(?,?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query1);
            stmt.setString(1,aeropuerto.getNombre());
            stmt.setString(2,aeropuerto.getCodigo());
            stmt.setString(3,aeropuerto.getPais().getCodigo());
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
            String query = "SELECT * FROM AEROPUERTO INNER JOIN PAIS ON AEROPUERTO.CODIGO_PAIS = PAIS.CODIGO_PAIS";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Aeropuerto aeropuerto = new Aeropuerto();
                Pais pais = new Pais();
                aeropuerto.setNombre(rs.getString("NOMBRE"));
                aeropuerto.setCodigo(rs.getString("CODIGO_AEROPUERTO"));
                pais.setCodigo(rs.getString("CODIGO_PAIS"));
                pais.setNombre(rs.getString("NOMBRE_PAIS"));
                aeropuerto.setPais(pais);
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
            String query = "UPDATE AEROPUERTO SET NOMBRE=?,CODIGO_PAIS=? WHERE CODIGO_AEROPUERTO=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeropuerto.getNombre());
            stmt.setString(2,aeropuerto.getPais().getCodigo());
            stmt.setString(3,aeropuerto.getCodigo());
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
            String query = "DELETE FROM AEROPUERTO WHERE CODIGO_AEROPUERTO= ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeropuerto.getCodigo());
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();

        }
    }

    /**
     * Metodo para ver si un aeropuerto tiene vuelos asignados
     * @param aeropuerto es de tipo Aeropuerto y corresponde al aeropuerto por verificar
     * @return tieneVuelosAsignados es de tipo boolean y devuelve si el aeropuerto tiene vuelos asignados
     */
    public boolean tieneVuelosAsignados (Aeropuerto aeropuerto)
    {
        int cantidadApariciones = 0;
        boolean tieneVuelosAsignados = false;
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "SELECT COUNT(CODIGO_AEROPUERTO_SALIDA) FROM VUELO WHERE CODIGO_AEROPUERTO_SALIDA=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1, aeropuerto.getCodigo());
            stmt.execute();
            rs = stmt.executeQuery();
            while (rs.next()) {
                cantidadApariciones = rs.getInt(1);
            }
            String query1 = "SELECT COUNT(CODIGO_AEROPUERTO_LLEGADA) FROM VUELO WHERE CODIGO_AEROPUERTO_LLEGADA=?";
            stmt = conn.prepareStatement(query1);
            stmt.setString(1, aeropuerto.getCodigo());
            stmt.execute();
            rs = stmt.executeQuery();
            while (rs.next()) {
                cantidadApariciones = cantidadApariciones + rs.getInt(1);
            }
            if(cantidadApariciones > 0) {
                tieneVuelosAsignados = true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return tieneVuelosAsignados;
    }
}
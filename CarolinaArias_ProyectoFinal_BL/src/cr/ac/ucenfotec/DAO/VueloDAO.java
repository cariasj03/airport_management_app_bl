package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Aeropuerto;
import cr.ac.ucenfotec.entidades.Vuelo;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 24/11/2022
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Vuelo
 */

public class VueloDAO {

    /**
     * Metodo para insertar un vuelo
     * @param vuelo es de tipo Vuelo y corresponde al vuelo por insertar
     */
    public void insertarVuelo(Vuelo vuelo) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "INSERT INTO VUELO (NUMERO_VUELO,HORA_SALIDA,HORA_LLEGADA,ESTADO,TIPO_VUELO,CANT_ASIENTOS_DISPONIBLES,PRECIO_ASIENTOS,MONTO_IMPUESTO,CODIGO_AEROPUERTO_SALIDA,CODIGO_AEROPUERTO_LLEGADA) VALUES(?,?,?,?,?,?,?,?,?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,vuelo.getNumeroVuelo());
            stmt.setTime(2,java.sql.Time.valueOf(vuelo.getHoraSalida()));
            stmt.setTime(3,java.sql.Time.valueOf(vuelo.getHoraLlegada()));
            stmt.setString(4,vuelo.getEstado());
            stmt.setString(5, vuelo.getTipoVuelo());
            stmt.setInt(6, vuelo.getCantAsientosDiponibles());
            stmt.setDouble(7, vuelo.getPrecioAsientos());
            stmt.setDouble(8,vuelo.getMontoImpuesto());
            stmt.setString(9,vuelo.getAeropuertoOrigen().getCodigo());
            stmt.setString(10,vuelo.getAeropuertoDestino().getCodigo());
            stmt.execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar los vuelos
     */
    public ArrayList<Vuelo> listarVuelos()
    {
        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT NUMERO_VUELO, HORA_SALIDA, HORA_LLEGADA, ESTADO, TIPO_VUELO, CANT_ASIENTOS_DISPONIBLES, PRECIO_ASIENTOS, MONTO_IMPUESTO, CODIGO_AEROPUERTO_SALIDA, A_SALIDA.NOMBRE AS 'NOMBRE_A_SALIDA', CODIGO_AEROPUERTO_LLEGADA, A_LLEGADA.NOMBRE AS 'NOMBRE_A_LLEGADA' FROM VUELO INNER JOIN AEROPUERTO AS A_SALIDA ON VUELO.CODIGO_AEROPUERTO_SALIDA = A_SALIDA.CODIGO_AEROPUERTO INNER JOIN AEROPUERTO AS A_LLEGADA ON VUELO.CODIGO_AEROPUERTO_LLEGADA = A_LLEGADA.CODIGO_AEROPUERTO";

            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Vuelo vuelo = new Vuelo();
                Aeropuerto aeropuertoOrigen = new Aeropuerto();
                Aeropuerto aeropuertoDestino = new Aeropuerto();
                vuelo.setNumeroVuelo(rs.getInt("NUMERO_VUELO"));
                vuelo.setHoraSalida(rs.getTime("HORA_SALIDA").toLocalTime());
                vuelo.setHoraLlegada(rs.getTime("HORA_LLEGADA").toLocalTime());
                vuelo.setEstado(rs.getString("ESTADO"));
                vuelo.setTipoVuelo(rs.getString("TIPO_VUELO"));
                vuelo.setCantAsientosDiponibles(rs.getInt("CANT_ASIENTOS_DISPONIBLES"));
                vuelo.setPrecioAsientos(rs.getDouble("PRECIO_ASIENTOS"));
                vuelo.setMontoImpuesto(rs.getDouble("MONTO_IMPUESTO"));
                aeropuertoOrigen.setCodigo(rs.getString("CODIGO_AEROPUERTO_SALIDA"));
                aeropuertoOrigen.setNombre(rs.getString("NOMBRE_A_SALIDA"));
                aeropuertoDestino.setCodigo(rs.getString("CODIGO_AEROPUERTO_LLEGADA"));
                aeropuertoDestino.setNombre(rs.getString("NOMBRE_A_LLEGADA"));
                vuelo.setAeropuertoOrigen(aeropuertoOrigen);
                vuelo.setAeropuertoDestino(aeropuertoDestino);
                vuelos.add(vuelo);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return vuelos;
    }

    /**
     * Metodo para actualizar un vuelo
     * @param vuelo es de tipo Vuelo y corresponde al vuelo por actualizar
     */
    public void actualizarVuelo(Vuelo vuelo) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE VUELO SET HORA_SALIDA=?,HORA_LLEGADA=?,ESTADO=?,TIPO_VUELO=?,CANT_ASIENTOS_DISPONIBLES=?,PRECIO_ASIENTOS=?,MONTO_IMPUESTO=?,CODIGO_AEROPUERTO_SALIDA=?,CODIGO_AEROPUERTO_LLEGADA=? WHERE NUMERO_VUELO=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setTime(1,java.sql.Time.valueOf(vuelo.getHoraSalida()));
            stmt.setTime(2,java.sql.Time.valueOf(vuelo.getHoraLlegada()));
            stmt.setString(3,vuelo.getEstado());
            stmt.setString(4, vuelo.getTipoVuelo());
            stmt.setInt(5, vuelo.getCantAsientosDiponibles());
            stmt.setDouble(6, vuelo.getPrecioAsientos());
            stmt.setDouble(7,vuelo.getMontoImpuesto());
            stmt.setString(8,vuelo.getAeropuertoOrigen().getCodigo());
            stmt.setString(9,vuelo.getAeropuertoDestino().getCodigo());
            stmt.setInt(10,vuelo.getNumeroVuelo());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar un vuelo
     * @param vuelo es de tipo Vuelo y corresponde al vuelo por eliminar
     */
    public void eliminarVuelo(Vuelo vuelo) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            String query = "DELETE FROM VUELO WHERE NUMERO_VUELO=?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,vuelo.getNumeroVuelo());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

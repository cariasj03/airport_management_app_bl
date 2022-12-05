package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Puerta;
import cr.ac.ucenfotec.entidades.Ubicacion;
import java.sql.*;
import java.util.ArrayList;

public class PuertaDAO {
    /**
     * Metodo para insertar una puerta
     * @param puerta es de tipo Puerta y corresponde a la puerta por insertar
     */
    public void insertarPuerta(Puerta puerta) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query1 = "INSERT INTO PUERTA (CODIGO_PUERTA,NOMBRE,CODIGO_UBICACION) VALUES(?,?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query1);
            stmt.setString(1,puerta.getCodigo());
            stmt.setString(2,puerta.getNombre());
            stmt.setString(3,puerta.getUbicacion().getCodigo());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar las puertas
     */
    public ArrayList<Puerta> listarPuertas()
    {
        ArrayList<Puerta> puertas = new ArrayList<Puerta>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM PUERTA INNER JOIN UBICACION ON PUERTA.CODIGO_UBICACION = UBICACION.CODIGO_UBICACION";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Puerta puerta = new Puerta();
                Ubicacion ubicacion = new Ubicacion();
                puerta.setCodigo(rs.getString("CODIGO_PUERTA"));
                puerta.setNombre(rs.getString("NOMBRE"));
                ubicacion.setCodigo(rs.getString("CODIGO_UBICACION"));
                ubicacion.setNivel(rs.getInt("NIVEL"));
                puerta.setUbicacion(ubicacion);
                puertas.add(puerta);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return puertas;
    }

    /**
     * Metodo para actualizar una puerta
     * @param puerta es de tipo Puerta y corresponde a la puerta por actualizar
     */
    public void actualizarPuerta(Puerta puerta)
    {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE PUERTA SET NOMBRE=?,CODIGO_UBICACION=? WHERE CODIGO_PUERTA=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,puerta.getNombre());
            stmt.setString(2,puerta.getUbicacion().getCodigo());
            stmt.setString(3,puerta.getCodigo());
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar una puerta
     * @param puerta es de tipo Puerta y corresponde a la puerta por eliminar
     */
    public void eliminarPuerta(Puerta puerta)
    {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM PUERTA WHERE CODIGO_PUERTA=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,puerta.getCodigo());
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
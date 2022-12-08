package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Aerolinea;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 24/11/2022
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Aerolinea
 */

public class AerolineaDAO {

    /**
     * Metodo para insertar una aerolinea
     * @param aerolinea es de tipo Aerolinea y corresponde a la aerolinea por insertar
     */
    public void insertarAerolinea(Aerolinea aerolinea) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "INSERT INTO AEROLINEA (CEDULA_JURIDICA,NOMBRE_COMERCIAL,NOMBRE_EMPRESA_DUENNA,LOGO) VALUES(?,?,?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aerolinea.getCedulaJuridica());
            stmt.setString(2,aerolinea.getNombreComercial());
            stmt.setString(3,aerolinea.getNombreEmpresaDuenna());
            stmt.setBlob(4,aerolinea.getLogo());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar las aerolineas
     */
    public ArrayList<Aerolinea> listarAerolineas()
    {
        ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM AEROLINEA";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Aerolinea aerolinea = new Aerolinea();
                aerolinea.setCedulaJuridica(rs.getString("CEDULA_JURIDICA"));
                aerolinea.setNombreComercial(rs.getString("NOMBRE_COMERCIAL"));
                aerolinea.setNombreEmpresaDuenna(rs.getString("NOMBRE_EMPRESA_DUENNA"));
                aerolinea.setLogo(rs.getBlob("LOGO").getBinaryStream());
                aerolineas.add(aerolinea);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return aerolineas;
    }

    /**
     * Metodo para actualizar los datos de una aerolinea
     * @param aerolinea es de tipo Aerolinea y corresponde a la aerolinea por actualizar
     */
    public void actualizarAerolinea(Aerolinea aerolinea) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE AEROLINEA SET NOMBRE_COMERCIAL=?, NOMBRE_EMPRESA_DUENNA=? WHERE CEDULA_JURIDICA=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1, aerolinea.getNombreComercial());
            stmt.setString(2, aerolinea.getNombreEmpresaDuenna());
            stmt.setString(3, aerolinea.getCedulaJuridica());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para actualizar el logo de una aerolinea
     * @param aerolinea es de tipo Aerolinea y corresponde a la aerolinea por actualizar
     */
    public void actualizarLogoAerolinea(Aerolinea aerolinea) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE AEROLINEA SET LOGO=? WHERE CEDULA_JURIDICA=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setBlob(1,aerolinea.getLogo());
            stmt.setString(2, aerolinea.getCedulaJuridica());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar una aerolinea
     * @param aerolinea es de tipo Aerolinea y corresponde a la aerolinea por eliminar
     */
    public void eliminarAerolinea(Aerolinea aerolinea) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            String query = "DELETE FROM AEROLINEA WHERE CEDULA_JURIDICA=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aerolinea.getCedulaJuridica());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para buscar una aerolinea dada su cedula juridica
     * @param cedulaJuridica es de tipo String y corresponde a la cedula juridica de la aerolinea por buscar
     */
    public Aerolinea buscarAerolinea(String cedulaJuridica)  {
        Configuracion configuracion = new Configuracion();
        Aerolinea aerolinea = new Aerolinea();
        try{
            Class.forName(configuracion.getClaseJDBC());
            String strConexion = configuracion.getStringConexion();
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            conn = DriverManager.getConnection(strConexion);
            String query = "SELECT * FROM AEROLINEA WHERE CEDULA_JURIDICA=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, cedulaJuridica);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aerolinea.setNombreComercial(rs.getString("NOMBRE_COMERCIAL"));
                aerolinea.setCedulaJuridica(rs.getString("CEDULA_JURIDICA"));
                aerolinea.setNombreEmpresaDuenna(rs.getString("NOMBRE_EMPRESA_DUENNA"));
                aerolinea.setLogo(rs.getBlob("LOGO").getBinaryStream());
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return aerolinea;
    }
}

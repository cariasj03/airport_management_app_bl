package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Pais;
import cr.ac.ucenfotec.entidades.Ubicacion;

import java.sql.*;
import java.util.ArrayList;

public class PaisDAO {
    /**
     * Metodo para insertar un pais
     * @param pais es de tipo Pais y corresponde al pais por insertar
     */
    public void insertarPais(Pais pais) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query1 = "INSERT INTO PAIS (CODIGO_PAIS,NOMBRE_PAIS) VALUES(?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query1);
            stmt.setString(1,pais.getCodigo());
            stmt.setString(2,pais.getNombre());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar los paises
     */
    public ArrayList<Pais> listarPaises()
    {
        ArrayList<Pais> paises = new ArrayList<Pais>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM PAIS";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setCodigo(rs.getString("CODIGO_PAIS"));
                pais.setNombre(rs.getString("NOMBRE_PAIS"));
                paises.add(pais);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return paises;
    }

    /**
     * Metodo para actualizar un pais
     * @param pais es de tipo Pais y corresponde al pais por actualizar
     */
    public void actualizarPais(Pais pais)
    {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE PAIS SET NOMBRE_PAIS=? WHERE CODIGO_PAIS=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,pais.getNombre());
            stmt.setString(2,pais.getCodigo());
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar un pais
     * @param pais es de tipo Pais y corresponde al pais por eliminar
     */
    public void eliminarPais(Pais pais)
    {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM PAIS WHERE CODIGO_PAIS=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,pais.getCodigo());
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo para ver si un pais tiene aeropuertos asignados
     * @param pais es de tipo Pais y corresponde al pais por verificar
     * @return tieneAeropuertosAsignados es de tipo boolean y devuelve si el pais tiene aeropuertos asignados
     */
    public boolean tieneAeropuertosAsignados (Pais pais)
    {
        int cantidadApariciones = 0;
        boolean tieneAeropuertosAsignados = false;
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "SELECT COUNT(CODIGO_PAIS) AS 'CANTIDAD' FROM AEROPUERTO WHERE CODIGO_PAIS=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1, pais.getCodigo());
            stmt.execute();
            rs = stmt.executeQuery();
            while (rs.next()) {
                cantidadApariciones = rs.getInt(1);
            }
            if(cantidadApariciones > 0) {
                tieneAeropuertosAsignados = true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return tieneAeropuertosAsignados;
    }
}
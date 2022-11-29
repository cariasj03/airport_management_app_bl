package cr.ac.ucenfotec.entidades;

import cr.ac.ucenfotec.config.Configuracion;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 24/11/2022
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Administrador
 */

public class AdministradorDAO {
    /**
     * Metodo para insertar un administrador
     * @param administrador es de tipo Administrador y corresponde al administrador por insertar
     */
    public void insertarAdministrador(Administrador administrador) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            String strConexion = configuracion.getStringConexion();
            String query1 = "INSERT INTO ADMINISTRADOR (ID,NOMBRE,APELLIDOS,NACIONALIDAD,FECHA_NACIMIENTO,EDAD,GENERO,CORREO_ELECTRONICO, CONTRASENA) VALUES(?,?,?,?,?,?,?,?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,administrador.getId());
            stmt1.setString(2,administrador.getNombre());
            stmt1.setString(3,administrador.getApellidos());
            stmt1.setString(4,administrador.getNacionalidad());
            stmt1.setDate(5, java.sql.Date.valueOf(administrador.getFechaNacimiento()));
            stmt1.setInt(6,administrador.getEdad());
            stmt1.setString(7,administrador.getGenero());
            stmt1.setString(8,administrador.getCorreoElectronico());
            stmt1.setString(9,administrador.getContrasena());
            stmt1.execute();

            String query2 = "INSERT INTO DIRECCION (PROVINCIA, CANTON, DISTRITO, DETALLE, ID_ADMINISTRADOR) VALUES(?,?,?,?,?)";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,administrador.getDireccion().getProvincia());
            stmt2.setString(2,administrador.getDireccion().getCanton());
            stmt2.setString(3,administrador.getDireccion().getDistrito());
            stmt2.setString(4,administrador.getDireccion().getDetalleDireccion());
            stmt2.setString(5,administrador.getId());
            stmt2.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar los administradores
     */
    public ArrayList<Administrador> listarAdministradores()
    {
        ArrayList<Administrador> administradores = new ArrayList<Administrador>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM ADMINISTRADOR INNER JOIN DIRECCION ON ADMINISTRADOR.ID = DIRECCION.ID_ADMINISTRADOR";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Administrador administrador = new Administrador();
                Direccion direccion = new Direccion();
                administrador.setId(rs.getString("ID"));
                administrador.setNombre(rs.getString("NOMBRE"));
                administrador.setApellidos(rs.getString("APELLIDOS"));
                administrador.setNacionalidad(rs.getString("NACIONALIDAD"));
                administrador.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                administrador.setEdad(rs.getInt("EDAD"));
                administrador.setGenero(rs.getString("GENERO"));
                administrador.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                administrador.setContrasena(rs.getString("CONTRASENA"));
                direccion.setProvincia(rs.getString("PROVINCIA"));
                direccion.setCanton(rs.getString("CANTON"));
                direccion.setDistrito(rs.getString("DISTRITO"));
                direccion.setDetalleDireccion(rs.getString("DETALLE"));
                administrador.setDireccion(direccion);
                administradores.add(administrador);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return administradores;
    }

    /**
     * Metodo para verificar que las credenciales del administrador sean correctas
     * @param tmpAdministrador es de tipo Administrador y corresponde al administrador por verificar
     * @return login es de tipo boolean y devuelve si las credenciales del administrador son correctas
     */
    public boolean loginAdministrador (Administrador tmpAdministrador) {
        ArrayList<Administrador> administradores = listarAdministradores();
        boolean login = false;

        for (Administrador administrador: administradores) {
            if(administrador.equals(tmpAdministrador)) {
                if(administrador.getContrasena().equals(tmpAdministrador.getContrasena())) {
                    login = true;
                }
            }
        }
        return login;
    }

    /**
     * Metodo para actualizar un administrador
     * @param administrador es de tipo Administrador y corresponde al administrador por actualizar
     */
    public void actualizarAdministrador(Administrador administrador) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            String strConexion = configuracion.getStringConexion();
            String query1 = "UPDATE ADMINISTRADOR SET NOMBRE=?,APELLIDOS=?,NACIONALIDAD=?,FECHA_NACIMIENTO=?,EDAD=?,GENERO=?,CORREO_ELECTRONICO=?, CONTRASENA=? WHERE ID=?";
            conn = DriverManager.getConnection(strConexion);
            stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,administrador.getNombre());
            stmt1.setString(2,administrador.getApellidos());
            stmt1.setString(3,administrador.getNacionalidad());
            stmt1.setDate(4, java.sql.Date.valueOf(administrador.getFechaNacimiento()));
            stmt1.setInt(5,administrador.getEdad());
            stmt1.setString(6,administrador.getGenero());
            stmt1.setString(7,administrador.getCorreoElectronico());
            stmt1.setString(8,administrador.getContrasena());
            stmt1.setString(9,administrador.getId());
            stmt1.execute();

            String query2 = "UPDATE DIRECCION SET PROVINCIA=?,CANTON=?,DISTRITO=?,DETALLE=? WHERE ID_ADMINISTRADOR=?";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,administrador.getDireccion().getProvincia());
            stmt2.setString(2,administrador.getDireccion().getCanton());
            stmt2.setString(3,administrador.getDireccion().getDistrito());
            stmt2.setString(4,administrador.getDireccion().getDetalleDireccion());
            stmt2.setString(5,administrador.getId());
            stmt2.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar un administrador
     * @param administrador es de tipo Administrador y corresponde al administrador por eliminar
     */
    public void eliminarAdministrador(Administrador administrador) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);

            String query1 = "DELETE FROM DIRECCION WHERE ID_ADMINISTRADOR=?";
            stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,administrador.getId());
            stmt1.execute();

            String query2 = "DELETE FROM ADMINISTRADOR WHERE ID=?";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,administrador.getId());
            stmt2.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
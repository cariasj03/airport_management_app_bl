package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Direccion;
import cr.ac.ucenfotec.entidades.Usuario;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Usuario
 */

public class UsuarioDAO {
    /**
     * Metodo para insertar un usuario
     * @param usuario es de tipo Usuario y corresponde al usuario por insertar
     */
    public void insertarUsuario(Usuario usuario) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            PreparedStatement stmt3 = null;
            String strConexion = configuracion.getStringConexion();
            String query1 = "INSERT INTO PERSONA (ID,NOMBRE,APELLIDOS,NACIONALIDAD,FECHA_NACIMIENTO,EDAD,GENERO,CORREO_ELECTRONICO, CONTRASENA) VALUES(?,?,?,?,?,?,?,?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,usuario.getId());
            stmt1.setString(2,usuario.getNombre());
            stmt1.setString(3,usuario.getApellidos());
            stmt1.setString(4,usuario.getNacionalidad());
            stmt1.setDate(5, java.sql.Date.valueOf(usuario.getFechaNacimiento()));
            stmt1.setInt(6,usuario.getEdad());
            stmt1.setString(7,usuario.getGenero());
            stmt1.setString(8,usuario.getCorreoElectronico());
            stmt1.setString(9,usuario.getContrasena());
            stmt1.execute();

            String query2 = "INSERT INTO DIRECCION (PROVINCIA, CANTON, DISTRITO, DETALLE, ID_PERSONA) VALUES(?,?,?,?,?)";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,usuario.getDireccion().getProvincia());
            stmt2.setString(2,usuario.getDireccion().getCanton());
            stmt2.setString(3,usuario.getDireccion().getDistrito());
            stmt2.setString(4,usuario.getDireccion().getDetalleDireccion());
            stmt2.setString(5,usuario.getId());
            stmt2.execute();

            String query3 = "INSERT INTO USUARIO (ID_PERSONA) VALUES(?)";
            stmt3 = conn.prepareStatement(query3);
            stmt3.setString(1,usuario.getId());
            stmt3.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar los usuarios
     */
    public ArrayList<Usuario> listarUsuarios()
    {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM PERSONA INNER JOIN USUARIO ON PERSONA.ID = USUARIO.ID_PERSONA INNER JOIN DIRECCION ON USUARIO.ID_PERSONA = DIRECCION.ID_PERSONA";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Usuario usuario = new Usuario();
                Direccion direccion = new Direccion();
                usuario.setId(rs.getString("ID"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setApellidos(rs.getString("APELLIDOS"));
                usuario.setNacionalidad(rs.getString("NACIONALIDAD"));
                usuario.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                usuario.setEdad(rs.getInt("EDAD"));
                usuario.setGenero(rs.getString("GENERO"));
                usuario.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                usuario.setContrasena(rs.getString("CONTRASENA"));
                direccion.setProvincia(rs.getString("PROVINCIA"));
                direccion.setCanton(rs.getString("CANTON"));
                direccion.setDistrito(rs.getString("DISTRITO"));
                direccion.setDetalleDireccion(rs.getString("DETALLE"));
                usuario.setDireccion(direccion);
                usuarios.add(usuario);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return usuarios;
    }

    /**
     * Metodo para actualizar un usuario
     * @param usuario es de tipo Usuario y corresponde al usuario por actualizar
     */
    public void actualizarUsuario(Usuario usuario) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            String strConexion = configuracion.getStringConexion();
            String query1 = "UPDATE PERSONA SET NOMBRE=?,APELLIDOS=?,NACIONALIDAD=?,FECHA_NACIMIENTO=?,EDAD=?,GENERO=?,CORREO_ELECTRONICO=?, CONTRASENA=? WHERE ID=?";
            conn = DriverManager.getConnection(strConexion);
            stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,usuario.getNombre());
            stmt1.setString(2,usuario.getApellidos());
            stmt1.setString(3,usuario.getNacionalidad());
            stmt1.setDate(4, java.sql.Date.valueOf(usuario.getFechaNacimiento()));
            stmt1.setInt(5,usuario.getEdad());
            stmt1.setString(6,usuario.getGenero());
            stmt1.setString(7,usuario.getCorreoElectronico());
            stmt1.setString(8,usuario.getContrasena());
            stmt1.setString(9,usuario.getId());
            stmt1.execute();

            String query2 = "UPDATE DIRECCION SET PROVINCIA=?,CANTON=?,DISTRITO=?,DETALLE=? WHERE ID_PERSONA=?";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,usuario.getDireccion().getProvincia());
            stmt2.setString(2,usuario.getDireccion().getCanton());
            stmt2.setString(3,usuario.getDireccion().getDistrito());
            stmt2.setString(4,usuario.getDireccion().getDetalleDireccion());
            stmt2.setString(5,usuario.getId());
            stmt2.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar un usuario
     * @param usuario es de tipo Usuario y corresponde al usuario por eliminar
     */
    public void eliminarUsuario(Usuario usuario) {
        try {
            //Se crea una nueva instancia del archivo de configuración
            Configuracion configuracion= new Configuracion();
            //Lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            PreparedStatement stmt3 = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);

            String query1 = "DELETE FROM DIRECCION WHERE ID_PERSONA=?";
            stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,usuario.getId());
            stmt1.execute();

            String query2 = "DELETE FROM USUARIO WHERE ID_PERSONA=?";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,usuario.getId());
            stmt2.execute();

            String query3 = "DELETE FROM PERSONA WHERE ID=?";
            stmt3 = conn.prepareStatement(query3);
            stmt3.setString(1,usuario.getId());
            stmt3.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

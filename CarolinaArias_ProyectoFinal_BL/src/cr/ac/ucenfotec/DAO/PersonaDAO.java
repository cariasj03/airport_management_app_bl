package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Persona;
import cr.ac.ucenfotec.entidades.Direccion;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Persona
 */

public class PersonaDAO {

    /**
     * Metodo para listar las personas
     */
    public ArrayList<Persona> listarPersonas()
    {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM PERSONA INNER JOIN DIRECCION ON PERSONA.ID = DIRECCION.ID_PERSONA";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Persona persona = new Persona();
                Direccion direccion = new Direccion();
                persona.setId(rs.getString("ID"));
                persona.setNombre(rs.getString("NOMBRE"));
                persona.setApellidos(rs.getString("APELLIDOS"));
                persona.setNacionalidad(rs.getString("NACIONALIDAD"));
                persona.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                persona.setEdad(rs.getInt("EDAD"));
                persona.setGenero(rs.getString("GENERO"));
                persona.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                persona.setContrasena(rs.getString("CONTRASENA"));
                direccion.setProvincia(rs.getString("PROVINCIA"));
                direccion.setCanton(rs.getString("CANTON"));
                direccion.setDistrito(rs.getString("DISTRITO"));
                direccion.setDetalleDireccion(rs.getString("DETALLE"));
                persona.setDireccion(direccion);
                personas.add(persona);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return personas;
    }

    /**
     * Metodo para buscar una persona dada su identificacion
     * @param idPersona es de tipo String y corresponde a la identificacion de la persona por buscar
     */
    public Persona buscarPersona(String idPersona)  {
        Configuracion configuracion = new Configuracion();
        Persona persona = new Persona();
        Direccion direccion = new Direccion();
        try{
            Class.forName(configuracion.getClaseJDBC());
            String strConexion = configuracion.getStringConexion();
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            conn = DriverManager.getConnection(strConexion);
            String query = "SELECT * FROM PERSONA INNER JOIN DIRECCION ON PERSONA.ID = DIRECCION.ID_PERSONA WHERE PERSONA.ID=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, idPersona);
            rs = stmt.executeQuery();
            if (rs.next()) {
                persona.setId(rs.getString("ID"));
                persona.setNombre(rs.getString("NOMBRE"));
                persona.setApellidos(rs.getString("APELLIDOS"));
                persona.setNacionalidad(rs.getString("NACIONALIDAD"));
                persona.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                persona.setEdad(rs.getInt("EDAD"));
                persona.setGenero(rs.getString("GENERO"));
                persona.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                persona.setContrasena(rs.getString("CONTRASENA"));
                direccion.setProvincia(rs.getString("PROVINCIA"));
                direccion.setCanton(rs.getString("CANTON"));
                direccion.setDistrito(rs.getString("DISTRITO"));
                direccion.setDetalleDireccion(rs.getString("DETALLE"));
                persona.setDireccion(direccion);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return persona;
    }

    /**
     * Metodo para actualizar una persona
     * @param persona es de tipo Persona y corresponde a la persona por actualizar
     */
    public void actualizarPersona(Persona persona) {
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            String strConexion = configuracion.getStringConexion();
            String query1 = "UPDATE PERSONA SET NOMBRE=?,APELLIDOS=?,NACIONALIDAD=?,FECHA_NACIMIENTO=?,EDAD=?,GENERO=?,CORREO_ELECTRONICO=?, CONTRASENA=? WHERE ID=?";
            conn = DriverManager.getConnection(strConexion);
            stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,persona.getNombre());
            stmt1.setString(2,persona.getApellidos());
            stmt1.setString(3,persona.getNacionalidad());
            stmt1.setDate(4, java.sql.Date.valueOf(persona.getFechaNacimiento()));
            stmt1.setInt(5,persona.getEdad());
            stmt1.setString(6,persona.getGenero());
            stmt1.setString(7,persona.getCorreoElectronico());
            stmt1.setString(8,persona.getContrasena());
            stmt1.setString(9,persona.getId());
            stmt1.execute();

            String query2 = "UPDATE DIRECCION SET PROVINCIA=?,CANTON=?,DISTRITO=?,DETALLE=? WHERE ID_PERSONA=?";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,persona.getDireccion().getProvincia());
            stmt2.setString(2,persona.getDireccion().getCanton());
            stmt2.setString(3,persona.getDireccion().getDistrito());
            stmt2.setString(4,persona.getDireccion().getDetalleDireccion());
            stmt2.setString(5,persona.getId());
            stmt2.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Direccion;
import cr.ac.ucenfotec.entidades.Tripulacion;
import cr.ac.ucenfotec.entidades.Tripulante;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 03/12/2022
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Tripulante
 */

public class TripulanteDAO {
    /**
     * Metodo para insertar un tripulante
     * @param tripulante es de tipo Tripulante y corresponde al tripulante por insertar
     */
    public void insertarTripulante(Tripulante tripulante) {
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
            stmt1.setString(1,tripulante.getId());
            stmt1.setString(2,tripulante.getNombre());
            stmt1.setString(3,tripulante.getApellidos());
            stmt1.setString(4,tripulante.getNacionalidad());
            stmt1.setDate(5, java.sql.Date.valueOf(tripulante.getFechaNacimiento()));
            stmt1.setInt(6,tripulante.getEdad());
            stmt1.setString(7,tripulante.getGenero());
            stmt1.setString(8,tripulante.getCorreoElectronico());
            stmt1.setString(9,tripulante.getContrasena());
            stmt1.execute();

            String query2 = "INSERT INTO DIRECCION (PROVINCIA, CANTON, DISTRITO, DETALLE, ID_PERSONA) VALUES(?,?,?,?,?)";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,tripulante.getDireccion().getProvincia());
            stmt2.setString(2,tripulante.getDireccion().getCanton());
            stmt2.setString(3,tripulante.getDireccion().getDistrito());
            stmt2.setString(4,tripulante.getDireccion().getDetalleDireccion());
            stmt2.setString(5,tripulante.getId());
            stmt2.execute();

            String query3 = "INSERT INTO TRIPULANTE (ANIOS_EXPERIENCIA, FECHA_GRADUACION, NUMERO_LICENCIA, PUESTO, TELEFONO, ID_PERSONA) VALUES(?,?,?,?,?,?)";
            stmt3 = conn.prepareStatement(query3);
            stmt3.setInt(1,tripulante.getAniosExperiencia());
            stmt3.setDate(2,java.sql.Date.valueOf(tripulante.getFechaGraduacion()));
            stmt3.setString(3,tripulante.getNumeroLicencia());
            stmt3.setString(4,tripulante.getPuesto());
            stmt3.setString(5,tripulante.getTelefono());
            stmt3.setString(6,tripulante.getId());
            stmt3.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar los tripulantes
     */
    public ArrayList<Tripulante> listarTripulantes()
    {
        ArrayList<Tripulante> tripulantes = new ArrayList<Tripulante>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM PERSONA INNER JOIN TRIPULANTE ON PERSONA.ID = TRIPULANTE.ID_PERSONA INNER JOIN DIRECCION ON TRIPULANTE.ID_PERSONA = DIRECCION.ID_PERSONA";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Tripulante tripulante = new Tripulante();
                Direccion direccion = new Direccion();
                tripulante.setId(rs.getString("ID"));
                tripulante.setNombre(rs.getString("NOMBRE"));
                tripulante.setApellidos(rs.getString("APELLIDOS"));
                tripulante.setNacionalidad(rs.getString("NACIONALIDAD"));
                tripulante.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                tripulante.setEdad(rs.getInt("EDAD"));
                tripulante.setGenero(rs.getString("GENERO"));
                tripulante.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                tripulante.setContrasena(rs.getString("CONTRASENA"));
                direccion.setProvincia(rs.getString("PROVINCIA"));
                direccion.setCanton(rs.getString("CANTON"));
                direccion.setDistrito(rs.getString("DISTRITO"));
                direccion.setDetalleDireccion(rs.getString("DETALLE"));
                tripulante.setDireccion(direccion);
                tripulante.setAniosExperiencia(rs.getInt("ANIOS_EXPERIENCIA"));
                tripulante.setFechaGraduacion(rs.getDate("FECHA_GRADUACION").toLocalDate());
                tripulante.setNumeroLicencia(rs.getString("NUMERO_LICENCIA"));
                tripulante.setPuesto(rs.getString("PUESTO"));
                tripulante.setTelefono(rs.getString("TELEFONO"));
                tripulantes.add(tripulante);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tripulantes;
    }

    /**
     * Metodo para actualizar un tripulante
     * @param tripulante es de tipo Tripulante y corresponde al tripulante por actualizar
     */
    public void actualizarTripulante(Tripulante tripulante) {
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
            String query1 = "UPDATE PERSONA SET NOMBRE=?,APELLIDOS=?,NACIONALIDAD=?,FECHA_NACIMIENTO=?,EDAD=?,GENERO=?,CORREO_ELECTRONICO=?, CONTRASENA=? WHERE ID=?";
            conn = DriverManager.getConnection(strConexion);
            stmt1 = conn.prepareStatement(query1);
            stmt1.setString(1,tripulante.getNombre());
            stmt1.setString(2,tripulante.getApellidos());
            stmt1.setString(3,tripulante.getNacionalidad());
            stmt1.setDate(4, java.sql.Date.valueOf(tripulante.getFechaNacimiento()));
            stmt1.setInt(5,tripulante.getEdad());
            stmt1.setString(6,tripulante.getGenero());
            stmt1.setString(7,tripulante.getCorreoElectronico());
            stmt1.setString(8,tripulante.getContrasena());
            stmt1.setString(9,tripulante.getId());
            stmt1.execute();

            String query2 = "UPDATE DIRECCION SET PROVINCIA=?,CANTON=?,DISTRITO=?,DETALLE=? WHERE ID_PERSONA=?";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,tripulante.getDireccion().getProvincia());
            stmt2.setString(2,tripulante.getDireccion().getCanton());
            stmt2.setString(3,tripulante.getDireccion().getDistrito());
            stmt2.setString(4,tripulante.getDireccion().getDetalleDireccion());
            stmt2.setString(5,tripulante.getId());
            stmt2.execute();

            String query3 = "UPDATE TRIPULANTE SET ANIOS_EXPERIENCIA=?,FECHA_GRADUACION=?,NUMERO_LICENCIA=?,PUESTO=?,TELEFONO=? WHERE ID_PERSONA=?";
            stmt3 = conn.prepareStatement(query3);
            stmt3.setInt(1,tripulante.getAniosExperiencia());
            stmt3.setDate(2,java.sql.Date.valueOf(tripulante.getFechaGraduacion()));
            stmt3.setString(3,tripulante.getNumeroLicencia());
            stmt3.setString(4,tripulante.getPuesto());
            stmt3.setString(5,tripulante.getTelefono());
            stmt3.setString(6,tripulante.getId());
            stmt3.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para eliminar un tripulante
     * @param tripulante es de tipo Tripulante y corresponde al tripulante por eliminar
     */
    public void eliminarTripulante(Tripulante tripulante) {
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
            stmt1.setString(1,tripulante.getId());
            stmt1.execute();

            String query2 = "DELETE FROM TRIPULANTE WHERE ID_PERSONA=?";
            stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1,tripulante.getId());
            stmt2.execute();

            String query3 = "DELETE FROM PERSONA WHERE ID=?";
            stmt3 = conn.prepareStatement(query3);
            stmt3.setString(1,tripulante.getId());
            stmt3.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para agregar un tripulante a una tripulacion
     * @param tripulante es de tipo Tripulantes y corresponde al tripulante a agregar
     * @param tripulacion es de tipo Tripulacion y corresponde a la tripulacion a la que se va a agregar el tripulante
     */
    public void agregarTripulanteATripulacion(Tripulante tripulante, Tripulacion tripulacion) {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE TRIPULANTE SET CODIGO_TRIPULACION=? WHERE ID_PERSONA=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tripulacion.getCodigo());
            stmt.setString(2,tripulante.getId());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar los tripulantes de una tripulacion en especifico
     */
    public ArrayList<Tripulante> listarTripulantesDeTripulacion(Tripulacion tripulacion)
    {
        ArrayList<Tripulante> tripulantes = new ArrayList<Tripulante>();
        String codigoTripulacion = tripulacion.getCodigo();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM PERSONA INNER JOIN TRIPULANTE ON PERSONA.ID = TRIPULANTE.ID_PERSONA INNER JOIN DIRECCION ON TRIPULANTE.ID_PERSONA = DIRECCION.ID_PERSONA WHERE TRIPULANTE.CODIGO_TRIPULACION='"+codigoTripulacion+"'";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Tripulante tripulante = new Tripulante();
                Direccion direccion = new Direccion();
                tripulante.setId(rs.getString("ID"));
                tripulante.setNombre(rs.getString("NOMBRE"));
                tripulante.setApellidos(rs.getString("APELLIDOS"));
                tripulante.setNacionalidad(rs.getString("NACIONALIDAD"));
                tripulante.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                tripulante.setGenero(rs.getString("GENERO"));
                tripulante.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                tripulantes.add(tripulante);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tripulantes;
    }

    /**
     * Metodo para listar los tripulantes asignados a una tripulación
     */
    public ArrayList<Tripulante> listarTripulantesAsignadosATripulacion(Tripulacion tripulacion)
    {
        ArrayList<Tripulante> tripulantes = new ArrayList<Tripulante>();
        String codigoTripulacion = tripulacion.getCodigo();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM PERSONA INNER JOIN TRIPULANTE ON PERSONA.ID = TRIPULANTE.ID_PERSONA INNER JOIN DIRECCION ON TRIPULANTE.ID_PERSONA = DIRECCION.ID_PERSONA WHERE TRIPULANTE.CODIGO_TRIPULACION IS NOT NULL";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Tripulante tripulante = new Tripulante();
                Direccion direccion = new Direccion();
                tripulante.setId(rs.getString("ID"));
                tripulante.setNombre(rs.getString("NOMBRE"));
                tripulante.setApellidos(rs.getString("APELLIDOS"));
                tripulante.setNacionalidad(rs.getString("NACIONALIDAD"));
                tripulante.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                tripulante.setGenero(rs.getString("GENERO"));
                tripulante.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                tripulantes.add(tripulante);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tripulantes;
    }

    /**
     * Metodo para eliminar un tripulante de una tripulacion
     * @param tripulante es de tipo Tripulantes y corresponde al tripulante a agregar
     * @param tripulacion es de tipo Tripulacion y corresponde a la tripulacion a la que se va a agregar el tripulante
     */
    public void eliminarTripulanteDeTripulacion(Tripulante tripulante, Tripulacion tripulacion) {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE TRIPULANTE SET CODIGO_TRIPULACION=NULL WHERE ID_PERSONA=?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tripulante.getId());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}


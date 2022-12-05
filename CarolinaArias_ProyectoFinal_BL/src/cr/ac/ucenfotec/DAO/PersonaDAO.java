package cr.ac.ucenfotec.DAO;

import cr.ac.ucenfotec.config.Configuracion;
import cr.ac.ucenfotec.entidades.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
            String query = "SELECT * FROM PERSONA";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setId(rs.getString("ID"));
                personas.add(persona);
            }
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return personas;
    }
}

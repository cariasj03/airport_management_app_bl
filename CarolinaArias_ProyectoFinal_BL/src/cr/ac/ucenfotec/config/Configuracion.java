package cr.ac.ucenfotec.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private String claseJDBC;
    private String stringConexion;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Configuracion() {
        leerConfiguracion();
    }

    /**
     * Este es el constructor con todos los atributos
     * @param claseJDBC es de tipo String y corresponde a la clase JDBC
     * @param stringConexion de tipo String y corresponde al string de conexion con la base de datos
     */
    public Configuracion(String claseJDBC, String stringConexion) {
        this.claseJDBC = claseJDBC;
        this.stringConexion = stringConexion;
    }

    /**
     * Getters y setters de los atributos de la clase
     */
    public String getClaseJDBC() {
        return claseJDBC;
    }

    public void setClaseJDBC(String claseJDBC) {
        this.claseJDBC = claseJDBC;
    }

    public String getStringConexion() {
        return stringConexion;
    }

    public void setStringConexion(String stringConexion) {
        this.stringConexion = stringConexion;
    }

    /**
     * Funcion que se encarga de leer el archivo de configuracion
     */
    public void leerConfiguracion() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\caria\\OneDrive\\Documentos\\U\\CENFOTEC\\4. Progra Orientada a Objetos\\Repositorios\\Proyectos\\carolinaarias_proyectofinal_bl\\CarolinaArias_ProyectoFinal_BL\\src\\cr\\ac\\ucenfotec\\config\\config.properties");
            properties.load(fileInputStream);
            this.setClaseJDBC(properties.getProperty("claseJDBC"));
            this.setStringConexion(properties.getProperty("stringConexion"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
package cr.ac.ucenfotec.bl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class BL {
    static ArrayList<Administrador> listaAdministradores = new ArrayList<>();
    static ArrayList<Aeropuerto> listaAeropuertos = new ArrayList<>();
    static ArrayList<Vuelo> listaVuelos = new ArrayList<>();
    static ArrayList<Ubicacion> listaUbicaciones = new ArrayList<>();

    //Crear Administrador
    /**
     * Metodo para crear un administrador
     * @param id es de tipo String y corresponde al id del administrador
     * @param nombre es de tipo String y corresponde al nombre del administrador
     * @param apellidos es de tipo String y corresponde a los apellidos del administrador
     * @param nacionalidad es de tipo String y corresponde a la nacionalidad del administrador
     * @param fechaNacimiento es de tipo LocalDate y corresponde a la fecha de nacimiento del administrador
     * @param edad es de tipo int y corresponde la edad del administrador
     * @param genero es de tipo String y corresponde al genero del administrador
     * @param correoElectronico es de tipo String y corresponde al correo electronico del administrador
     * @param provincia es de tipo String y corresponde a la provincia de residencia del administrador
     * @param canton es de tipo String y corresponde al canton de residencia del administrador
     * @param distrito es de tipo String y corresponde al distrito de residencia del administrador
     * @param detalleDireccion es de tipo String y corresponde al detalle de la direccion de la residencia del administrador
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se creo con exito el administrador o no
     */
    public static String crearAdministrador (String id, String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String correoElectronico, String provincia, String canton, String distrito, String detalleDireccion)
    {
        String mensaje;
        if (existeAdministrador(id)) {
            mensaje = "El administrador no puede ser creado debido a que ya existe en el sistema un administrador registrado con ese ID.";
        } else {
            Administrador administrador = new Administrador(id, nombre, apellidos, nacionalidad, fechaNacimiento, edad, genero, correoElectronico, provincia, canton, distrito, detalleDireccion);
            listaAdministradores.add(administrador);
            mensaje = "El administrador fue creado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si el adminitrador ya se encuentra registrado en el sistema
     * @param id es de tipo String y corresponde al id del administrador
     * @return existeAdministrador es de tipo boolean y devuelve si el administrador ya existe en el sistema
     */
    public static boolean existeAdministrador (String id) {
        boolean existeAdministrador = false;

        for(Administrador administrador:listaAdministradores) {
            if (id.equals(administrador.getId())) {
                existeAdministrador = true;
                break;
            }
        }
        return existeAdministrador;
    }

    //CRUD Aeropuertos
    /**
     * Metodo para agregar un nuevo aeropuerto
     * @param nombre es de tipo String y corresponde al nombre del aeropuerto
     * @param codigo es de tipo String y corresponde al codigo del aeropuerto
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se agrego con exito el aeropuerto o no
     */
    public static String agregarAeropuerto (String nombre, String codigo)
    {
        String mensaje;
        if (existeAeropuerto(codigo)) {
            mensaje = "El aeropuerto no puede ser agregado debido a que ya existe en el sistema un aeropuerto registrado con ese código.";
        } else {
            Aeropuerto aeropuerto = new Aeropuerto(nombre, codigo);
            listaAeropuertos.add(aeropuerto);
            mensaje = "El aeropuerto fue agregado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si el aeropuerto ya se encuentra registrado en el sistema
     * @param codigo es de tipo String y corresponde al codigo del aeropuerto
     * @return existeAeropuerto es de tipo boolean y devuelve si el aeropuerto ya existe en el sistema
     */
    public static boolean existeAeropuerto (String codigo) {
        boolean existeAeropuerto = false;

        for(Aeropuerto aeropuerto:listaAeropuertos) {
            if (codigo.equals(aeropuerto.getCodigo())) {
                existeAeropuerto = true;
                break;
            }
        }
        return existeAeropuerto;
    }

    /**
     * Metodo para listar los aeropuertos registrados en el sistema
     * @return listaAeropuertos es de tipo ArrayList<Aeropuerto> y devuelve la lista de aeropuertos registrados
     */
    public static ArrayList<Aeropuerto> listarAeropuertos() {
        return listaAeropuertos;
    }

    /**
     * Metodo para modificar un aeropuerto existente en el sistema
     * @param nuevoNombre es de tipo String y corresponde al nuevo nombre del aeropuerto
     * @param codigo es de tipo String y corresponde al codigo del aeropuerto por modificar
     * @param nuevoCodigo es de tipo String y correspond al nuevo codigo del aeropuerto
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se modifico con exito el aeropuerto o no
     */
    public static String modificarAeropuerto (String nuevoNombre, String codigo, String nuevoCodigo)
    {
        String mensaje;
        if (existeAeropuerto(codigo)) {
            int i = 0;
            Aeropuerto aeropuertoModificado = new Aeropuerto(nuevoNombre, nuevoCodigo);
            for(Aeropuerto aeropuerto:listaAeropuertos) {
                if (codigo.equals(aeropuerto.getCodigo())) {
                    i = listaAeropuertos.indexOf(aeropuerto);
                }
            }
            listaAeropuertos.set(i, aeropuertoModificado);
            mensaje = "El aeropuerto fue modificado con éxito.";
        } else {
            mensaje = "El aeropuerto no puede ser modificado debido a que no existe en el sistema un aeropuerto registrado con ese código.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un aeropuerto del sistema
     * @param codigo es de tipo String y corresponde al codigo del aeropuerto por eliminar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se elimino con exito el aeropuerto o no
     */
    public static String eliminarAeropuerto (String codigo)
    {
        String mensaje;
        if (existeAeropuerto(codigo)) {
            int i = 0;
            for(Aeropuerto aeropuerto:listaAeropuertos) {
                if (codigo.equals(aeropuerto.getCodigo())) {
                    i = listaAeropuertos.indexOf(aeropuerto);
                }
            }
            listaAeropuertos.remove(i);
            mensaje = "El aeropuerto fue eliminado con éxito.";
        } else {
            mensaje = "El aeropuerto no puede ser eliminado debido a que no existe en el sistema un aeropuerto registrado con ese código.";
        }
        return mensaje;
    }

    //CRUD Vuelos
    /**
     * Metodo para agregar un nuevo vuelo
     * @param numeroVuelo es de tipo int y corresponde al numero del vuelo
     * @param horaSalida es de tipo LocalTime y corresponde a la hora de salida del vuelo
     * @param horaLlegada es de tipo LocalTime y corresponde a la hora de llegada del vuelo
     * @param estado es de tipo String y corresponde al estado del vuelo
     * @param tipoVuelo es de tipo String y corresponde al tipo de vuelo
     * @param cantAsientosDiponibles es de tipo int y corresponde a la cantidad de asientos disponibles en el vuelo
     * @param precioAsientos es de tipo double y corresponde al precio de los asientos del vuelo
     * @param montoImpuesto es de tipo double y corresponde al monto del impuesto para los tiquetes del vuelo
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se agrego con exito el vuelo o no
     */
    public static String agregarVuelo (int numeroVuelo, LocalTime horaSalida, LocalTime horaLlegada, String estado, String tipoVuelo, int cantAsientosDiponibles, double precioAsientos, double montoImpuesto)
    {
        String mensaje;
        if (existeVuelo(numeroVuelo)) {
            mensaje = "El vuelo no puede ser agregado debido a que ya existe en el sistema un vuelo registrado con ese número.";
        } else {
            Vuelo vuelo = new Vuelo(numeroVuelo, horaSalida, horaLlegada, estado, tipoVuelo, cantAsientosDiponibles, precioAsientos, montoImpuesto);
            listaVuelos.add(vuelo);
            mensaje = "El vuelo fue agregado con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si el vuelo ya se encuentra registrado en el sistema
     * @param numeroVuelo es de tipo String y corresponde al numero de vuelo
     * @return existeVuelo es de tipo boolean y devuelve si el vuelo ya existe en el sistema
     */
    public static boolean existeVuelo (int numeroVuelo) {
        boolean existeVuelo = false;

        for(Vuelo vuelo:listaVuelos) {
            if (numeroVuelo == vuelo.getNumeroVuelo()) {
                existeVuelo = true;
                break;
            }
        }
        return existeVuelo;
    }

    /**
     * Metodo para listar los vuelos registrados en el sistema
     * @return listaVuelos es de tipo ArrayList<Vuelo> y devuelve la lista de vuelos registrados
     */
    public static ArrayList<Vuelo> listarVuelos() {
        return listaVuelos;
    }

    /**
     * Metodo para modificar un vuelo existente en el sistema
     * @param numeroVuelo es de tipo int y corresponde al numero del vuelo por modificar
     * @param nuevoNumeroVuelo es de tipo int y corresponde al nuevo numero del vuelo
     * @param nuevaHoraSalida es de tipo LocalTime y corresponde a la nueva hora de salida del vuelo
     * @param nuevaHoraLlegada es de tipo LocalTime y corresponde a la nueva hora de llegada del vuelo
     * @param nuevoEstado es de tipo String y corresponde al nuevo estado del vuelo
     * @param nuevoTipoVuelo es de tipo String y corresponde al nuevo tipo de vuelo
     * @param nuevaCantAsientosDiponibles es de tipo int y corresponde a la nueva cantidad de asientos disponibles en el vuelo
     * @param nuevoPrecioAsientos es de tipo double y corresponde al nuevo precio de los asientos del vuelo
     * @param nuevoMontoImpuesto es de tipo String y corresponde al nuevo monto del impuesto para los tiquetes del vuelo
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se modifico con exito el vuelo o no
     */
    public static String modificarVuelo (int numeroVuelo, int nuevoNumeroVuelo, LocalTime nuevaHoraSalida, LocalTime nuevaHoraLlegada, String nuevoEstado, String nuevoTipoVuelo, int nuevaCantAsientosDiponibles, double nuevoPrecioAsientos, double nuevoMontoImpuesto)
    {
        String mensaje;
        if (existeVuelo(numeroVuelo)) {
            int i = 0;
        Vuelo vueloModificado = new Vuelo(nuevoNumeroVuelo, nuevaHoraSalida, nuevaHoraLlegada, nuevoEstado, nuevoTipoVuelo, nuevaCantAsientosDiponibles, nuevaCantAsientosDiponibles, nuevoMontoImpuesto);
            for(Vuelo vuelo:listaVuelos) {
                if (numeroVuelo == vuelo.getNumeroVuelo()) {
                    i = listaVuelos.indexOf(vuelo);
                }
            }
            listaVuelos.set(i, vueloModificado);
            mensaje = "El vuelo fue modificado con éxito.";
        } else {
            mensaje = "El vuelo no puede ser modificado debido a que no existe en el sistema un vuelo registrado con ese número.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un vuelo del sistema
     * @param numeroVuelo es de tipo int y corresponde al numero del vuelo por eliminar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se elimino con exito el vuelo o no
     */
    public static String eliminarVuelo (int numeroVuelo)
    {
        String mensaje;
        if (existeVuelo(numeroVuelo)) {
            int i = 0;
            for(Vuelo vuelo:listaVuelos) {
                if (numeroVuelo == vuelo.getNumeroVuelo()) {
                    i = listaVuelos.indexOf(vuelo);
                }
            }
            listaVuelos.remove(i);
            mensaje = "El vuelo fue eliminado con éxito.";
        } else {
            mensaje = "El vuelo no puede ser eliminado debido a que no existe en el sistema un vuelo registrado con ese número.";
        }
        return mensaje;
    }

    //CRUD Ubicaciones
    /**
     * Metodo para agregar una nueva ubicacion
     * @param codigo es de tipo String y corresponde al codigo de la ubicacion
     * @param nivel es de tipo int y corresponde al nivel donde se encuentra la ubicacion
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se agrego con exito la ubicacion o no
     */
    public static String agregarUbicacion(String codigo, int nivel)
    {
        String mensaje;
        if (existeUbicacion(codigo)) {
            mensaje = "La ubicación no puede ser agregada debido a que ya existe en el sistema una ubicación registrada con ese código.";
        } else {
            Ubicacion ubicacion = new Ubicacion(codigo, nivel);
            listaUbicaciones.add(ubicacion);
            mensaje = "La ubicación fue agregada con éxito.";
        }
        return mensaje;
    }

    /**
     * Metodo para verificar si la ubicacion ya se encuentra registrada en el sistema
     * @param codigo es de tipo String y corresponde al codigo de la ubicacion
     * @return existeUbicacion es de tipo boolean y devuelve si la ubicacion ya existe en el sistema
     */
    public static boolean existeUbicacion (String codigo) {
        boolean existeUbicacion = false;

        for(Ubicacion ubicacion:listaUbicaciones) {
            if (codigo.equals(ubicacion.getCodigo())) {
                existeUbicacion = true;
                break;
            }
        }
        return existeUbicacion;
    }

    /**
     * Metodo para listar las ubicaciones registradas en el sistema
     * @return listaUbicaciones es de tipo ArrayList<Ubicacion> y devuelve la lista de ubicaciones registradas
     */
    public static ArrayList<Ubicacion> listarUbicaciones() {
        return listaUbicaciones;
    }

    /**
     * Metodo para modificar una ubicacion existente en el sistema
     * @param codigo es de tipo String y corresponde al codigo de la ubicacion por modificar
     * @param nuevoCodigo es de tipo String y corresponde al nuevo codigo de la ubicacion
     * @param nuevoNivel es de tipo int y corresponde al nuevo nivel de la ubicacion
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se modifico con exito la ubicacion o no
     */
    public static String modificarUbicacion (String codigo, String nuevoCodigo, int nuevoNivel)
    {
        String mensaje;
        if (existeUbicacion(codigo)) {
            int i = 0;
            Ubicacion ubicacionModificada = new Ubicacion(nuevoCodigo, nuevoNivel);
            for(Ubicacion ubicacion:listaUbicaciones) {
                if (codigo.equals(ubicacion.getCodigo())) {
                    i = listaUbicaciones.indexOf(ubicacion);
                }
            }
            listaUbicaciones.set(i, ubicacionModificada);
            mensaje = "La ubicación fue modificada con éxito.";
        } else {
            mensaje = "La ubicación no puede ser modificada debido a que no existe en el sistema una ubicación registrada con ese código.";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar una ubicacion del sistema
     * @param codigo es de tipo String y corresponde al codigo de la ubicacion por eliminar
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se elimino con exito la ubicacion o no
     */
    public static String eliminarUbicacion (String codigo)
    {
        String mensaje;
        if (existeUbicacion(codigo)) {
            int i = 0;
            for(Ubicacion ubicacion:listaUbicaciones) {
                if (codigo.equals(ubicacion.getCodigo())) {
                    i = listaUbicaciones.indexOf(ubicacion);
                }
            }
            listaUbicaciones.remove(i);
            mensaje = "La ubicación fue eliminada con éxito.";
        } else {
            mensaje = "La ubicación no puede ser eliminada debido a que no existe en el sistema una ubicación registrada con ese código.";
        }
        return mensaje;
    }
}

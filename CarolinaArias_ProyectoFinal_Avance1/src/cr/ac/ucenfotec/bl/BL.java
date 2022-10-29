package cr.ac.ucenfotec.bl;

import java.time.LocalTime;
import java.util.ArrayList;

public class BL {

    static ArrayList<Aeropuerto> listaAeropuertos = new ArrayList<>();
    static ArrayList<Vuelo> listaVuelos = new ArrayList<>();

    //CRUD Aeropuertos
    /**
     * Metodo para agregar un nuevo aeropuerto
     * @param nombre es de tipo String y corresponde al nombre del aeropuerto
     * @param codigo es de tipo String y corresponde al codigo del aeropuerto
     * @param pais es de tipo Pais y corresponde al pais donde se encuentra el aeropuerto
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se agrego con exito el aeropuerto o no
     */
    public static String agregarAeropuerto (String nombre, String codigo, Pais pais)
    {
        String mensaje;
        if (existeAeropuerto(codigo)) {
            mensaje = "El aeropuerto no puede ser agregado debido a que ya existe en el sistema un aeropuerto registrado con ese código.";
        } else {
            Aeropuerto aeropuerto = new Aeropuerto(nombre, codigo, pais);
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
     * @param nuevoPais es de tipo Pais y corresponde al nuevo pais donde se encuentra el aeropuerto
     * @param nuevoCodigo es de tipo String y correspond al nuevo codigo del aeropuerto
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se modifico con exito el aeropuerto o no
     */
    public static String modificarAeropuerto (String nuevoNombre, String codigo, Pais nuevoPais, String nuevoCodigo)
    {
        String mensaje;
        if (existeAeropuerto(codigo)) {
            int i = 0;
            Aeropuerto aeropuertoModificado = new Aeropuerto(nuevoNombre, nuevoCodigo, nuevoPais);
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
     * @param montoImpuesto es de tipo String y corresponde al monto del impuesto para los tiquetes del vuelo
     * @param aeropuertoOrigen es de tipo Aeropuerto y corresponde al aeropuerto de origen del vuelo
     * @param aeropuertoDestino es de tipo Aeropuerto y corresponde al aeropuerto de destino del vuelo
     * @param aerolinea es de tipo Aerolinea y corresponde a la aerolinea que opera el vuelo
     * @param tripulacion es de tipo Tripulacion y corresponde la tripulacion que atiende el vuelo
     * @param aeronave es de tipo Aeronave y corresponde a la aeronave asignada al vuelo
     * @param puertaLlegada es de tipo Puerta y corresponde a la puerta de llegada del vuelo
     * @param puertaSalida es de tipo Puerta y corresponde a la puerta de salida del vuelo
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se agrego con exito el vuelo o no
     */
    public static String agregarVuelo (int numeroVuelo, LocalTime horaSalida, LocalTime horaLlegada, String estado, String tipoVuelo, int cantAsientosDiponibles, double precioAsientos, double montoImpuesto, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Aerolinea aerolinea, Tripulacion tripulacion, Aeronave aeronave, Puerta puertaLlegada, Puerta puertaSalida)
    {
        String mensaje;
        if (existeVuelo(numeroVuelo)) {
            mensaje = "El vuelo no puede ser agregado debido a que ya existe en el sistema un vuelo registrado con ese número.";
        } else {
            Vuelo vuelo = new Vuelo(numeroVuelo, horaSalida, horaLlegada, estado, tipoVuelo, cantAsientosDiponibles, precioAsientos, montoImpuesto, aeropuertoOrigen, aeropuertoDestino, aerolinea, tripulacion, aeronave, puertaLlegada, puertaSalida);
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
     * @param nuevoAeropuertoOrigen es de tipo Aeropuerto y corresponde al nuevo aeropuerto de origen del vuelo
     * @param nuevoAeropuertoDestino es de tipo Aeropuerto y corresponde al nuevo aeropuerto de destino del vuelo
     * @param nuevaAerolinea es de tipo Aerolinea y corresponde a la nueva aerolinea que opera el vuelo
     * @param nuevaTripulacion es de tipo Tripulacion y corresponde la nueva tripulacion que atiende el vuelo
     * @param nuevaAeronave es de tipo Aeronave y corresponde a la nueva aeronave asignada al vuelo
     * @param nuevaPuertaLlegada es de tipo Puerta y corresponde a la nueva puerta de llegada del vuelo
     * @param nuevaPuertaSalida es de tipo Puerta y corresponde a la nueva puerta de salida del vuelo
     * @return mensaje es de tipo String y devuelve un mensaje que indica si se modifico con exito el vuelo o no
     */
    public static String modificarVuelo (int numeroVuelo, int nuevoNumeroVuelo, LocalTime nuevaHoraSalida, LocalTime nuevaHoraLlegada, String nuevoEstado, String nuevoTipoVuelo, int nuevaCantAsientosDiponibles, double nuevoPrecioAsientos, double nuevoMontoImpuesto, Aeropuerto nuevoAeropuertoOrigen, Aeropuerto nuevoAeropuertoDestino, Aerolinea nuevaAerolinea, Tripulacion nuevaTripulacion, Aeronave nuevaAeronave, Puerta nuevaPuertaLlegada, Puerta nuevaPuertaSalida)
    {
        String mensaje;
        if (existeVuelo(numeroVuelo))) {
            int i = 0;
        Vuelo vueloModificado = new Vuelo(numeroVuelo, nuevaHoraSalida, nuevaHoraLlegada, nuevoEstado, nuevoTipoVuelo, nuevaCantAsientosDiponibles, nuevaCantAsientosDiponibles, nuevoMontoImpuesto, nuevoAeropuertoOrigen, nuevoAeropuertoDestino, nuevaAerolinea, nuevaTripulacion, nuevaAeronave, nuevaPuertaLlegada, nuevaPuertaSalida);
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
}

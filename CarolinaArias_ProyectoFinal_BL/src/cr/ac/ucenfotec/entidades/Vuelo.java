package cr.ac.ucenfotec.entidades;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 26/10/2022
 *
 * Esta clase se encarga de gestionar todos los objetos Vuelo
 */

public class Vuelo {
    /**
     * Declaracion de atributos del objeto
     */
    private int numeroVuelo;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private String estado;
    private String tipoVuelo;
    private int cantAsientosDiponibles;
    private double precioAsientos;
    private double montoImpuesto;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private Aerolinea aerolinea;
    private Tripulacion tripulacion;
    private Aeronave aeronave;
    private Puerta puertaLlegada;
    private Puerta puertaSalida;
    private ArrayList<Tiquete> tiquetes;

    //Seteo de los constructores
    /**
     * Este es el constructor por defecto
     */
    public Vuelo() {
    }

    /**
     * Este es el constructor con todos los atributos
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
     */
    public Vuelo(int numeroVuelo, LocalTime horaSalida, LocalTime horaLlegada, String estado, String tipoVuelo, int cantAsientosDiponibles, double precioAsientos, double montoImpuesto, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Aerolinea aerolinea, Tripulacion tripulacion, Aeronave aeronave, Puerta puertaLlegada, Puerta puertaSalida) {
        this.numeroVuelo = numeroVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.estado = estado;
        this.tipoVuelo = tipoVuelo;
        this.cantAsientosDiponibles = cantAsientosDiponibles;
        this.precioAsientos = precioAsientos;
        this.montoImpuesto = montoImpuesto;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.aerolinea = aerolinea;
        this.tripulacion = tripulacion;
        this.aeronave = aeronave;
        this.puertaLlegada = puertaLlegada;
        this.puertaSalida = puertaSalida;
        this.tiquetes = new ArrayList<Tiquete>();
    }

    /**
     * Este es un constructor con los atributos de tipo nativo
     * @param numeroVuelo es de tipo int y corresponde al numero del vuelo
     * @param horaSalida es de tipo LocalTime y corresponde a la hora de salida del vuelo
     * @param horaLlegada es de tipo LocalTime y corresponde a la hora de llegada del vuelo
     * @param estado es de tipo String y corresponde al estado del vuelo
     * @param tipoVuelo es de tipo String y corresponde al tipo de vuelo
     * @param cantAsientosDiponibles es de tipo int y corresponde a la cantidad de asientos disponibles en el vuelo
     * @param precioAsientos es de tipo double y corresponde al precio de los asientos del vuelo
     * @param montoImpuesto es de tipo double y corresponde al monto del impuesto para los tiquetes del vuelo
     */
    public Vuelo(int numeroVuelo, LocalTime horaSalida, LocalTime horaLlegada, String estado, String tipoVuelo, int cantAsientosDiponibles, double precioAsientos, double montoImpuesto) {
        this.numeroVuelo = numeroVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.estado = estado;
        this.tipoVuelo = tipoVuelo;
        this.cantAsientosDiponibles = cantAsientosDiponibles;
        this.precioAsientos = precioAsientos;
        this.montoImpuesto = montoImpuesto;
        this.tiquetes = new ArrayList<Tiquete>();
    }

    /**
     * Este es un constructor con los atributos de tipo nativo + aeropuertos, aeorlinea, tripulacion y puertas
     * @param numeroVuelo es de tipo int y corresponde al numero del vuelo
     * @param horaSalida es de tipo LocalTime y corresponde a la hora de salida del vuelo
     * @param horaLlegada es de tipo LocalTime y corresponde a la hora de llegada del vuelo
     * @param estado es de tipo String y corresponde al estado del vuelo
     * @param tipoVuelo es de tipo String y corresponde al tipo de vuelo
     * @param cantAsientosDiponibles es de tipo int y corresponde a la cantidad de asientos disponibles en el vuelo
     * @param precioAsientos es de tipo double y corresponde al precio de los asientos del vuelo
     * @param montoImpuesto es de tipo double y corresponde al monto del impuesto para los tiquetes del vuelo
     */
    public Vuelo(int numeroVuelo, LocalTime horaSalida, LocalTime horaLlegada, String estado, String tipoVuelo, int cantAsientosDiponibles, double precioAsientos, double montoImpuesto, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Aerolinea aerolinea, Tripulacion tripulacion, Puerta puertaLlegada, Puerta puertaSalida) {
        this.numeroVuelo = numeroVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.estado = estado;
        this.tipoVuelo = tipoVuelo;
        this.cantAsientosDiponibles = cantAsientosDiponibles;
        this.precioAsientos = precioAsientos;
        this.montoImpuesto = montoImpuesto;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.aerolinea = aerolinea;
        this.tripulacion = tripulacion;
        this.puertaLlegada = puertaLlegada;
        this.puertaSalida = puertaSalida;
        this.tiquetes = new ArrayList<Tiquete>();
    }

    /**
     * Getters y setters de los atributos del objeto
     */
    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(int numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public int getCantAsientosDiponibles() {
        return cantAsientosDiponibles;
    }

    public void setCantAsientosDiponibles(int cantAsientosDiponibles) {
        this.cantAsientosDiponibles = cantAsientosDiponibles;
    }

    public Double getPrecioAsientos() {
        return precioAsientos;
    }

    public void setPrecioAsientos(double precioAsientos) {
        this.precioAsientos = precioAsientos;
    }

    public Double getMontoImpuesto() {
        return montoImpuesto;
    }

    public void setMontoImpuesto(double montoImpuesto) {
        this.montoImpuesto = montoImpuesto;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Tripulacion getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(Tripulacion tripulacion) {
        this.tripulacion = tripulacion;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Puerta getPuertaLlegada() {
        return puertaLlegada;
    }

    public void setPuertaLlegada(Puerta puertaLlegada) {
        this.puertaLlegada = puertaLlegada;
    }

    public Puerta getPuertaSalida() {
        return puertaSalida;
    }

    public void setPuertaSalida(Puerta puertaSalida) {
        this.puertaSalida = puertaSalida;
    }

    public ArrayList<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(ArrayList<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return devuelve todos los atributos del objeto en formato String
     */
    @Override
    public String toString() {
        return "Vuelo{" +
                "numeroVuelo=" + numeroVuelo +
                ", horaSalida=" + horaSalida +
                ", horaLlegada=" + horaLlegada +
                ", estado='" + estado + '\'' +
                ", tipoVuelo='" + tipoVuelo + '\'' +
                ", cantAsientosDiponibles=" + cantAsientosDiponibles +
                ", precioAsientos=" + precioAsientos +
                ", montoImpuesto=" + montoImpuesto +
                ", aeropuertoOrigen=" + aeropuertoOrigen +
                ", aeropuertoDestino=" + aeropuertoDestino +
                ", aerolinea=" + aerolinea +
                ", tripulacion=" + tripulacion +
                ", aeronave=" + aeronave +
                ", puertaLlegada=" + puertaLlegada +
                ", puertaSalida=" + puertaSalida +
                ", tiquetes=" + tiquetes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return numeroVuelo == vuelo.numeroVuelo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroVuelo);
    }
}
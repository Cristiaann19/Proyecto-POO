package ClasesBase;

import ClasesBase.Avion.Avion;
import ClasesBase.Persona.Pasajero;
import ClasesBase.Persona.Piloto;
import ClasesBase.Persona.Tripulante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Vuelo {
    private String Origen;
    private String Destino;
    private LocalDate Fecha;
    private Avion avion;
    private List<Piloto> Pilotos;
    private List<Tripulante> Tripulacion;
    private List<Pasajero> Pasajeros;
    private List<Boleto> boletos;

    public Vuelo(String origen, String destino, LocalDate fecha, Avion avion, List<Piloto> pilotos, List<Tripulante> tripulacion) {
        this.Origen = origen;
        this.Destino = destino;
        this.Fecha = fecha;
        this.avion = avion;
        this.Pilotos = pilotos;
        this.Tripulacion = tripulacion;
        this.Pasajeros = new ArrayList<>();
        this.boletos = new ArrayList<>();
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }


    public List<Piloto> getPilotos() {
        return Pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        Pilotos = pilotos;
    }

    public List<Tripulante> getTripulacion() {
        return Tripulacion;
    }

    public void setTripulacion(List<Tripulante> tripulacion) {
        Tripulacion = tripulacion;
    }

    public List<Pasajero> getPasajeros() {
        return Pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        Pasajeros = pasajeros;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    @Override
    public String toString() {
        return "Vuelo:\n" +
                "    Origen: '" + Origen + "'\n" +
                "    Destino: '" + Destino + "'\n" +
                "    Fecha: " + Fecha+"\n";
    }

}

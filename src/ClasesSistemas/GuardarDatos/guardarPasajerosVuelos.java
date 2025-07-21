package ClasesSistemas.GuardarDatos;

import ClasesBase.Boleto;
import ClasesBase.Vuelo;
import ClasesBase.Persona.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class guardarPasajerosVuelos {

    public static void guardarVuelos(String archivo, List<Vuelo> vuelos) throws IOException {
        String archivoTemporal = archivo + ".tmp";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {
            for (Vuelo vuelo : vuelos) {

                String pilotos = vuelo.getPilotos().stream()
                        .map(p -> String.valueOf(p.getDni()))
                        .reduce((a, b) -> a + "," + b).orElse("");

                String tripulantes = vuelo.getTripulacion().stream()
                        .map(t -> String.valueOf(t.getDni()))
                        .reduce((a, b) -> a + "-" + b).orElse("");

                writer.write(String.format("%s,%s,%s,%s,%s,%s%n",
                        vuelo.getOrigen(),
                        vuelo.getDestino(),
                        vuelo.getFecha(),
                        vuelo.getAvion().getMatricula(),
                        pilotos,
                        tripulantes
                ));
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los vuelos: " + e.getMessage());
            throw e;
        }


        renombrarArchivos.reemplazarArchivo(archivo, archivoTemporal);

    }


    public static void guardarPasajeros(String archivo, ArrayList<Vuelo> vuelos) throws IOException {
        String archivoTemporal = archivo + ".tmp";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {
            int cont = 1;
            for (Vuelo vuelo : vuelos) {

                for (Boleto boleto : vuelo.getBoletos()) {

                    Pasajero pasajero = boleto.getPasajero();


                    int idBoleto = boleto.getIdBoleto();
                    String clase = boleto.getClase();
                    boolean estadoPago = boleto.isEstado();

                    int claseNumero = 0;
                    switch (clase) {
                        case "Primera Clase":
                            claseNumero = 1;
                            break;
                        case "Ejecutivo":
                            claseNumero = 2;
                            break;
                        case "Economico":
                            claseNumero = 3;
                            break;
                        default:
                            System.err.println("Clase no reconocida para el boleto con ID: " + idBoleto);
                            break;
                    }


                    String estadoPagoTexto = estadoPago ? "true" : "false";

                    writer.write(pasajero.getDni() + "," +
                            pasajero.getNombre() + "," +
                            pasajero.getFechaNacimiento() + "," +
                            pasajero.getEmail() + "," +
                            pasajero.getTelefono() + "," +
                            pasajero.getNacionalidad() + "," +
                            cont + "," +
                            claseNumero + "," +
                            estadoPagoTexto);
                    writer.newLine();
                }
                cont++;
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los pasajeros: " + e.getMessage());
            throw e;
        }

        renombrarArchivos.reemplazarArchivo(archivo, archivoTemporal);
    }
}

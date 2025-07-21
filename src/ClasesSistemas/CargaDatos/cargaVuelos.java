package ClasesSistemas.CargaDatos;

import ClasesBase.Avion.*;
import ClasesBase.Persona.*;
import ClasesBase.Vuelo;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public final class cargaVuelos {
    public static List<Vuelo> cargarVuelos(String archivo, List<Avion> aviones, List<Piloto> pilotos, List<Tripulante> tripulantes) throws IOException {
        List<Vuelo> vuelos = new ArrayList<>();
        List<String> lineas = Files.readAllLines(Paths.get(archivo));

        for (String linea : lineas) {
            if (linea.trim().isEmpty()) {
                continue;
            }

            String[] datos = linea.split(",");

            if (datos.length != 7) {
                System.err.println("Línea malformada: " + linea);
                continue; // Ignorar esta línea y pasar a la siguiente
            }

            try {
                String origen = datos[0];
                String destino = datos[1];
                LocalDate fecha = LocalDate.parse(datos[2]);
                String avionCodigo = datos[3];
                int piloto1DNI = Integer.parseInt(datos[4]);
                int piloto2DNI = Integer.parseInt(datos[5]);
                String[] tripulantesDNIs = datos[6].split("-");

                Avion avion = aviones.stream()
                        .filter(a -> a.getMatricula().equals(avionCodigo))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Avión no encontrado: " + avionCodigo));

                Piloto piloto1 = pilotos.stream()
                        .filter(p -> p.getDni() == piloto1DNI)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Piloto no encontrado: " + piloto1DNI));

                Piloto piloto2 = pilotos.stream()
                        .filter(p -> p.getDni() == piloto2DNI)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Piloto no encontrado: " + piloto2DNI));

                List<Tripulante> tripulantesAsignados = Arrays.stream(tripulantesDNIs)
                        .map(Integer::parseInt)
                        .map(dni -> tripulantes.stream()
                                .filter(t -> t.getDni() == dni)
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException("Tripulante no encontrado: " + dni)))
                        .collect(Collectors.toList());

                if (tripulantesAsignados.size() != 4) {
                    throw new RuntimeException("Se requieren exactamente 4 tripulantes por vuelo.");
                }

                Vuelo vuelo = new Vuelo(origen, destino, fecha, avion, List.of(piloto1, piloto2), tripulantesAsignados);
                vuelos.add(vuelo);

            } catch (RuntimeException e) {
                System.err.println("Error procesando línea: " + linea);
                System.err.println("Detalle del error: " + e.getMessage());
            }
        }

        return vuelos;
    }
}

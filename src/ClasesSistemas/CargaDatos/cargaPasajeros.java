package ClasesSistemas.CargaDatos;

import ClasesSistemas.SubSistemas.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public final class cargaPasajeros {
    public static void cargarPasajeros(String archivo, SistemaPasajero sistemaPasajero) throws IOException {

        List<String> lineas = Files.readAllLines(Paths.get(archivo));

        for (String linea : lineas) {
            String[] datos = linea.split(",");

            int dni = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            LocalDate fechaNacimiento = LocalDate.parse(datos[2]);
            String email = datos[3];
            int telefono = Integer.parseInt(datos[4]);
            String nacionalidad = datos[5];
            int idVuelo = Integer.parseInt(datos[6]);
            int asiento = Integer.parseInt(datos[7]);
            boolean estado = Boolean.parseBoolean(datos[8]);

            sistemaPasajero.Registrar(dni, nombre, fechaNacimiento, email, telefono, nacionalidad, idVuelo, asiento, estado);
        }
    }
}

package ClasesSistemas.GuardarDatos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class renombrarArchivos {
    public static void reemplazarArchivo(String original, String temporal) {
        Path archivoOriginal = Paths.get(original);
        Path archivoTemp = Paths.get(temporal);

        try {
            Files.copy(archivoTemp, archivoOriginal, StandardCopyOption.REPLACE_EXISTING);
            //System.out.println("Archivo temporal copiado exitosamente a: " + archivoOriginal.toAbsolutePath());

            Thread.sleep(100);

            Files.delete(archivoTemp);
        } catch (IOException e) {
            System.err.println("No se pudo reemplazar el archivo temporal: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El hilo fue interrumpido: " + e.getMessage());
        }
    }
}

package ClasesBase.Persona;

import java.time.LocalDate;
import java.util.List;

public final class Piloto extends Empleado{
    private int LicenciaVuelo;
    private int HorasVuelo;
    private List<String> Idiomas;

    public Piloto(int dni, String nombre, LocalDate fechaNacimiento, String email, int telefono, LocalDate fechaContratacion, double salario, String turno, boolean estado, int licenciaVuelo, int horasVuelo, List<String> idiomas) {
        super(dni, nombre, fechaNacimiento, email, telefono, fechaContratacion, salario, turno, estado);
        LicenciaVuelo = licenciaVuelo;
        HorasVuelo = horasVuelo;
        Idiomas = idiomas;
    }

    public String getidiomas(){
        StringBuilder cadena = new StringBuilder();
        for (String idioma : Idiomas) {
            cadena.append(idioma).append(", ");
        }
        return cadena.toString();
    }

    @Override
    public String toString() {
        return "Piloto :" +
                "\n    LicenciaVuelo: " + LicenciaVuelo +
                "\n    HorasVuelo: " + HorasVuelo +
                "\n    Idiomas: " + getidiomas() +
                "\n    Turno: '" + turno + '\'' +
                "\n";
    }
}

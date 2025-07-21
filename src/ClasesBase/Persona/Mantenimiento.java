package ClasesBase.Persona;

import java.time.LocalDate;
import java.util.List;

public final class Mantenimiento extends Empleado {
    private String Especialidad;
    private List<String> Certificaciones;

    public Mantenimiento(int dni, String nombre, LocalDate fechaNacimiento, String email, int telefono, LocalDate fechaContratacion, double salario, String turno, boolean estado, String especialidad, List<String> certificaciones) {
        super(dni, nombre, fechaNacimiento, email, telefono, fechaContratacion, salario, turno, estado);
        Especialidad = especialidad;
        Certificaciones = certificaciones;
    }

    @Override
    public String toString() {
        return "Matenimiento{" +
                "Especialidad='" + Especialidad + '\'' +
                ", Certificaciones=" + Certificaciones +
                ", FechaContratacion=" + FechaContratacion +
                ", Salario=" + Salario +
                ", turno='" + turno + '\'' +
                ", Estado='" + Estado + '\'' +
                ", Dni=" + Dni +
                ", Nombre='" + Nombre + '\'' +
                ", FechaNacimiento=" + FechaNacimiento +
                ", Email='" + Email + '\'' +
                ", Telefono=" + Telefono +
                '}';
    }
}

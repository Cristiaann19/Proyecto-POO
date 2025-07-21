package ClasesBase.Persona;

import java.time.LocalDate;

public final class Administrador extends Empleado{
    private String Usuario;
    private String Contrasena;

    public Administrador(int dni, String nombre, LocalDate fechaNacimiento, String email, int telefono, LocalDate fechaContratacion, double salario, String turno, boolean estado, String Usuario, String Contrasena) {
        super(dni, nombre, fechaNacimiento, email, telefono, fechaContratacion, salario, turno, estado);
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    @Override
    public String toString() {
        return "Administrador{" +
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

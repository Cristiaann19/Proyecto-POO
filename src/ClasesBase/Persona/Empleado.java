package ClasesBase.Persona;

import java.time.LocalDate;

abstract sealed class Empleado extends Persona permits Administrador, Mantenimiento, Tripulante, Piloto {
    protected LocalDate FechaContratacion;
    protected double Salario;
    protected String turno;
    protected boolean Estado;

    public Empleado(int dni, String nombre, LocalDate fechaNacimiento, String email, int telefono, LocalDate fechaContratacion, double salario, String turno, boolean estado) {
        super(dni, nombre, fechaNacimiento, email, telefono);
        FechaContratacion = fechaContratacion;
        Salario = salario;
        this.turno = turno;
        Estado = estado;
    }

    public LocalDate getFechaContratacion() {
        return FechaContratacion;
    }

    public double getSalario() {
        return Salario;
    }

    public String getTurno() {
        return turno;
    }

    public boolean getEstado() {
        return Estado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "FechaContratacion=" + FechaContratacion +
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

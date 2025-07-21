package ClasesBase.Persona;

import java.time.LocalDate;

abstract sealed class Persona permits Pasajero, Empleado {
    protected int Dni;
    protected String Nombre;
    protected LocalDate FechaNacimiento;
    protected String Email;
    protected int Telefono;

    public Persona(int dni, String nombre, LocalDate fechaNacimiento, String email, int telefono) {
        Dni = dni;
        Nombre = nombre;
        FechaNacimiento = fechaNacimiento;
        Email = email;
        Telefono = telefono;
    }

    public int getDni() {
        return Dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public String getEmail() {
        return Email;
    }

    public int getTelefono() {
        return Telefono;
    }

    @Override
    public abstract String toString();

}

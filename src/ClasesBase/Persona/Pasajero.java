package ClasesBase.Persona;

import java.time.LocalDate;

public final class Pasajero extends Persona{
    private String Nacionalidad;

    public Pasajero(int dni, String nombre, LocalDate fechaNacimiento, String email, int telefono, String nacionalidad) {
        super(dni, nombre, fechaNacimiento, email, telefono);
        this.Nacionalidad = nacionalidad;
    }

    public int getDni() {
        return this.Dni;
    }

    public void setDni(int dni) {
        this.Dni = dni;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return this.FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public int getTelefono() {
        return this.Telefono;
    }

    public void setTelefono(int telefono) {
        this.Telefono = telefono;
    }

    public String getNacionalidad() {
        return this.Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.Nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                ", Nacionalidad='" + this.Nacionalidad + '\'' +
                ", Dni=" + this.Dni +
                ", Nombre='" + this.Nombre + '\'' +
                ", FechaNacimiento=" + this.FechaNacimiento +
                ", Email='" + this.Email + '\'' +
                ", Telefono=" + this.Telefono +
                '}';
    }

}

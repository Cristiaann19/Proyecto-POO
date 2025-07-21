package ClasesBase.Avion;

public sealed class Seccion permits PrimeraClase, Ejecutivo, Economico {
    protected String nombre;
    protected short capacidad;
    protected double precio;

    public Seccion(short capacidad, double precio) {
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Seccion{" +
                "capacidad=" + capacidad +
                ", precio=" + precio +
                '}';
    }

}

package ClasesBase.Avion;

public final class Ejecutivo extends Seccion{
    private final String nombre = "Ejecutivo";
    private boolean PrioridadEmbarque;
    private boolean ReclinacionMaxima;

    public Ejecutivo(short capacidad, double precio, boolean prioridadEmbarque, boolean reclinacionMaxima) {
        super(capacidad, precio);
        PrioridadEmbarque = prioridadEmbarque;
        ReclinacionMaxima = reclinacionMaxima;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return "Ejecutiva{" +
                "PrioridadEmbarque=" + PrioridadEmbarque +
                ", ReclinacionMaxima=" + ReclinacionMaxima +
                ", capacidad=" + capacidad +
                ", precio=" + precio +
                '}';
    }
}

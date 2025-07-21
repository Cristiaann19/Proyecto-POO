package ClasesBase.Avion;

public final class Economico extends Seccion{
    private final String nombre = "Economico";
    private boolean Entretenimiento;
    private boolean LimiteEquipaje;

    public Economico(short capacidad, double precio, boolean entretenimiento, boolean limiteEquipaje) {
        super(capacidad, precio);
        Entretenimiento = entretenimiento;
        LimiteEquipaje = limiteEquipaje;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return "Economico{" +
                "Entretenimiento=" + Entretenimiento +
                ", LimiteEquipaje=" + LimiteEquipaje +
                ", capacidad=" + capacidad +
                ", precio=" + precio +
                '}';
    }

}

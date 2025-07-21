package ClasesBase;

import ClasesBase.Persona.Pasajero;

public final class Boleto {
    private int idBoleto;
    private Pasajero pasajero;
    private Vuelo vuelo;
    private boolean estado;
    private double precio;
    private String clase;

    public Boleto(int idBoleto, Pasajero pasajero, Vuelo vuelo, boolean estado, double precio, String clase) {
        this.idBoleto = idBoleto;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.estado = estado;
        this.precio = precio;
        this.clase = clase;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }


    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getEstado_Text() {
        if (this.isEstado()) {
            return """
                    --------
                     PAGADO
                    --------
                    """;
        } else {
            return """
                    ----------------
                     PENDIENTE PAGO
                    ----------------
                    """;
        }
    }

    public String getEstado_Text2() {
        if (this.isEstado()) {
            return "PAGADO";
        } else {
            return "PENDIENTE PAGO";
        }
    }

    @Override
    public String toString() {
        return String.format("""
                ================================================================================
                |                 %12.12s                        |      JJC AIRLINES      |
                ================================================================================
                | NOMBRE: %-8.8s ORIGEN: %-8.8s DESTINO: %-8.8s | NOMBRE:  %-8.8s      |
                |                                                     | ORIGEN:  %-8.8s      |
                | FECHA: %tF                                   | DESTINO: %-8.8s      |
                |                                                     | FECHA:   %tF    |
                | CODIGO:  %-8d                                  | CODIGO:  %-10d    |
                | CLASE:   %-13.13s                              | CLASE:   %-13.13s |
                ================================================================================
                """,vuelo.getAvion().getAereolinea(),pasajero.getNombre(),vuelo.getOrigen(),vuelo.getDestino(),pasajero.getNombre(),vuelo.getOrigen(),vuelo.getFecha(),vuelo.getDestino(),vuelo.getFecha(),this.idBoleto,this.idBoleto,this.clase,this.clase);
    }
}

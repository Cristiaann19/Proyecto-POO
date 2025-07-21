package ClasesSistemas.SubSistemas;

import ClasesBase.Boleto;
import ClasesBase.Persona.Pasajero;

public class SistemaBoleto {
    private SistemaVuelo sistemaVuelo = new SistemaVuelo();

    public SistemaBoleto(SistemaVuelo sistemaVuelo) {
        this.sistemaVuelo = sistemaVuelo;
    }

    public Boleto getBoleto ( int vuelo, int dni) {
        for (int i = 0; i < sistemaVuelo.vueloelegido(vuelo).getBoletos().size(); i++) {
            if (sistemaVuelo.vueloelegido(vuelo).getBoletos().get(i).getPasajero().getDni() == dni) {
                return (sistemaVuelo .vueloelegido(vuelo).getBoletos().get(i));
            }
        }
        return null;
    }

    public void GenerarBoleto(int dni, int Vuelo, int codigo) {
        int indicePasajero=0;
        for (int i=0; i<sistemaVuelo.vueloelegido(Vuelo).getPasajeros().size(); i++) {
            if (sistemaVuelo.vueloelegido(Vuelo).getPasajeros().get(i).getDni() == dni) {
                indicePasajero = i;
                break;
            }
        }
        sistemaVuelo.vueloelegido(Vuelo).getBoletos().add(new Boleto(codigo,sistemaVuelo.vueloelegido(Vuelo).getPasajeros().get(indicePasajero), sistemaVuelo.vueloelegido(Vuelo), false,sistemaVuelo.getSeccionElegida().getPrecio(),sistemaVuelo.getSeccionElegida().getNombre()));
    }

    public void GenerarBoleto(int dni, int vuelo, int codigo,boolean status) {
        Pasajero pasajero = null;
        for (int i = 0; i < sistemaVuelo.vueloelegido(vuelo).getPasajeros().size(); i++) {
            if (sistemaVuelo.vueloelegido(vuelo).getPasajeros().get(i).getDni() == dni) {
                pasajero = sistemaVuelo.vueloelegido(vuelo).getPasajeros().get(i);
                break;
            }
        }
        sistemaVuelo.vueloelegido(vuelo).getBoletos().add(new Boleto(codigo,pasajero, sistemaVuelo.vueloelegido(vuelo), status,sistemaVuelo.getSeccionElegida().getPrecio(),sistemaVuelo.getSeccionElegida().getNombre()));
    }

    public void imprimirBoletos(int vuelo,int dni) {
        for (int i = 0; i < sistemaVuelo.vueloelegido(vuelo-1).getBoletos().size(); i++) { //cambio en vueloelegido(vuelo)
            if (sistemaVuelo.vueloelegido(vuelo-1).getBoletos().get(i).getPasajero().getDni() == dni) { //cambio en vueloelegido(vuelo)
                System.out.println(sistemaVuelo.vueloelegido(vuelo-1).getBoletos().get(i).toString()); //cambio en vueloelegido(vuelo)
            }
        }
    }

    public void estadoBoleto(int vuelo,int dni) {
        for (int i = 0; i < sistemaVuelo.vueloelegido(vuelo-1).getBoletos().size(); i++) { //cambio en vueloelegido(vuelo)
            if (sistemaVuelo.vueloelegido(vuelo-1).getBoletos().get(i).getPasajero().getDni() == dni) { //cambio en vueloelegido(vuelo)
                System.out.println(sistemaVuelo.vueloelegido(vuelo-1).getBoletos().get(i).getEstado_Text()); //cambio en vueloelegido(vuelo)
            }
        }
    }

    public void ListaBoletosVuelo(int vuelo) {
        System.out.printf("""
                    ---------------------------------------
                           LISTA DE BOLETOS VUELO %d
                    ---------------------------------------
                     DNI       CODIGO        ESTADO
                    ---------------------------------------
                    """,vuelo);
        for (int i = 0; i < sistemaVuelo.vueloelegido(vuelo-1).getBoletos().size(); i++) { //cambio en vueloelegido(vuelo)
            System.out.printf("""
                     %-9d %-13d %-14s
                    """,sistemaVuelo.vueloelegido(vuelo-1).getBoletos().get(i).getPasajero().getDni(),sistemaVuelo.vueloelegido(vuelo-1).getBoletos().get(i).getIdBoleto(),sistemaVuelo.vueloelegido(vuelo-1).getBoletos().get(i).getEstado_Text2()); //cambio en vueloelegido(vuelo)
        }
        System.out.print("""
                    ---------------------------------------
                    """);
    }

}

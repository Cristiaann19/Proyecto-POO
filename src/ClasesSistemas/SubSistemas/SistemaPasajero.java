package ClasesSistemas.SubSistemas;

import ClasesBase.Persona.Pasajero;
import ClasesSistemas.Validaciones;
import ClasesSistemas.iCRUDSistemas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class SistemaPasajero implements iCRUDSistemas {
    private final Scanner lector = new Scanner(System.in);
    private static final Random random = new Random();
    private final SistemaVuelo sistemaVuelo ;
    private final SistemaBoleto sistemaBoleto ;
    private int CantidadPasajeros = 0;

    public SistemaPasajero(SistemaVuelo sistemaVuelo, SistemaBoleto sistemaBoleto) {
        this.sistemaVuelo = sistemaVuelo;
        this.sistemaBoleto = sistemaBoleto;
    }

    public void Registrar(int vuelo) {
        int codigo =  random.nextInt(100000000,1000000000);
        System.out.print("""
                ------------------------------------
                        REGISTRAR PASAJERO
                ------------------------------------""");
        if (CantidadPasajeros < sistemaVuelo.getVuelos().get(vuelo).getAvion().getSecciones().get(sistemaVuelo.getIndex_elegido2_seccion()).getCapacidad()) { //cambio en getIndex_elegido2_seccion()-1 otro cambio en (vuelo-1)
            CantidadPasajeros += 1;
            System.out.println();
            int dni = Validaciones.validarDNI(lector);
            System.out.print("Ingrese el Nombre: ");
            String nombre = Validaciones.validar_textos(lector);
            System.out.println("Ingrese Fecha de Nacimiento: ");
            LocalDate fechaNacimiento = Validaciones.validar_fecha_cualquiera(lector, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String email = Validaciones.validar_email(lector);
            int telefono = Validaciones.validar_telefono(lector);
            System.out.print("Ingrese la Nacionalidad: ");
            String nacionalidad = Validaciones.validar_textos(lector);
            Pasajero pasajero = new Pasajero(dni, nombre, fechaNacimiento, email, telefono, nacionalidad);
            sistemaVuelo.vueloelegido(vuelo).getPasajeros().add(pasajero); //Cambio realizado en Vueloelegido(vuelo-1)
            sistemaBoleto.GenerarBoleto(dni,vuelo,(dni+codigo));
            CantidadPasajeros ++;
            System.out.print("""
                    ------------------------------------
                            REGISTRADO CON EXITO
                    ------------------------------------
                    """);
        } else {
            System.out.print("""
                    ------------------------------------
                    NO SE PUEDE REGISTRAR MAS PASAJEROS
                    ------------------------------------
                    """);
        }
    }

    public void Registrar(int Dni, String Nombre, LocalDate FechaNacimiento, String Email, int Telefono, String Nacionalidad, int Vuelo, int seccion, boolean status) {
        Pasajero pasajero = new Pasajero(Dni, Nombre, FechaNacimiento, Email, Telefono, Nacionalidad);
        sistemaVuelo.vueloelegido(Vuelo-1).getPasajeros().add(pasajero);
        sistemaVuelo.setInidice_elegido2_seccion(seccion-1);
        sistemaBoleto.GenerarBoleto(Dni,Vuelo-1,(Dni+random.nextInt(100000000,1000000000)),status);
    }

    public void realizar_pago(int vuelo, int dni) {
        boolean correcto = false;
        for (int i = 0; i < sistemaVuelo.vueloelegido(vuelo).getBoletos().size(); i++) {
            if (sistemaVuelo.vueloelegido(vuelo).getBoletos().get(i).getPasajero().getDni() == dni && !sistemaVuelo.vueloelegido(vuelo).getBoletos().get(i).isEstado()) {
                correcto = true;
                break;
            }
        }
        if (correcto) {
            System.out.print("""
                ------------------------------------------------------------------
                |                        REALIZAR PAGO                           |
                ------------------------------------------------------------------
                """);
            System.out.println(" TOTAL A PAGAR: " + sistemaVuelo.getSeccionElegida().getPrecio());
            System.out.print("""
                ------------------------------------------------------------------
                """);
            System.out.println(" INGRESE [1] PARA PAGAR");
            System.out.println(" INGRESE [2] PARA CANCELAR");
            int opcion = Validaciones.validar_opciones(1, 2);
            if (opcion == 1) {
                System.out.print("""
                        ------------------------------------------------------------------
                        """);
                System.out.println(" PAGADO CON EXITO");
                System.out.println(" GRACIAS POR SU COMPRA");
                System.out.print("""
                        -----------------------------------------------------------------
                        """);
                sistemaBoleto.getBoleto(vuelo, dni).setEstado(true);
            }
            else {
                System.out.print("""
                        ------------------------------------------------------------------
                        """);
                System.out.println(" PAGO CANCELADO");
                System.out.print("""
                        -----------------------------------------------------------------
                        """);
            }
        }else {
            System.out.print("""
                    ------------------------------------------------------------------
                    |                        REALIZAR PAGO                           |
                    ------------------------------------------------------------------
                    | NO SE ENCONTRO EL BOLETO EN EL VUELO SELECCIONADO              |
                    ------------------------------------------------------------------
                    """);
        }

    }

    @Override
    public void Registrar() {}

    @Override
    public void Modificar(int vuelo) {
        System.out.println("Ingrese el DNI del Pasajero a Actualizar: ");
        int dni = Validaciones.validarDNI(lector);
        System.out.println("Ingrese los nuevos Datos: ");
        for (int i = 0; i < sistemaVuelo.getVuelos().get(vuelo-1).getPasajeros().size(); i++) {
            if (sistemaVuelo.getVuelos().get(vuelo-1).getPasajeros().get(i).getDni() == dni) {
                sistemaVuelo.getVuelos().get(vuelo-1).getPasajeros().get(i).setDni(Validaciones.validarDNI(lector));
                System.out.println("Ingrese el Nombre: ");
                sistemaVuelo.getVuelos().get(vuelo-1).getPasajeros().get(i).setNombre(Validaciones.validar_textos(lector));
                System.out.println("Ingrese Fecha de Nacimiento: ");
                sistemaVuelo.getVuelos().get(vuelo-1).getPasajeros().get(i).setFechaNacimiento(Validaciones.validar_fecha_cualquiera(lector, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                sistemaVuelo.getVuelos().get(vuelo-1).getPasajeros().get(i).setEmail(Validaciones.validar_email(lector));
                sistemaVuelo.getVuelos().get(vuelo-1).getPasajeros().get(i).setTelefono(Validaciones.validar_telefono(lector));
                System.out.println("Ingrese la Nacionalidad: ");
                sistemaVuelo.getVuelos().get(vuelo-1).getPasajeros().get(i).setNacionalidad(Validaciones.validar_textos(lector));
                System.out.println("Actualizado con Exito");
                break;
            }
        }
    }

    @Override
    public void Eliminar(int indice) {
        if (sistemaVuelo.getVuelos().isEmpty()) {
            System.out.println("No hay Vuelos Registrados");
        }else {
            if (sistemaVuelo.getVuelos().get(indice - 1).getPasajeros().isEmpty()) {
                System.out.println("No hay Pasajeros Registrados");
            } else {
                int dni = Validaciones.validarDNI(lector);
                boolean encontrado = false;
                for (int i = 0; i < sistemaVuelo.getVuelos().get(indice - 1).getPasajeros().size(); i++) {
                    if (sistemaVuelo.getVuelos().get(indice - 1).getPasajeros().get(i).getDni() == dni) {
                        sistemaVuelo.getVuelos().get(indice - 1).getPasajeros().remove(i);
                        System.out.println("Pasajero Eliminado");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Pasajero no encontrado");
                }
            }
        }
    }

    @Override
    public void Listar() {
        System.out.print("""
                ------------------------------------
                        LISTA DE PASAJEROS
                ------------------------------------
                """);
        for (int i = 0; i < sistemaVuelo.getVuelos().size(); i++) {
            System.out.println("Vuelo: " + (i + 1));
            for (int j = 0; j < sistemaVuelo.getVuelos().get(i).getPasajeros().size(); j++) {
                System.out.println(sistemaVuelo.getVuelos().get(i).getPasajeros().get(j));
            }
        }
    }

}


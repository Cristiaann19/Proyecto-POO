package ClasesSistemas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validaciones {

    private static Scanner lector = new Scanner(System.in);

    public static int validar_opciones(int liminf, int limsup) {
        int opcion = 0;
        boolean valido = false;

        do {
            System.out.print("Ingrese la opción: ");
            String entrada = lector.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Error: la entrada no puede estar vacía.");
                continue;
            }
            try {
                opcion = Integer.parseInt(entrada);
                if (opcion >= liminf && opcion <= limsup) {
                    valido = true;
                } else {
                    System.out.println("Opción incorrecta. Debe estar entre " + liminf + " y " + limsup + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: el valor ingresado no es un número.");
            }
        } while (!valido);

        return opcion;
    }

    public static int validar_Vuelo(int liminf, int limsup) {
        int opcion = 0;
        boolean valido = false;

        do {
            System.out.print("Ingrese el vuelo: ");
            String entrada = lector.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Error: la entrada no puede estar vacía.");
                continue;
            }
            try {
                opcion = Integer.parseInt(entrada);
                if (opcion >= liminf && opcion <= limsup) {
                    valido = true;
                } else {
                    System.out.println("Opción incorrecta. Debe estar entre " + liminf + " y " + limsup + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: el valor ingresado no es un número.");
            }
        } while (!valido);

        return opcion;
    }


    public static int validar_entero(int liminf, int limsup) {
        int num = 0;
        boolean valido = false;

        do {
            String entrada = lector.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: la entrada no puede estar vacía.");
                continue;
            }

            try {
                num = Integer.parseInt(entrada);
                if (num >= liminf && num <= limsup) {
                    valido = true;
                } else {
                    System.out.println("Número incorrecto. Debe estar entre " + liminf + " y " + limsup + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: el valor ingresado no es un número.");
            }
        } while (!valido);

        return num;
    }

    public static LocalDate validar_fecha(Scanner lector, DateTimeFormatter formatter) {
        String fecha = null;
        LocalDate fechaIngresada = null;
        boolean valido = false;

        while (!valido) {
            System.out.print("FECHA (dd/MM/yyyy): ");
            fecha = lector.nextLine().trim();

            if (fecha.isEmpty()) {
                System.out.println("Error: la entrada no puede estar vacía.");
                continue;
            }

            try {
                fechaIngresada = LocalDate.parse(fecha, formatter);
                if (fechaIngresada.isBefore(LocalDate.now())) {
                    System.out.println("La fecha debe ser hoy o en el futuro.");
                } else {
                    valido = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato o fecha no válido. Por favor, intente de nuevo.");
            }
        }

        return fechaIngresada;
    }

    public static LocalDate validar_fecha_cualquiera(Scanner lector, DateTimeFormatter formatter) {
        String fecha = null;
        LocalDate fechaIngresada = null;
        boolean valido = false;

        while (!valido) {
            System.out.print("FECHA (dd/MM/yyyy): ");
            fecha = lector.nextLine().trim();

            if (fecha.isEmpty()) {
                System.out.println("Error: la entrada no puede estar vacía.");
                continue;
            }

            try {
                fechaIngresada = LocalDate.parse(fecha, formatter);
                if (fechaIngresada.isAfter(LocalDate.now())) {
                    System.out.println("La fecha debe ser valida. Por favor, intente de nuevo.");
                } else {
                    valido = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato o fecha no válido. Por favor, intente de nuevo.");
            }
        }

        return fechaIngresada;
    }


    public static int validarDNI(Scanner lector) {
        int dni = 0;
        boolean valido = false;

        do {
            System.out.print("Ingrese el DNI: ");
            String entrada = lector.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: la entrada no puede estar vacía.");
                continue;
            }

            try {
                dni = Integer.parseInt(entrada);
                if (String.valueOf(dni).length() == 8) {
                    valido = true;
                } else {
                    System.out.println("El DNI debe tener 8 dígitos. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: el valor ingresado no es un número.");
            }
        } while (!valido);

        return dni;
    }

    public static String validar_textos(Scanner leer) {
        String text = null;

        do {
            text = leer.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Error: la entrada no puede estar vacía.");
                continue;
            }

            if (text.matches("[A-Z][a-zA-Z]*")) {
                return text;
            } else {
                System.out.println("Formato no válido. Debe comenzar con mayúscula y contener solo letras.");
            }
        } while (true);
    }

    public static String validar_email(Scanner leer) {
        String mail = null;

        do {
            System.out.print("Ingrese email: ");
            mail = leer.nextLine().trim();

            if (mail.isEmpty()) {
                System.out.println("Error: la entrada no puede estar vacía.");
                continue;
            }

            if (mail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                return mail;
            } else {
                System.out.println("Formato de email no válido. Por favor, intente de nuevo.");
            }
        } while (true);
    }

    public static int validar_telefono(Scanner leer) {
        String telf1 = null;
        int telf2;

        do {
            System.out.print("Ingrese teléfono: ");
            telf1 = leer.nextLine().trim();

            if (telf1.isEmpty()) {
                System.out.println("Error: la entrada no puede estar vacía.");
                continue;
            }

            if (telf1.matches("^9\\d{8}$")) {
                telf2 = Integer.parseInt(telf1);
                return telf2;
            } else {
                System.out.println("Formato de número telefónico no válido. Por favor, intente de nuevo.");
            }
        } while (true);
    }
}


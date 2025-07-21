package ClasesSistemas;

public class Menu {
    public static void Menutipo(){
        System.out.printf("""
            
                =======================
                        USUARIO
                =======================
                    1. CLIENTE
                    2. ADMINISTRADOR
                    3. SALIR
                =======================

                """);
    }
    public static void MenuCliente (){
        System.out.printf("""

                =============================
                        JJCA AIRPORT
                =============================
                    1. VUELOS DISPONIBLES
                    2. REGISTRO DE PASAJERO
                    3. BOLETO
                    4. ACTUALIZAR DATOS
                    5. VOLVER
                =============================

                """);
    }
    public static void SubMenuVuelos(){
        System.out.printf("""

            ==============================
                  VUELOS DISPONIBLES
            ==============================
              1. ORIGEN / DESTINO / FECHA
              2. VUELOS DISPONIBLES
              3. VOLVER
            ==============================

            """);
    }

    public static void subMenuBoleto(){
        System.out.printf("""

            =============================
                       BOLETO
            =============================
              1. ESTADO DE BOLETO
              2. PAGAR BOLETO
              3. IMPRIMIR BOLETO
              4. VOLVER
            =============================

            """);
    }

    public static void MenuEncargado(){
        System.out.printf("""

            ============================
                    JJCA AIRPORT
            ============================
              1. GESTIÓN DE VUELOS
              2. GESTIÓN DE BOLETOS
              3. GESTIÓN DE PASAJEROS
              4. REPORTES
              5. VOLVER
            ============================

            """);
    }
    public static void MenuGesVuelos(){
        System.out.printf("""

            =========================
                GESTIÓN DE VUELOS
            =========================
              1. LISTA DE VUELOS
              2. REGISTRAR VUELO
              3. MODIFICAR VUELO
              4. ELIMINAR VUELO
              5. VOLVER
            =========================

            """);
    }
    public static void MenuGesBoletos(){
        System.out.printf("""

            ===================================
                    GESTIÓN DE BOLETOS
            ===================================
              1. LISTA DE BOLETOS
              2. VOLVER
            ===================================
            """);
    }
    public static void MenuGesPasajeros(){
        System.out.printf("""

            =====================================
                    GESTIÓN DE PASAJEROS
            =====================================
              1. ELIMINAR PASAJEROS
              2. VOLVER 
            =====================================
            
            """);
    }

    public static void MenuReportes(){
        System.out.printf("""
            ===========================
                    REPORTES
            ===========================
              1. REPORTES DE VUELOS
              2. REPORTES DE PASAJEROS
              3. REPORTE DE VENTAS
              4. REPORTES DE EMPLEADOS
              5. VOLVER
            ===========================
            """);
    }

    public static void MenuReportesVentas(){
        System.out.printf("""
            ===========================
                    REPORTES
            ===========================
              1. DIA
              2. MES
              3. ANUAL
              4. VOLVER
            ===========================
            """);
    }

    public static void MenuReportesEmpleados(){
        System.out.printf("""
            ===========================
                    REPORTES
            ===========================
              1. ESTADO
              2. ANTIGUEDAD
              3. SALARIO
              4. EDAD
              5. VOLVER
            ===========================
            """);

    }
}

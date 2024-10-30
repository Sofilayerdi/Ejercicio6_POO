import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Reservas> reservas = new ArrayList<>();

        int ingresosEstandar = 0;
        int ingresosEjecutiva = 0;
        int ingresosPresidencial = 0;

        System.out.println("**Bienvenido**");
        System.out.println("1. Agregar reserva");
        System.out.println("2. Mostrar Reservas");
        System.out.println("3. Habitacion que genera mas ingresos");
        System.out.println("4. Salir");
        System.out.println("Elije la opción que desees realizar:");

        int op = scanner.nextInt();
        scanner.nextLine();

        while (op != 4) {

            switch (op) {
                case 1:
                    System.out.println("Porfavor, ingresa los datos que se solicitan para generar tu reserva");
                    System.out.print("Nombre de persona que Reserva: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo de habitacion: (Ejecutiva/Estandar/Presidencial) ");
                    String habitacion = scanner.nextLine();
                    System.out.print("Cantidad de noches a reservar: ");
                    int noches = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el numero de personas: ");
                    int personas = scanner.nextInt();
                    scanner.nextLine();

                    int costoTotal = 0; // Define costoTotal y fecha fuera del switch
                    LocalDate fecha = LocalDate.now();

                    switch (habitacion) {
                        case "Estandar":
                            Habitacion habitacion_estandar = new Habitacion_estandar();
                            costoTotal = habitacion_estandar.calcular_costo(noches, personas);
                            ingresosEstandar += costoTotal;
                            break;
                        case "Ejecutiva":
                            Habitacion habitacion_ejecutiva = new Habitacion_ejecutiva();
                            costoTotal = habitacion_ejecutiva.calcular_costo(noches, personas);
                            ingresosEjecutiva = costoTotal;
                            break;
                        case "Presidencial":
                            Habitacion suite_presidencial = new Suite_presidencial();
                            costoTotal = suite_presidencial.calcular_costo(noches, personas);
                            ingresosPresidencial = costoTotal;
                            break;
                        default:
                            System.out.println("Tipo de habitación no válido.");
                            return;
                    }

                    Reservas nuevaReserva = new Reservas(nombre, habitacion, noches, personas, fecha, costoTotal);
                    nuevaReserva.GuardarReservas(List.of(nuevaReserva));

                    System.out.println("Reserva agregada exitosamente.");

                    break;

                case 2:
                    List<Reservas> reservasLeidas = Reservas.listaReservas();
                    if (reservasLeidas.isEmpty()) {
                        System.out.println("No hay reservas para mostrar.");
                    } else {
                        for (Reservas reserva : reservasLeidas) {
                            System.out.println("Cliente: " + reserva.getNombre() + ", Habitación: "
                                    + reserva.getHabitacion() +
                                    ", Noches: " + reserva.getNoches() + ", Personas: " + reserva.getPersonas() +
                                    ", Fecha: " + reserva.getFecha() + ", Costo Total: $" + reserva.getCostoTotal());
                        }
                    }

                    break;

                case 3:

                    List<Reservas> reservasTotales = Reservas.listaReservas();
                    ingresosEstandar = 0;
                    ingresosEjecutiva = 0;
                    ingresosPresidencial = 0;

                    // Sumar los ingresos según el tipo de habitación
                    for (Reservas reserva : reservasTotales) {
                        switch (reserva.getHabitacion()) {
                            case "Estandar":
                                ingresosEstandar += reserva.getCostoTotal();
                                break;
                            case "Ejecutiva":
                                ingresosEjecutiva += reserva.getCostoTotal();
                                break;
                            case "Presidencial":
                                ingresosPresidencial += reserva.getCostoTotal();
                                break;
                        }
                    }

                    if (ingresosEstandar > ingresosEjecutiva && ingresosEstandar > ingresosPresidencial) {
                        System.out.println("La habitación Estandar generó más ingresos: $" + ingresosEstandar);
                    } else if (ingresosEjecutiva > ingresosEstandar && ingresosEjecutiva > ingresosPresidencial) {
                        System.out.println("La habitación Ejecutiva generó más ingresos: $" + ingresosEjecutiva);
                    } else if (ingresosPresidencial > ingresosEstandar && ingresosPresidencial > ingresosEjecutiva) {
                        System.out.println("La habitación Presidencial generó más ingresos: $" + ingresosPresidencial);
                    } else {
                        System.out.println("Las habitaciones generaron ingresos iguales.");
                    }

                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println(
                            "Opción no valida, porfavor ingresa el numero correspondiente a la opción que deseas ejecutar");
                    break;

            }
            System.out.println("**Bienvenido**");
            System.out.println("1. Agregar reserva");
            System.out.println("2. Mostrar Reservas");
            System.out.println("3. Habitacion que genera mas ingresos");
            System.out.println("4. Salir");
            System.out.println("Elije la opción que desees realizar:");

            op = scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
    }
}
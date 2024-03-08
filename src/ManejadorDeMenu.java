import java.util.Scanner;

public class ManejadorDeMenu {
    public static void presentarOpcionesGenerales() {
        Scanner opcion = new Scanner(System.in);
        int opc = 0;
        while (opc != 3) {
            System.out.println("Ingrese una opción:\n" +
                    "1.Crear proyecto\n" +
                    "2.Abrir proyecto\n" +
                    "3.Salir");
            try {
                opc = Integer.parseInt(opcion.nextLine());

                switch (opc) {
                    case 1:
                        ManejadorDeProyecto.crearProyecto();
                        break;
                    case 2:
                        ManejadorDeProyecto.cargarProyecto();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        System.out.println("------------------------------------------");
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido");
                System.out.println("------------------------------------------");
            }
        }
    }

    public static void presentarOpcionesEspecificas(ManejadorDeProyecto manejadorDeProyecto) {
        manejadorDeProyecto.proyecto.manejadorDeTareas.imprimirTareas();

        Scanner opcion = new Scanner(System.in);
        int opc = 0;
        while (opc != 4) {
            System.out.println("Ingrese una opción:\n" +
                    "1.Agregar tarea\n" +
                    "2.Editar proyecto\n" +
                    "3.Volver a menú principal\n" +
                    "4.Salir"
            );
            opc = Integer.parseInt(opcion.nextLine());
            try {
                switch (opc) {
                    case 1:
                        manejadorDeProyecto.agregarTareas();
                        break;
                    case 2:
                        manejadorDeProyecto.editarProyecto();
                        break;
                    case 3:
                        presentarOpcionesGenerales();
                        return;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Opcion invalida");
                        System.out.println("------------------------------------------");
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido");
                System.out.println("------------------------------------------");
            }
        }

    }
}

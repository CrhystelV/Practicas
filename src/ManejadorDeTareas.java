import java.util.ArrayList;
import java.util.Scanner;

public class ManejadorDeTareas {
    public ArrayList<Tarea> tareas = new ArrayList<>();

    public void agregarTareas() {
        while (!agregarTarea());
    }

    public boolean agregarTarea(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Ingreso tarea (para salir s): ");
        String ingresoUsuario = scanner.nextLine();

        if(ingresoUsuario.equals("s")){
            return true;
        }

        tareas.add(new Tarea(ingresoUsuario, getEstado(), ManejadorDePersonas.obtenerPersona()));
        return false;
    }

    public void editarTareas() {
        Tarea tarea = obtenerTarea();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Descripción de la tarea: " + tarea.descripcionTarea + "\n"
        + "Estado de la tarea: " + getEstadoParaImprimir(tarea.estado) + "\n"
        + "Encargado: " + tarea.encargado.nombre + "\n"
        + "Cargo: " + tarea.encargado.cargos + "\n");

        int opc = 0;
        while(opc < 1 || opc > 3) {
            System.out.println(""" 
                    ¿Qué desea modificar?
                    1. Descripción
                    2. Estado
                    3. Encargado""");

            try {
                opc = Integer.parseInt(scanner.nextLine());

                switch (opc) {
                    case 1:
                        System.out.println("Descripción de la tarea: ");
                        tarea.descripcionTarea = scanner.nextLine();
                        break;
                    case 2:
                        tarea.estado = getEstado();
                        break;
                    case 3:
                        tarea.encargado = ManejadorDePersonas.obtenerPersona();
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es correcto.");
            }
        }
    }

    private Tarea obtenerTarea(){
        Scanner scanner = new Scanner(System.in);

        while(true) {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i).descripcionTarea);
            }

            try {
                int opc = Integer.parseInt(scanner.nextLine());

                if (opc < 1 || opc > tareas.size()) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                return tareas.get(opc - 1);
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private TiposDeEstado getEstado() {
        int opc;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    Ingrese el estado de la tarea:
                    1. Pendiente
                    2. En progreso
                    3. Finalizado""");

            try {
                opc = Integer.parseInt(scanner.nextLine());

                switch (opc) {
                    case 1:
                        return TiposDeEstado.PENDIENTE;
                    case 2:
                        return TiposDeEstado.EN_PROCESO;
                    case 3:
                        return TiposDeEstado.FINALIZADO;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Valor ingresado incorrecto.");
            }
        }
    }

    private String getEstadoParaImprimir(TiposDeEstado estado) {
        return switch (estado) {
            case PENDIENTE -> "Pendiente";
            case EN_PROCESO -> "En proceso";
            case FINALIZADO -> "Finalizado";
        };
    }

    public void modificarEstado(){

    }

    public void parseTarea(String descripcion, String estado, String encargado, String cargo) {
        tareas.add(new Tarea(descripcion, parseEstado(estado), new Persona(encargado, cargo)));
    }

    private TiposDeEstado parseEstado(String estado) {
        return TiposDeEstado.valueOf(estado);
    }
}

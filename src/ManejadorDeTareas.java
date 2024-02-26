import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ManejadorDeTareas {
    public ArrayList<Tarea> tareas = new ArrayList<>();

    private boolean ingresoTerminado = false;

    public boolean getIngresoTerminado() {
        return ingresoTerminado;
    }

    public void agregarTarea(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Ingreso tarea (para salir s): ");
        String ingresoUsuario = scanner.nextLine();

        if(ingresoUsuario.equals("s")){
            ingresoTerminado = true;
            return;
        }

        tareas.add(new Tarea(ingresoUsuario, getEstado()));
    }

    public void mostrarTareas(){
        try(FileReader fr = new FileReader("tareas.txt")){
            BufferedReader br = new BufferedReader(fr);
            String contenido;
            while ((contenido = br.readLine()) != null){
                System.out.println(contenido);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private TiposDeEstado getEstado() {
        int opc = 0;
        Scanner scanner = new Scanner(System.in);

        while(opc != TiposDeEstado.values().length + 1) {
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

        return TiposDeEstado.PENDIENTE;
    }

    public void modificarEstado(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("INgres algo");
        listaTareas.add(scanner.nextLine());
        System.out.println(listaTareas);
    }
}

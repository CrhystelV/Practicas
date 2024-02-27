import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Scanner opcion = new Scanner(System.in);
        int opc = 0;

        System.out.println("Ingrese una opción:\n" +
                "1.Crear proyecto\n" +
                "2.Abrir proyecto\n" +
                "3.Ingresar tarea\n" +
                "4.Estado tareas\n" +
                "5.Editar tareas");
        opc= Integer.parseInt(opcion.nextLine());
        switch(opc){
            case 1:
                ManejadorDePersonas manejadorDePersonas = new ManejadorDePersonas();
                manejadorDePersonas.obtenerPersona();

                break;
            case 2:

                break;
            case 3:

                ManejadorDeProyectos manejadorDeProyectos = new ManejadorDeProyectos();
                manejadorDeProyectos.guardarTareas();
                break;
            case 4:



                break;
            case 5:
                ManejadorDeProyectos manejadorDeProyectos1 = new ManejadorDeProyectos();
                manejadorDeProyectos1.editarTareas();
                break;
            default:

                break;
        }

    }
}
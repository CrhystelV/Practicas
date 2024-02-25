import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Scanner opcion = new Scanner(System.in);
        int opc = 0;

        System.out.println("Ingrese una opción:\n" +
                "1.Crear proyecto\n" +
                "2.Abrir proyecto" +
                "3.Ingresar tarea\n" +
                "4.Estado tareas\n" +
                "5.Cambiar estado de tareas");
        opc= Integer.parseInt(opcion.nextLine());
        switch(opc){
            case 1:
                Archivos archivo = new Archivos();
                archivo.crearProyecto();
                break;
            case 2:

                break;
            case 3:
                Archivos archivos = new Archivos();
                archivos.crearTareas();
                break;
            case 4:
                Archivos archi = new Archivos();
                archi.mostrarTareas();


                break;
            case 5:
                Archivos ar = new Archivos();
                ar.crearTareas();
                ar.modificarEstado();
                break;
            default:

                break;
        }

    }
}
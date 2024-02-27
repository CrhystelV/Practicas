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
                "5.Cambiar estado de tareas");
        opc= Integer.parseInt(opcion.nextLine());
        switch(opc){
            case 1:
                ManejadorDePersonas manejadorDePersonas = new ManejadorDePersonas();
                manejadorDePersonas.agregarPersona();

                break;
            case 2:

                break;
            case 3:

                ManejoDeArchivos manejoDeArchivos = new ManejoDeArchivos();
                manejoDeArchivos.escrituraDeArchivos();
                break;
            case 4:



                break;
            case 5:

                break;
            default:

                break;
        }

    }
}
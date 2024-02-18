import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Scanner opcion = new Scanner(System.in);
        int opc = 0;
        System.out.println("Ingrese una opción:\n" +
                "1.Crear proyecto\n" +
                "2.Ingresar tarea\n" +
                "3.Estado tareas\n" +
                "4. Cambiar estado de tareas");
        opc= Integer.parseInt(opcion.nextLine());
        switch(opc){
            case 1:
                Archivos archivo = new Archivos();
                archivo.creacionArchivo();


                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:

                break;
        }

    }
}
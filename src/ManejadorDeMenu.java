import java.util.Scanner;

public class ManejadorDeMenu {
    public void presentarOpcionesGenerales() {

        Scanner opcion = new Scanner(System.in);
        int opc = 0;

            System.out.println("Ingrese una opción:\n" +
                    "1.Crear proyecto\n" +
                    "2.Abrir proyecto\n" );
        opc= Integer.parseInt(opcion.nextLine());
            switch(opc){
            case 1:
                ManejadorDeProyecto manejadorDeProyecto = new ManejadorDeProyecto();
                manejadorDeProyecto.crearProyecto();

                break;
            case 2:
                ManejoDeArchivos manejoDeArchivos = new ManejoDeArchivos();
                manejoDeArchivos.mostrarArchivosEnCarpeta();

                break;
            default:

                break;
        }

    }
    public void presentarOpcionesEspecificas() {
        Scanner opcion = new Scanner(System.in);
        int opc = 0;

        System.out.println("Ingrese una opción:\n" +
                "1.Ingresar tarea\n" +
                "2.Estado tareas\n" +
                "3.Cambiar estado de tareas");
        opc= Integer.parseInt(opcion.nextLine());
        switch(opc){
            case 1:
                /*ManejoDeArchivos manejoDeArchivos = new ManejoDeArchivos();
                manejoDeArchivos.escrituraDeArchivos();*/
                break;
            case 2:
                ManejadorDePersonas manejoDePersonas = new ManejadorDePersonas();
                manejoDePersonas.obtenerPersona();
                break;
            case 3:
                break;
            default:
                break;
        }

    }
}

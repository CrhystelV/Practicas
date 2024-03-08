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
                manejoDeArchivos.abrirYSeleccionar();


                break;
            default:

                break;
        }

    }
    public void presentarOpcionesEspecificas() {
        Scanner opcion = new Scanner(System.in);
        int opc ;

        System.out.println("Ingrese una opción a modificar:\n" +
                "1.Ingresar tarea\n" +
                "2.Editar tareas\n" +
                "3.Cambiar estado de tareas\n" +
                        "4. Salir");
        opc= Integer.parseInt(opcion.nextLine());
        switch(opc){
            case 1:

                ManejadorDeProyectos manejadorDeProyectos = new ManejadorDeProyectos();
                manejadorDeProyectos.guardarTareas();

                break;
            case 2:

                break;
            case 3:
                break;
            default:
                break;
        }

    }
}

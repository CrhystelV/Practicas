import java.util.Scanner;

public class ManejadorDeMenu {
    ManejoDeArchivos manejadorArchivos = new ManejoDeArchivos();


    public ManejadorDeMenu() {
    }

    public ManejadorDeMenu(ManejoDeArchivos manejoDeArchivos) {
        this.manejadorArchivos = manejoDeArchivos;
    }

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
                "3.Salir"
                        );
        opc= Integer.parseInt(opcion.nextLine());
        switch(opc){
            case 1:
                ManejadorDeProyectos manejadorDeProyectos = new ManejadorDeProyectos(manejadorArchivos,this);
                manejadorDeProyectos.guardarYAgregarTareas();

                break;
            case 2:
                ManejadorDeProyectos manejadorDeProyectos1 = new ManejadorDeProyectos(manejadorArchivos,this);
                manejadorDeProyectos1.leerProyecto();

                break;
            case 3:
                break;
            default:
                break;
        }

    }
}

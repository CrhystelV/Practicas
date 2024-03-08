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


        while(opc!=3){
            System.out.println("Ingrese una opción:\n" +
                    "1.Crear proyecto\n" +
                    "2.Abrir proyecto\n" +
                    "3.Salir" );
            opc= Integer.parseInt(opcion.nextLine());
            try{

                switch(opc){
                    case 1:
                        ManejadorDeProyecto manejadorDeProyecto = new ManejadorDeProyecto();
                        manejadorDeProyecto.crearProyecto();
                        break;
                    case 2:
                        ManejoDeArchivos manejoDeArchivos = new ManejoDeArchivos();
                        manejoDeArchivos.abrirYSeleccionar();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        System.out.println("------------------------------------------");
                        continue;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Valor invalido");
                System.out.println("------------------------------------------");
                continue;
            }

        }



    }
    public void presentarOpcionesEspecificas() {
        Scanner opcion = new Scanner(System.in);
        int opc=0 ;
        while(opc!=4) {
            System.out.println("Ingrese una opción a modificar:\n" +
                    "1.Agregar tarea\n" +
                    "2.Editar tareas\n" +
                    "3.Volver a menú principal\n" +
                    "4.Salir"
            );
            opc = Integer.parseInt(opcion.nextLine());
            try {
                switch (opc) {
                    case 1:
                        ManejadorDeProyectos manejadorDeProyectos = new ManejadorDeProyectos(manejadorArchivos, this);
                        manejadorDeProyectos.guardarYAgregarTareas();

                        break;
                    case 2:
                        ManejadorDeProyectos manejadorDeProyectos1 = new ManejadorDeProyectos(manejadorArchivos, this);
                        manejadorDeProyectos1.leerProyecto();
                        break;
                    case 3:
                        presentarOpcionesGenerales();
                        return;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Opcion invalida");
                        System.out.println("------------------------------------------");
                        continue;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Valor invalido");
                System.out.println("------------------------------------------");
                continue;
            }
        }

    }
}

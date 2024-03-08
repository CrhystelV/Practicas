import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class ManejoDeArchivos {
    public String ruta;
    ManejadorDeProyecto manejador = new ManejadorDeProyecto();
    public File[] listado;

    public ManejoDeArchivos() {
    }
    public ManejoDeArchivos(ManejadorDeProyecto manejadorDeProyecto) {
        this.manejador = manejadorDeProyecto;

    }

    public void escrituraDeArchivos(){
        ManejadorDeTareas manejadorDeTareas = new ManejadorDeTareas();
        manejadorDeTareas.agregarTareas();
        try(FileWriter archivo = new FileWriter(manejador.rutaParaCarpeta + "TAREAS.txt", true)){
            PrintWriter bw = new PrintWriter(archivo);
            for(int i = 0; i < manejadorDeTareas.tareas.size(); i++){
                Tarea tarea = manejadorDeTareas.tareas.get(i);
                bw.write("TAREA " + (i + 1) + ":\n" +
                        "Descripción tarea: " + tarea.descripcionTarea + "\n"
                        + "Estado: " + tarea.estado + "\n"
                        + "Encargado: " + tarea.encargado.nombre + "\n" +
                        "Cargo: " + tarea.encargado.cargos + "\n");

            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void mostrarArchivosEnCarpeta() {
        ManejadorDeProyecto manejadorDeProyecto = new ManejadorDeProyecto();
        File carpeta = new File(manejadorDeProyecto.puntoGuardado);
        listado = carpeta.listFiles();

        if(listado == null ||listado.length == 0) {
            System.out.println("No hay nada en la carpeta");
            return;
        }
        else {
            System.out.println("------------------------------------------");
            for (int i =0; i< listado.length; i++) {
                System.out.println(i+1 + ". "+ listado[i].getName());
            }
        }

    }
    public void abrirArchivosEnCarpeta() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Escoga el proyecto que desea abrir: ");
            try{
                int opc = Integer.parseInt(scanner.nextLine());
                if (opc<1 || opc> listado.length ){
                    System.out.println("Opcion invalida");
                    System.out.println("------------------------------------------");
                    continue;
                }
                System.out.println("------------------------------------------");
                File carpetaSeleccionada = listado[opc-1];
                File archivoDeTareas = new File(carpetaSeleccionada, "TAREAS.txt");
                try{
                    String contenido = Files.readString(archivoDeTareas.toPath());
                    ruta= archivoDeTareas.getAbsolutePath();
                    System.out.println(contenido);
                } catch (IOException e){
                    e.printStackTrace();
                }
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Opcion invalida");
                System.out.println("------------------------------------------");
                continue;
            }


        }


    }
    public void abrirYSeleccionar() {
        ManejadorDeMenu manejadorDeMenu = new ManejadorDeMenu(this);
        mostrarArchivosEnCarpeta();
        abrirArchivosEnCarpeta();
        System.out.println("------------------------------------------\n");
        manejadorDeMenu.presentarOpcionesEspecificas();


    }



}

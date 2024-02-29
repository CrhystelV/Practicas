import java.io.*;

public class ManejoDeArchivos {
    public String puntoGuardado = "C:/Users/Usuario/IdeaProjects/Vaina/Proyecto";
    public void escrituraDeArchivos(){
        ManejadorDeTareas manejadorDeTareas = new ManejadorDeTareas();
        ManejadorDeProyecto manejadorDeProyecto = new ManejadorDeProyecto();
        manejadorDeTareas.agregarTareas();

        try(FileWriter archivo = new FileWriter(manejadorDeProyecto.rutaParaCarpeta + "TAREAS DE PROYECTO.txt", false)){
            PrintWriter bw = new PrintWriter(archivo);

            for(int i = 0; i < manejadorDeTareas.tareas.size(); i++){
                Tarea tarea = manejadorDeTareas.tareas.get(i);
                bw.write("Tarea " + (i + 1) + ":\n" +
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
        String[] listado = carpeta.list();
        if(listado == null ||listado.length == 0) {
            System.out.println("No hya nada en la carpeta");
            return;
        }
        else {
            for (String s : listado) {
                System.out.println(s);
            }
        }
    }
    public void abrirArchivos() {

    }

}

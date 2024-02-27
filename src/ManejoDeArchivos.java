import java.io.*;
import java.util.regex.Pattern;

public class ManejoDeArchivos {
    public void escrituraDeArchivos(){
        ManejadorDeTareas manejadorDeTareas = new ManejadorDeTareas();
        manejadorDeTareas.agregarTareas();

        try(FileWriter archivo = new FileWriter("INFORMACION DE PROYECTO.txt", false)){
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

    public void leerArchivo() {
        Pattern pattern = Pattern.compile("Tarea \\d:\n");
    }
}

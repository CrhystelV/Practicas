import java.io.*;

public class ManejoDeArchivos {
    public void escrituraDeArchivos(){
        ManejadorDeTareas manejadorDeTareas = new ManejadorDeTareas();
        ManejoDePersonas manejoDePersonas = new ManejoDePersonas();
        manejadorDeTareas.agregarTarea();
        manejoDePersonas.agregarPersona();
        try(FileWriter archivo = new FileWriter("INFORMACION DE PROYECTO.txt", true)){
            PrintWriter bw = new PrintWriter(archivo);
            for( Tarea tarea :  manejadorDeTareas.tareas){
                for (Persona persona : manejoDePersonas.persona){
                    bw.write("Tarea: " + manejadorDeTareas.tareas + "\n"
                            + "Encargado: " + manejoDePersonas.persona+ "\n" );
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}

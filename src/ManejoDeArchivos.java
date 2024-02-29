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

}

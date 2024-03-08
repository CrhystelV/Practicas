import java.io.*;

public class ManejadorDeProyectos {
    //todo agregar instancia de proyecto

    private final ManejadorDeTareas manejadorDeTareas = new ManejadorDeTareas();
    ManejoDeArchivos manejoDeArchivos = new ManejoDeArchivos();
    public ManejadorDeProyectos() {

    }
    public ManejadorDeProyectos(ManejoDeArchivos manejador){
        this.manejoDeArchivos = manejador;

    }

    /*private void leerProyecto() {
        leerTareas();
    }

    private void leerTareas() {

        try {
            FileReader fileReader = new FileReader("TAREAS.txt");
            BufferedReader buffer = new BufferedReader(fileReader);

            while (buffer.readLine() != null) {
                String descripcion = buffer.readLine().replace("Descripción tarea: ", "");
                String estado = buffer.readLine().replace("Estado: ", "");
                String encargado = buffer.readLine().replace("Encargado: ", "");
                String cargo = buffer.readLine().replace("Cargo: ", "");

                manejadorDeTareas.parseTarea(descripcion, estado, encargado, cargo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void guardarTareas(){
        manejadorDeTareas.agregarTareas();
        try(FileWriter archivo = new FileWriter(manejoDeArchivos.ruta, true)){
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

    /*public void editarTareas() {
        manejadorDeTareas.editarTareas();
    }*/
}

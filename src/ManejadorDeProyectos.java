import java.io.*;

public class ManejadorDeProyectos {

    private final ManejadorDeTareas manejadorDeTareas = new ManejadorDeTareas();
    ManejoDeArchivos manejoDeArchivos = new ManejoDeArchivos();
    ManejadorDeMenu manejador = new ManejadorDeMenu();
    public ManejadorDeProyectos(ManejoDeArchivos manejoDeArchivos1, ManejadorDeMenu manejadorMenu){
        this.manejoDeArchivos = manejoDeArchivos1;
        this.manejador = manejadorMenu;

    }
    public void leerProyecto() {
        leerTareas();
        manejadorDeTareas.editarTareas();
        guardarTarea();

    }
    private void leerTareas() {

        try {
            FileReader fileReader = new FileReader(manejoDeArchivos.ruta);
            BufferedReader buffer = new BufferedReader(fileReader);

            while (buffer.readLine() != null) {
                String descripcion = buffer.readLine().replace("Descripción tarea: ", "");
                String estado = buffer.readLine().replace("Estado: ", "");
                String encargado = buffer.readLine().replace("Responsable: ", "");
                String cargo = buffer.readLine().replace("Cargo: ", "");

                manejadorDeTareas.parseTarea(descripcion, estado, encargado, cargo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarYAgregarTareas(){
        manejadorDeTareas.agregarTareas();
        guardarTarea();
    }
    public void guardarTarea() {
        try(FileWriter archivo = new FileWriter(manejoDeArchivos.ruta, false)){
            PrintWriter bw = new PrintWriter(archivo);

            for(int i = 0; i < manejadorDeTareas.tareas.size(); i++){
                Tarea tarea = manejadorDeTareas.tareas.get(i);
                bw.write("TAREA " + (i + 1) + ":\n" +
                        "Descripción tarea: " + tarea.descripcionTarea + "\n"
                        + "Estado: " + tarea.estado + "\n"
                        + "Responsable: " + tarea.encargado.nombre + "\n" +
                        "Cargo: " + tarea.encargado.cargos + "\n");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}

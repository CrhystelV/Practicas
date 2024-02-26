import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivos {
    private ArrayList<Persona> listaEncargados = new ArrayList<>();
    public ArrayList<ArrayList> listaInformacion = new ArrayList<>();
    public String puntoGuardado = "C://Vaina//Proyectos";

    public void crearProyecto() {
        crearCarpeta();

        Proyecto proyecto = new Proyecto();
        Persona personas = new Persona();
        proyecto.pedirNombre();

        this.listaEncargados.add(personas.getNombre() + " , " + personas.getCargos() + "\n");
        this.puntoGuardado += "//" + proyecto.getNombre() + ".txt";
        try (FileWriter archivo = new FileWriter(puntoGuardado, true)){
            PrintWriter pw = new PrintWriter(archivo);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        File carpeta = new File(puntoGuardado);
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
    public void crearTareas(){
        ManejadorDeTareas manejadorDeTareas = new ManejadorDeTareas();

        Persona personas = new Persona();
        int contador = 0;
        do {
            manejadorDeTareas.agregarTarea();
            if("s".equals(tareas.tarea)){
                tareas.confirmacion= false;
                break;
            }
            personas.agregarPersona();
            this.listaTareas.add("PENDIENTE: " + tareas.getTareas());
            this.listaEncargados.add(", ENCARGADO: " + personas.getNombre() + " , " + personas.getCargos());
        }while (tareas.confirmacion == true);
        try (FileWriter archivo = new FileWriter("TAREAS.TXT", true)){
            PrintWriter pw = new PrintWriter(archivo);
            for(Tarea tarea : manejadorDeTareas.tareas){
                for (Persona persona : listaEncargados){
                    contador++;
                    pw.println((contador) + "."+ contenidoIn +contenido);

                    JSON
                }

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void crearCarpeta() {
        String[] subcarpetas = puntoGuardado.split("//");
        String rutaTemporal = subcarpetas[0];

//        for (int i = 1; i < subcarpetas.length; i++) {
//            File carpeta = new File(rutaTemporal + "//" + subcarpetas[i]);
//            if (!carpeta.exists()) {
//                if (carpeta.mkdirs()) {
//                    System.out.println("Holi");
//                }
//                else {
//                    System.out.println("Chai");
//                }
//            }
//            rutaTemporal += "//" + subcarpetas[i];
//        }

        Path path = Paths.get(puntoGuardado);

        try {
            if(!Files.exists(path)){
                Files.createDirectories(path.toAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Quihubo parce, tenemos un error: " + e);
        }
    }
}

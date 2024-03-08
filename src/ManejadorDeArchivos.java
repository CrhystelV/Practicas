import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ManejadorDeArchivos {
    public static final String ruta = "C:/Vaina/Proyectos/";

    private static String getRuta(String nombreProyecto) {
        return ruta + nombreProyecto + "/";
    }

    public static void escrituraDeArchivos(Proyecto proyecto) {
        try (FileWriter archivoTareas = new FileWriter(getRuta(proyecto.getNombre()) + "TAREAS.txt", false)) {
            PrintWriter bw = new PrintWriter(archivoTareas);
            for (int i = 0; i < proyecto.manejadorDeTareas.tareas.size(); i++) {
                Tarea tarea = proyecto.manejadorDeTareas.tareas.get(i);
                bw.write("TAREA " + (i + 1) + ":\n" +
                        "Descripción tarea: " + tarea.descripcionTarea + "\n"
                        + "Estado: " + tarea.estado + "\n"
                        + "Responsable: " + tarea.encargado.nombre + "\n" +
                        "Cargo: " + tarea.encargado.cargos + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter archivoEncargado = new FileWriter(getRuta(proyecto.getNombre()) + "ENCARGADO.txt", false)) {
            PrintWriter bw = new PrintWriter(archivoEncargado);
            bw.write("ENCARGADO DEL PROYECTO: " + proyecto.getPersonaEncargada());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Proyecto mostrarArchivosEnCarpeta() {
        File carpeta = new File(ruta);
        File[] listado = carpeta.listFiles();

        if (listado == null || listado.length == 0) {
            System.out.println("No hay nada en la carpeta");
        } else {
            System.out.println("------------------------------------------");
            for (int i = 0; i < listado.length; i++) {
                System.out.println(i + 1 + ". " + listado[i].getName());
            }
        }

        return abrirProyecto(listado);
    }

    public static Proyecto abrirProyecto(File[] listado) {
        Scanner scanner = new Scanner(System.in);
        File carpetaSeleccionada;

        while (true) {
            System.out.println("Escoga el proyecto que desea abrir: ");
            try {
                int opc = Integer.parseInt(scanner.nextLine());
                if (opc < 1 || opc > listado.length) {
                    System.out.println("Opcion invalida");
                    System.out.println("------------------------------------------");
                    continue;
                }
                System.out.println("------------------------------------------");
                carpetaSeleccionada = listado[opc - 1];
                break;
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
                System.out.println("------------------------------------------");
            }
        }

        return new Proyecto(carpetaSeleccionada.getName(), getEncargado(carpetaSeleccionada.getName()), getTareas(carpetaSeleccionada.getName()));
    }

    public static void abrirYSeleccionar(ManejadorDeProyecto manejadorDeProyecto) {

        manejadorDeProyecto.proyecto = mostrarArchivosEnCarpeta();

        System.out.println("------------------------------------------\n");
        ManejadorDeMenu.presentarOpcionesEspecificas(manejadorDeProyecto);
    }

    public static void crearCarpeta() {
        String[] subcarpetas = ruta.split("/");
        String rutaTemporal = subcarpetas[0];

        for (int i = 1; i < subcarpetas.length; i++) {
            File carpeta = new File(rutaTemporal + "/" + subcarpetas[i]);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }
            rutaTemporal += "//" + subcarpetas[i];
        }

        Path path = Paths.get(ruta);
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path.toAbsolutePath());

            }
        } catch (IOException e) {
            System.out.println("Quihubo parce, tenemos un error: " + e);
        }
    }

    public static Proyecto crearProyecto() {
        crearCarpeta();

        Proyecto proyecto = new Proyecto();
        proyecto.manejadorDeTareas = new ManejadorDeTareas();

        while (true) {
            proyecto.pedirNombreDeProyecto();
            try  {
                File archivo = new File(getRuta(proyecto.getNombre()));
                if (!archivo.exists()){
                    if(archivo.mkdirs()){
                        break;
                    }
                }
                else {
                    System.out.println("El archivo ya existe");
                    System.out.println("------------------------------------------");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        proyecto.pedirEncargado();

        ManejadorDeArchivos.escrituraDeArchivos(proyecto);
        return proyecto;
    }

    public static ManejadorDeTareas getTareas(String nombreProyecto) {
        ManejadorDeTareas manejadorDeTareas = new ManejadorDeTareas();
        try {
            FileReader fileReader = new FileReader(getRuta(nombreProyecto) + "/TAREAS.txt");
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
        return manejadorDeTareas;
    }

    public static String getEncargado(String nombreProyecto) {
        String encargado = "";
        try {
            FileReader fileReader = new FileReader(getRuta(nombreProyecto) + "/ENCARGADO.txt");
            BufferedReader buffer = new BufferedReader(fileReader);

            encargado = buffer.readLine().replace("ENCARGADO DEL PROYECTO: ", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encargado;
    }
}

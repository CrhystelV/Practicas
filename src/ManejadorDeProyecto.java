import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class ManejadorDeProyecto {
    public String puntoGuardado = "C:/Users/Usuario/IdeaProjects/Vaina/Proyecto/";

    public void crearProyecto() {
        crearCarpeta();
        Proyecto proyectos = new Proyecto();
        proyectos.pedirNombre();
        String rutaParaCarpeta = puntoGuardado + proyectos.getNombre() + ".txt";
        try  {
            File archivo = new File(rutaParaCarpeta);
            if (archivo.createNewFile()){
                System.out.println("Archivo creado con exito");
            }else{
                System.out.println("El archivo ya existe");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void crearCarpeta() {
        String[] subcarpetas = puntoGuardado.split("//");
        String rutaTemporal = subcarpetas[0];

        for (int i = 1; i < subcarpetas.length; i++) {
            File carpeta = new File(rutaTemporal + "//" + subcarpetas[i]);
            if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {
                    System.out.println("Holi");
                } else {
                    System.out.println("Chai");
                }
            }
            rutaTemporal += "//" + subcarpetas[i];

        }

        Path path = Paths.get(puntoGuardado);
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path.toAbsolutePath());

            }
        } catch (IOException e) {
            System.out.println("Quihubo parce, tenemos un error: " + e);
        }

    }
}

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class ManejadorDeProyecto {
    public String puntoGuardado = "C:/Users/Usuario/IdeaProjects/Vaina/Proyecto/";
    public String rutaParaCarpeta;

    public void crearProyecto() {
        ManejoDeArchivos manejoDeArchivos = new ManejoDeArchivos(this);
        crearCarpeta();
        Proyecto proyectos = new Proyecto();
        proyectos.pedirNombreDeProyecto();
        rutaParaCarpeta = puntoGuardado + proyectos.getNombre() + "/"  ;
        try  {
            File archivo = new File(rutaParaCarpeta);
            if (!archivo.exists()){
                if(archivo.mkdirs()){
                    System.out.println();

                }

            }else{
                System.out.println("El archivo ya existe");
                System.out.println("------------------------------------------");
                return;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        manejoDeArchivos.escrituraDeArchivos();


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

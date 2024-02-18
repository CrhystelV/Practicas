import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivos {

    Proyecto proyecto = new Proyecto();
    InfoPersonas personas = new InfoPersonas();

    public void creaArchivo(){
        proyecto.soloNombreProyecto();
        personas.agregarPersona();

        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            File archivo = new File(proyecto.getNombreProyecto()+ ".txt");
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            fw = new FileWriter(archivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(personas.getNombres() + " , " + personas.getCargos() + "\n");
            System.out.println("Info agregada correctamente");
        }
        catch (Exception e){
            System.out.println("ERROR AL ESCRIBIR  ARCHIVO");
        }
        finally {
            try{
                if(bw != null)
                    bw.close();
                if(fw != null)
                    fw.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }
}

import java.io.*;
import java.util.ArrayList;

public class Archivos {
    public ArrayList<String> listaEncargados = new ArrayList<>();

    public ArrayList<String> getListaEncargados() {
        return listaEncargados;
    }

    public void setListaEncargados(ArrayList<String> listaEncargados) {
        this.listaEncargados = listaEncargados;
    }

    public void crearArchivo(){
        Proyecto proyecto = new Proyecto();
        InfoPersonas personas = new InfoPersonas();
        proyecto.soloNombreProyecto();
        personas.agregarPersona();
        this.listaEncargados.add(personas.getNombres() + " , " +personas.getCargos() + "\n");


        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            File archivo = new File(proyecto.getNombreProyecto()+ ".txt");
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            fw = new FileWriter(archivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            for (String encargado : listaEncargados){
                bw.write(encargado);
            }


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
    public void designarPersona(){
        Tarea tareas = new Tarea();
        InfoPersonas personas = new InfoPersonas();
        System.out.println("Seleccione el proyecto:\n");
        tareas.agregarTarea();
        System.out.println("Personas dentro del proyecto: \n");
        FileReader fre = null;
        BufferedReader bre = null;
        try{
            fre = new FileReader()
        }
    }
}

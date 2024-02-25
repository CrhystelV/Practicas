import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivos {
    public ArrayList<String> listaEncargados = new ArrayList<>();
    public ArrayList<String> listaTareas = new ArrayList<>();
    public String puntoGuardado;

    public ArrayList<String> getListaEncargados() {
        return listaEncargados;
    }

    public void setListaEncargados(ArrayList<String> listaEncargados) {
        this.listaEncargados = listaEncargados;
    }

    public void crearProyecto(){
        Proyecto proyecto = new Proyecto();
        InfoPersonas personas = new InfoPersonas();
        proyecto.soloNombreProyecto();
        personas.agregarPersona();
        File carpeta = new File("C://Users//Usuario//IdeaProjects//Vaina//Proyectos.txt");
        if(!carpeta.exists()){
            if(carpeta.mkdirs()){
                System.out.println("Proyecto creado correctamente");
            }else {
                System.out.println("error");
            }
        }

        this.listaEncargados.add(personas.getNombres() + " , " +personas.getCargos() + "\n");
        puntoGuardado = ("C://Users//Usuario//IdeaProjects//Vaina//Proyectos.txt//" + proyecto.getNombreProyecto() + ".txt");
        try (FileWriter archivo = new FileWriter(puntoGuardado)){
            PrintWriter pw = new PrintWriter(archivo);

            for( String encargado : listaEncargados){
                pw.println(encargado);
            }
            pw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String[] listado = carpeta.list();
        if(listado== null ||listado.length ==0){
            System.out.println("No hya nada en la carpeta");
            return;
        }
        else{
            for(int i = 0; i<listado.length; i++){
                System.out.println(listado[i]);
            }
        }
    }

    public void crearTareas(){
        Tarea tareas = new Tarea();
        InfoPersonas personas = new InfoPersonas();
        int contador = 0;
        do {
            tareas.agregarTarea();
            if("s".equals(tareas.tarea)){
                tareas.confirmacion= false;
            }
            this.listaTareas.add(tareas.getTareas());

        }while (tareas.confirmacion == true);
        try (FileWriter archivo = new FileWriter("tareas.txt", true)){
            PrintWriter pw = new PrintWriter(archivo);
            listaTareas.remove("s");
            for( String contenidoIn : listaTareas){
                contador++;
                pw.println((contador) + "."+ "PENDIENTE: " + contenidoIn);
            }
            pw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void mostrarTareas(){
        try(FileReader fr = new FileReader("tareas.txt")){
            BufferedReader br = new BufferedReader(fr);
            String contenido;
            while ((contenido = br.readLine()) != null){
                System.out.println(contenido);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void modificarEstado(){



    }

}

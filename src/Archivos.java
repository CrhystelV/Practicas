import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivos {
    private ArrayList<String> listaEncargados = new ArrayList<>();
    private ArrayList<String> listaTareas = new ArrayList<>();
    public ArrayList<ArrayList> listaInformacion = new ArrayList<>();
    public String puntoGuardado = "C://Users//Usuario//IdeaProjects//Vaina//Proyectos.txt";

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
        File carpeta = new File(puntoGuardado);
        if(!carpeta.exists()){
            if(carpeta.mkdirs()){
                System.out.println("Proyecto creado correctamente");
            }else {
                System.out.println("error");
            }
        }

        this.listaEncargados.add(personas.getNombres() + " , " +personas.getCargos() + "\n");
        this.puntoGuardado=("C://Users//Usuario//IdeaProjects//Vaina//Proyectos.txt//" + proyecto.getNombreProyecto() + ".txt" );
        try (FileWriter archivo = new FileWriter(puntoGuardado, true)){
            PrintWriter pw = new PrintWriter(archivo);
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
        Proyecto proyecto = new Proyecto();
        InfoPersonas personas = new InfoPersonas();
        int contador = 0;
        do {
            tareas.agregarTarea();
            if("s".equals(tareas.tarea)){
                tareas.confirmacion= false;
                break;
            }
            personas.agregarPersona();
            this.listaTareas.add("PENDIENTE: " + tareas.getTareas());
            this.listaEncargados.add(", ENCARGADO: " + personas.getNombres() + " , " + personas.getCargos());
        }while (tareas.confirmacion == true);
        try (FileWriter archivo = new FileWriter("TAREAS.TXT", true)){
            PrintWriter pw = new PrintWriter(archivo);
            listaTareas.remove("s");
            listaEncargados.remove("s");
            for( String contenidoIn : listaTareas){
                for (String contenido : listaEncargados){
                    contador++;
                    pw.println((contador) + "."+ contenidoIn +contenido);
                }

            }

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("INgres algo");
        listaTareas.add(scanner.nextLine());
        System.out.println(listaTareas);



    }

}

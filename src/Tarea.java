import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea {
    public String asignaciones;
    public ArrayList <String>listatareas = new ArrayList<>();

    public String getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(String asignaciones) {
        this.asignaciones = asignaciones;
    }

    public ArrayList<String> getListatareas() {
        return listatareas;
    }

    public void setListatareas(ArrayList<String> listatareas) {
        this.listatareas = listatareas;
    }

    public Tarea() {
        this.asignaciones = asignaciones;
        this.listatareas = listatareas;
        this.persona = persona;
    }
    Persona persona = new Persona();
    public void creartareas(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese tareas:");
        listatareas.add(scanner.nextLine());
        persona.datospersona();
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            File archivo = new File("Lista de tareas.txt");
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            fw = new FileWriter(archivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            for (String elemento : listatareas ){
                bw.write(elemento + " , "+ persona.listanombres + "\n");
            }
            System.out.println("Información agregada exitosamente");
        }
        catch (Exception e){
            System.out.println("ERROR AL ESCRIBIR EN ARCHIVO");
        }
        finally {
            try {
                if(bw != null)
                    bw.close();
                if (fw !=null)
                    fw.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }


}

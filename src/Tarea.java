import java.util.Scanner;

public class Tarea{
    public String tarea;
    boolean confirmacion;

    public Tarea() {

    }

    public String getTareas() {
        return tarea;
    }

    public void setTareas(String tareas) {
        this.tarea = tareas;
    }

    public void agregarTarea(){
        Scanner scanner = new Scanner (System.in);
        confirmacion = true;
        System.out.println("Ingreso tarea (para salir ingrese s): ");
        tarea = scanner.nextLine();
        /*if("s".equals(tarea)){
            confirmacion= false;
        }*/

    }

}
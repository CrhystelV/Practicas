import java.util.Scanner;

public class Tarea{
    public String tareas;

    public Tarea() {

    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public void agregarTarea(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Ingreso tarea: ");
        tareas = scanner.nextLine();
    }

}
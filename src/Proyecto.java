import java.util.Scanner;

public class Proyecto {
    String nombreProyecto;

    public Proyecto() {

    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
    public void soloNombreProyecto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del proyecto: ");
        nombreProyecto = scanner.nextLine();
    }
}
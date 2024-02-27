import java.util.Scanner;

//todo implementar esto, y ponerle un encargado
public class Proyecto {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void pedirNombre(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del proyecto: ");
        nombre = scanner.nextLine();
    }
}
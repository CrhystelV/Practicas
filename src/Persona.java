import java.util.Scanner;

public class Persona {
    public String nombre;

    public String cargos;

    public void agregarPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre responsable: ");
        nombre = scanner.nextLine();
        System.out.println("Cargo: ");
        cargos = scanner.nextLine();
    }
}

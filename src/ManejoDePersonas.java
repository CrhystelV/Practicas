import java.util.ArrayList;
import java.util.Scanner;

public class ManejoDePersonas {
    public ArrayList<Persona> persona = new ArrayList<>();
    public void agregarPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre responsable: ");
        String nombre = scanner.nextLine();
        System.out.println("Cargo: ");
        String cargos = scanner.nextLine();
        persona.add(new Persona(nombre, cargos));
        System.out.println();
    }
}

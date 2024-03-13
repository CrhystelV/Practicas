import java.util.Scanner;

public class ManejadorDePersonas {
    public static Persona obtenerPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre responsable: ");
        String nombre = scanner.nextLine();
        System.out.println("Cargo: ");
        String cargos = scanner.nextLine();
        System.out.println();
        return new Persona(nombre, cargos);
    }


}

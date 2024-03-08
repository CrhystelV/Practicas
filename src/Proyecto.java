import java.util.Scanner;

public class Proyecto {
    private String nombre;
    private String personaEncargada;
    public ManejadorDeTareas manejadorDeTareas;

    public Proyecto() {
    }

    public Proyecto(String nombre, String personaEncargada, ManejadorDeTareas manejadorDeTareas) {
        this.nombre = nombre;
        this.personaEncargada = personaEncargada;
        this.manejadorDeTareas = manejadorDeTareas;
    }

    public String getPersonaEncargada() {
        return personaEncargada;
    }

    public String getNombre() {
        return nombre;
    }

    public void pedirNombreDeProyecto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del proyecto: ");
        nombre = scanner.nextLine();
    }

    public void pedirEncargado(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Encargado del proyecto: ");
        personaEncargada = scanner.nextLine();
    }
}
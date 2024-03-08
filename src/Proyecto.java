import java.util.Scanner;

public class Proyecto {
    private String nombre;
    private String personaEncargada;

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


}
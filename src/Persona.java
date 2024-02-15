import java.util.ArrayList;
import java.util.Scanner;

public class Persona  {
    public ArrayList<String> listanombres = new ArrayList<>();

    public ArrayList<String> getListanombres() {
        return listanombres;
    }

    public void setListanombres(ArrayList<String> listanombres) {
        this.listanombres = listanombres;
    }

    public Persona(ArrayList<String> listanombres) {
        this.listanombres = listanombres;
    }

    public Persona() {
    }

    public void datospersona(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Ingrese el nombre de la persona encargada de realizar la tarea:");
        listanombres.add(scanner.nextLine());
    }

}


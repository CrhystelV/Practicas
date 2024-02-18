import java.util.ArrayList;
import java.util.Scanner;

public class InfoPersonas {
    public String nombres ;
    public String cargos ;


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }

    public InfoPersonas() {

    }
    public void agregarPersona(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre responsable: ");
        nombres = scanner.nextLine();
        System.out.println("Cargo : ");
        cargos= scanner.nextLine();



    }
}

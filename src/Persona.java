import java.util.Scanner;

public class Persona {
    private String nombre;

    private String cargos;

    public String getNombre() {
        return nombre;
    }

    public String getCargos() {
        return cargos;
    }

    public Persona(String nombre, String cargos) {
        this.nombre = nombre;
        this.cargos = cargos;
    }
}
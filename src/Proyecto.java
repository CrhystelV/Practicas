import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto {
    private ArrayList<Persona> personas;

    String nombrearchivo;

    public String getNombrearchivo() {
        return nombrearchivo;
    }

    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }

    public Proyecto() {
    }

    public void nombreproyecto(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Nombre del proyecto: ");
        this.nombrearchivo=scanner.nextLine();
    }

    public void creacionarchivo(){
        nombreproyecto();
        personas.datosPersona();
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            File archivo = new File(this.nombrearchivo + ".txt");
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            fw = new FileWriter(archivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            for (Persona persona : personas ){
                bw.write(persona.getDatosPersona() + "\n");

            }
            System.out.println("Información agregada exitosamente");
        }
        catch (Exception e){
            System.out.println("ERROR AL ESCRIBIR EN ARCHIVO");
        }
        finally {
            try {
                if(bw != null)
                    bw.close();
                if (fw !=null)
                    fw.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }

    public void crearPersona() {
        Scanner scanner = new Scanner (System.in);
        Persona persona = new Persona();

        System.out.println("Nombre:");
        persona.nombre = scanner.nextLine();

        System.out.println("Edad:");
        persona.edad = Integer.parseInt(scanner.nextLine());

        System.out.println("Puesto de trabajo:");
        persona.puestoTrabajo = scanner.nextLine();

        personas.add(persona);
    }

    public Persona getPersonaACargo() {

    }
}


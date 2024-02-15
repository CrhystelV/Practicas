import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreacionProyecto extends Persona {
    String nombrearchivo;
    public String getNombrearchivo() {
        return nombrearchivo;
    }

    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }

    public CreacionProyecto(ArrayList<String> listanombres, String nombrearchivo) {
        super(listanombres);
        this.nombrearchivo = nombrearchivo;

    }
    public CreacionProyecto() {
    }
    public void nombreproyecto(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Nombre del proyecto: ");
        this.nombrearchivo=scanner.nextLine();
    }
    public void creacionarchivo(){
        nombreproyecto();
        super.datospersona();
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            File archivo = new File(this.nombrearchivo + ".txt");
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            fw = new FileWriter(archivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            for (String elemento : listanombres ){
                bw.write(elemento + "\n");

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

}


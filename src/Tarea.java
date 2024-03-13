public class Tarea {
    public String descripcionTarea;

    public TiposDeEstado estado;

    public Persona encargado;

    public Tarea(String tarea, TiposDeEstado estado, Persona encargado) {
        this.descripcionTarea = tarea;
        this.estado = estado;
        this.encargado = encargado;
    }
}
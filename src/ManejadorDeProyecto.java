public class ManejadorDeProyecto {
    public Proyecto proyecto;

    public static void crearProyecto() {
        ManejadorDeProyecto manejadorDeProyecto = new ManejadorDeProyecto();
        manejadorDeProyecto.proyecto = ManejadorDeArchivos.crearProyecto();
        ManejadorDeMenu.presentarOpcionesEspecificas(manejadorDeProyecto);
    }

    public static void cargarProyecto() {
        ManejadorDeProyecto manejadorDeProyecto = new ManejadorDeProyecto();
        ManejadorDeArchivos.abrirYSeleccionar(manejadorDeProyecto);
    }

    public void agregarTareas() {
        proyecto.manejadorDeTareas.agregarTareas(proyecto);
    }

    public void editarProyecto() {
        proyecto.manejadorDeTareas.editarTareas(proyecto);
    }
}

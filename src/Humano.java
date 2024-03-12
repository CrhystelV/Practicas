public class Humano implements IMovimiento, IAnios {

    @Override
    public void comoSeMueve() {
        System.out.println("Se meueve de a dos patas");
    }

    @Override
    public void tiempoExistencia() {
        System.out.println("No se");
    }
}

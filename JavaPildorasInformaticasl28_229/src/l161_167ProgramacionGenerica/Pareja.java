package l161_167ProgramacionGenerica;

public class Pareja<T> {
    private T primero;

    public Pareja(){
        primero = null;
    }


    public T getPrimero() {
        return primero;
    }

    public void setPrimero(T primero) {
        this.primero = primero;
    }

}

package l161_167ProgramacionGenerica;

public class NewArrayList {
    private Object[] datosElementos;
    private int i=0;

    public NewArrayList(int z){
        datosElementos = new Object[z];
    }

    public Object get(int i){
        return datosElementos[i];
    }

    public void add(Object o){
        datosElementos[i]=o;
        i++;

    }
}

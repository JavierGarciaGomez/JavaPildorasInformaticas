package l168_178Threads.l178;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        /*
        For para instanciar la clase ejecucion transferencias, que hace transferencias infinitas
         de cada cuenta a una cuenta destino random y por una cantidad random
         */
        for(int i=0;i<100;i++){
            EjecucionTransferencias ejecucionTransferencias=new EjecucionTransferencias(banco, i, 2000);
            Thread thread = new Thread(ejecucionTransferencias);
            thread.start();
        }
    }
}

class Banco{
    private final double[] cuentas;
    //private Lock cierre = new ReentrantLock();
    //private Condition saldoSuficiente;

    public Banco(){
        cuentas= new double[100];
        for(int i=0;i<cuentas.length;i++){
            cuentas[i]=2000;
        }

        // condición de bloqueo
        // saldoSuficiente=cierre.newCondition();
    }

    // SYNCHRONIZED
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
        // instancia de ReentrantLock para usar el método lock que bloquea el código a otros hilos
        //cierre.lock();
        //try{
            // mientras esta condición ocurre: espera.
            while(cuentas[cuentaOrigen]<cantidad){
                // método wait de synchronized
                wait();

                //saldoSuficiente.await();
                System.out.println("----------CANTIDAD INSUFICIENTE DE:"+cuentaOrigen+"PARA HACER LA TRANSF DE"+cantidad+"SALDO DE"+cuentas[cuentaOrigen]);
            }
            // Si no está dormido, notifica a los demás hilos.
            System.out.println(Thread.currentThread()); // imprime el hilo que hace la transferencia
            cuentas[cuentaOrigen]-=cantidad;
            System.out.printf("%10.2f de %d para %d ", cantidad, cuentaOrigen, cuentaDestino);
            cuentas[cuentaDestino]+=cantidad;
            System.out.printf("Saldo total: %10.2fn", getSaldoTotal());

            //saldoSuficiente.signalAll();
            //método notifyAll de syncronized
        notifyAll();

        //} finally {
            //cierre.unlock();
        //}




    }

    public double getSaldoTotal(){
        double suma=0;
        for(double c:cuentas){
            suma+=c;
        }
        return suma;
    }
}

class EjecucionTransferencias implements Runnable{
    private Banco banco;
    private int cuenta;
    private double cantidadMax;

    public EjecucionTransferencias(Banco banco, int cuenta, double cantidadMax) {
        this.banco = banco;
        this.cuenta = cuenta;
        this.cantidadMax = cantidadMax;
    }

    @Override
    public void run() {
        try{
            while(true){
                int cuentaDestino=(int)(100*Math.random());
                double cantidad=cantidadMax*Math.random();
                banco.transferencia(cuenta, cuentaDestino, cantidad);
                Thread.sleep((int)(Math.random()*10));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
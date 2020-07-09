package l168_178Threads.l171;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HilosVarios hilosVarios=new HilosVarios();
        HilosVarios2 hilosVarios2=new HilosVarios2(hilosVarios);
        hilosVarios2.start();
        hilosVarios.start();

        System.out.println("Ya acabé");

    }
}

class HilosVarios extends Thread{

    @Override
    public void run() {
        for(int i=0;i<15;i++){
            System.out.println("Ejecutando hilo"+getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Clase que contempla el método join
class HilosVarios2 extends Thread{
    private Thread thread;
    public HilosVarios2(Thread thread){
        this.thread=thread;

    }
    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<15;i++){
            System.out.println("Ejecutando hilo"+getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
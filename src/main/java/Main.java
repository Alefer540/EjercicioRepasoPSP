import java.util.concurrent.Semaphore;

public class Main {
    private static final int NUM_ACCESO_SIMULTANEOS = 10;
    public static void main (String[]args){
        Semaphore semaforo1 = new Semaphore(NUM_ACCESO_SIMULTANEOS,true);

        //creamos a los 20 huespedes
        for (int i=1;i<=20;i++){
            Huespedes h= new Huespedes(i);
            h.start();
        }

    }
}

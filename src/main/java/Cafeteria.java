import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cafeteria {

        private static final int NUM_ACCESO_SIMULTANEOS = 10;
        static Semaphore semaforo1 = new Semaphore(NUM_ACCESO_SIMULTANEOS,true);
        static Semaphore semaforo2 = new Semaphore(4,true);


    static void quiereentrar(Huespedes huespedes){
        System.out.println("el cliente " + huespedes.nomhuesped+ " SE QUIERE SENTAR");

        try {
            semaforo1.acquire(1);
            sentarse(huespedes);
            semaforo1.release(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void sentarse(Huespedes huespedes){
        System.out.println("el cliente " + huespedes.nomhuesped+ " SE SIENTA");
        try{
            semaforo2.acquire(1);
            cogercafe(huespedes);
            semaforo2.release(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void cogercafe(Huespedes huespedes){
        System.out.println(("El cliente "+huespedes.nomhuesped+ " RECOGE SU TAZA"));
        tomarcafe(huespedes);



    }
    private static void tomarcafe(Huespedes huespedes){
        System.out.println("El cliente "+ huespedes.nomhuesped+" COMIENZA SU CAFE");
        try {
            Thread.sleep((new Random().nextInt(5)  + 3)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

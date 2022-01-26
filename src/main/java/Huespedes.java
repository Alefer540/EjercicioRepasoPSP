

class Huespedes extends Thread {
    boolean termina_cafe = true;
    int nomhuesped;
    Huespedes(int nomhuesped) {
        this.nomhuesped = nomhuesped;
    }




    @Override
    public void run() {
        Cafeteria.quiereentrar(this);

    }
}

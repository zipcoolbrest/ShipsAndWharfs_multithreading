public class Ship implements Runnable {

    private int cargo;
    private int place; //номер пристани
    private Dock dock;



    public Ship(Dock dock) {
        super();
        this.dock = dock;
        this.cargo = 10;
        this.place = -1;
    }

    @Override
    public void run() {
        //спрашиваем есть ли свободная пристань, и если есть швартуемся
        place = dock.getPlace();

        //разгружаем трюмы
        while (cargo != 0){
            dock.setWarehouse(place, dock.getWarehouse(place) + 1);
            cargo-=1;
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //отчаливаем от дока и говорим, что он свободен
        dock.setPlace(place, true);
        place = -1;
    }
}

public class Dock {
    private Wharf [] wharves;
    private int numberOfWharf;


    public Dock(){
        this.numberOfWharf = -1;
        wharves = new Wharf[2]; //количество пристаней в одном доке
        for (int i = 0; i < wharves.length ; i++) {
            wharves[i] = new Wharf();
        }
    }

    //проходим по всем пристаням и ищем свободную
    public synchronized int getPlace(){
        for (int i = 0; i < wharves.length; i++) {
            if (wharves[i].isEmpty()) {
                numberOfWharf = i;
                setPlace(i, false); //занимаем свободную пристань и передаем ее номер кораблю
                System.out.println("wharf-" + i + " is busy" );
                return numberOfWharf;
            }
        }
        //свободных пристаней нет, всем ждать
        //ждать будут до тех пор пока корабль не разгрузиться и не запустит метод setPlace
        try{
            wait();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //ВОПРОС В ТОМ, СКОЛЬКО КОРАБЛЕЙ СМОГУТ ОЖИДАТЬ СВОЕЙ ОЧЕРЕДИ ПРИ ТАКОМ ПОДХОДЕ.
        return this.getPlace();
    }

    public synchronized void setPlace(int numberOfWharf, boolean empty ){
        wharves[numberOfWharf].setEmpty(empty);
        //когда пристань освобождается говорим другим кораблям, что она свободна
        if(empty) {
            notifyAll();
            System.out.println("ship all done! wharf-"+numberOfWharf);
        }
    }

    public int getWarehouse(int numberOfWharf){
        return wharves[numberOfWharf].getWarehouse();
    }

    public void setWarehouse(int numberOfWharf, int value){
        wharves[numberOfWharf].setWarehouse(value);
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Thread [] threads = new Thread[5];
        Dock dock = new Dock();
        for (int i = 0; i < threads.length ; i++) {
            threads[i] = new Thread(new Ship(dock));
        }
        for (Thread thread: threads) {
            thread.start();
        }
    }

    //написать коментарии ко всему коду
}

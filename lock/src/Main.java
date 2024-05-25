import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Counter{
    int count;
    private Lock lock = new ReentrantLock();
    public void increament(){
        try{
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }
}

class Thread1 extends Thread{
    Counter cc;
    public Thread1(Counter c){
        cc = c;
    }
    public void run(){
        for(int i = 0; i < 1000; i++){
            cc.increament();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter cc = new Counter();
        Thread1 t1 = new Thread1(cc);
        Thread1 t2 = new Thread1(cc);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(cc.count);

    }
}
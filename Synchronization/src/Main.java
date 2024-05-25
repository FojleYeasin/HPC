
class Counter{
    int count;
    public synchronized void  increament(){
        count++;
    }
}

class Thread1 extends Thread{
    Counter cc;
    public Thread1(Counter c){
        cc = c;
    }
    public void run(){
        for(int i = 1; i <= 1000; i++){
            cc.increament();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Counter cc = new Counter();
        Thread1 t1 = new Thread1(cc);
        Thread1 t2 = new Thread1(cc);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(cc.count);
    }
}
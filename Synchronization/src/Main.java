
class Counter{
    int count;
    public void increament(){
        count++;
    }
}

class Thread1 extends Thread{
    public void run(){

    }
}

public class Main {
    public static void main(String[] args) {
        Counter cc = new Counter();
        cc.increament();
        System.out.println(cc.count);
    }
}
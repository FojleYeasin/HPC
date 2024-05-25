public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread T1 = new Thread1(11);
        T1.start();
        Thread T2 = new Thread1(22);
        T2.start();
        Thread T3 = new Thread1(33);
        T3.start();
        for(int i = 1; i <= 10; i++){
            System.out.println(1);
            Thread.sleep(500);
        }
    }
}

class Thread1 extends Thread{
    int val;
    public Thread1(int x){
        val = x;
    }
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.println(val);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
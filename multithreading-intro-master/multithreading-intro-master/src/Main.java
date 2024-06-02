//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello and welcome!");

        System.out.printf("Initializing banking system..");

        int totalNumberOfSimulaion = 10;
        OperationsQueue operationsQueue = new OperationsQueue();
        Bank bank = new Bank("123", operationsQueue);

        System.out.println("Initializing simulation....");
        Thread simulationThread = new Thread(() -> {
            operationsQueue.addSimulation(totalNumberOfSimulaion);
        });
        simulationThread.start();
        simulationThread.join();

        System.out.printf("Initializing deposit systen....");
        Thread depositThread = new Thread(() -> {
            bank.deposit();
        });

        System.out.println("coompleted");
        System.out.printf("Initializing withdraw systen....");
        Thread withdrawThread = new Thread(() -> {
            bank.withdraw();
        });
        depositThread.start();
        withdrawThread.start();
        depositThread.join();
        withdrawThread.join();
        System.out.println("coompleted");


        System.out.println("coompleted");

    }
}
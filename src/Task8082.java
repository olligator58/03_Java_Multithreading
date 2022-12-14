import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
ShutdownNow!
*/

public class Task8082 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }

        List<Runnable> tasks = executor.shutdownNow();
        for (Runnable task : tasks) {
            System.out.println(String.format("%s was not completed", task));
        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}

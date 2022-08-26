package Task90150;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        if (tablets != null && tablets.size() > 0) {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int randomIndex = (int) (Math.random() * tablets.size());
                    tablets.get(randomIndex).createTestOrder();
                    Thread.sleep(interval);
                }
            } catch (InterruptedException ignored) {
            }
        }
    }
}
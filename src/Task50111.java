/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/

public class Task50111 {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new YieldRunnable(5));
        t.start();
    }
}

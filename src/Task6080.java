/*
Вежливость - это искусственно созданное хорошее настроение
*/

public class Task6080 {

    public static class IntegerHolder {
        private int value;

        public synchronized int get() {
            return value;
        }

        public synchronized void set(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        IntegerHolder ih = new IntegerHolder();
        ih.set(10);
        System.out.println(ih.get());
    }
}

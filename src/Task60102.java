import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Весь мир играет комедию
*/

public class Task60102 {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        if (!lock.tryLock()) {
            actionIfLockIsBusy();
        } else {
            try {
                actionIfLockIsFree();
            } finally {
                lock.unlock();
            }
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}

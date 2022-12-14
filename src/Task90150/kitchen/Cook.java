package Task90150.kitchen;

import Task90150.ConsoleHelper;
import Task90150.statistic.StatisticManager;
import Task90150.statistic.event.CookedOrderEventDataRow;
import Task90150.statistic.event.EventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue queue;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        int delay = order.getTotalCookingTime() * 10;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignore) {
        }
        EventDataRow event = new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticManager.getInstance().register(event);
        setChanged();
        notifyObservers(order);
        busy = false;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!queue.isEmpty() && !busy) {
                    startCookingOrder((Order) queue.take());
                }
                Thread.sleep(10);
            }
        } catch (InterruptedException ignore) {
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

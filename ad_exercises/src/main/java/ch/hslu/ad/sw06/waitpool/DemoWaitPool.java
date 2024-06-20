package ch.hslu.ad.sw06.waitpool;

public final class DemoWaitPool {
    private static final Object LOCK = new Object();

    public static void main(final String[] args) throws InterruptedException {
        final MyTask waiter = new MyTask(LOCK);
        new Thread(waiter).start();
        Thread.sleep(1000);
        // muss bei beiden Orten synchronisiert werden
        synchronized (LOCK) {
            // best practice
            LOCK.notifyAll();
        }
    }
}
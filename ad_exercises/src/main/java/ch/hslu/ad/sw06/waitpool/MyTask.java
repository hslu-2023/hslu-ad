package ch.hslu.ad.sw06.waitpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MyTask implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(MyTask.class);
    private final Object lock;

    public MyTask(final Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        LOG.info("warten...");
        synchronized (lock) {
            try {
                // Wenn Lock synchronisiert wird, muss auch Lock warten und nicht die Class.
                lock.wait();
            } catch (InterruptedException ex) {
                return;
            }
        }
        LOG.info("...aufgewacht");
    }
}

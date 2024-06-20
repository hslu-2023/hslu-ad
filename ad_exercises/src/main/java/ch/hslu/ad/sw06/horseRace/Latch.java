package ch.hslu.ad.sw06.horseRace;

public class Latch implements Sync {
    private boolean isReleased = false;

    @Override
    public void acquire() throws InterruptedException {
        synchronized (this) {
            while (!isReleased) {
                this.wait();
            }
        }
    }

    @Override
    public void release() {
        synchronized (this) {
            isReleased = true;
            this.notifyAll();
        }
    }
}
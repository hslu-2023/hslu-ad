package ch.hslu.ad.sw06.signal;

public class Semaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, 5);

        try {
            semaphore.acquire(3);
            System.out.println("Acquired 2 permits. Available permits: " + semaphore.getAvailablePermits());
            semaphore.release(1);
            System.out.println("Released 1 permit. Available permits: " + semaphore.getAvailablePermits());
            semaphore.acquire(1);
            System.out.println("Acquired 1 permit. Available permits: " + semaphore.getAvailablePermits());
            semaphore.release(3);
            System.out.println("Released 3 permits. Available permits: " + semaphore.getAvailablePermits());
        } catch (InterruptedException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private int sema;
    private int limit;

    public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
        if (permits < 0 || limit < 1 || permits > limit)
            throw new IllegalArgumentException("Ungültige Argumente: permits und limit müssen positiv sein und permits darf nicht groesser als limit sein.");
        this.sema = permits;
        this.limit = limit;
    }

    public synchronized void acquire() throws InterruptedException {
        this.acquire(1);
    }

    public synchronized void acquire(final int permits) throws InterruptedException {
        if (permits <= 0) {
            throw new IllegalArgumentException("Permits müssen positiv sein.");
        }
        while (sema < permits) {
            this.wait();
        }
        sema -= permits;
    }


    public synchronized void release() {
       this.release(1);
    }

    public synchronized void release(final int permits) {
        if (permits <= 0) {
            throw new IllegalArgumentException("Permits müssen positiv sein.");
        }
        if (sema + permits > limit) {
            throw new IllegalArgumentException("Permits überschreiten das Limit.");
        }
        sema += permits;
        this.notifyAll();
    }

    public int getAvailablePermits() {
        return sema;
    }
}

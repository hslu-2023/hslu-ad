package ch.hslu.ad.sw11.fibonacci;

import java.util.concurrent.RecursiveTask;

public final class FibonacciTask extends RecursiveTask<Long> {

    private final long n;

    /**
     * Erzeugt einen Fibonacci Task.
     *
     * @param n für die Fibonacci Berechnung.
     */
    public FibonacciTask(final long n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) return n;
        final var f1 = new FibonacciTask(n - 1);
        final var f2 = new FibonacciTask(n - 2);
        f1.fork();
        return f2.compute() + f1.join();
    }
}

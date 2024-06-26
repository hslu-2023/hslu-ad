package ch.hslu.ad.sw08.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoBankAccount {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBankAccount.class);

    public static void main(String[] args) {
        final ArrayList<BankAccount> from = new ArrayList<>();
        final ArrayList<BankAccount> to = new ArrayList<>();
        final int threads = Runtime.getRuntime().availableProcessors() + 1;
        final int amount = 100_000;
        final int number = 10;

        final long start = System.nanoTime();

        for (int i = 0; i < number; i++) {
            from.add(new BankAccount(amount));
            to.add(new BankAccount());
        }

        // Account Tasks starten...
        final ArrayList<Callable<Boolean>> tasks = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            tasks.add(new AccountTask(from.get(i), to.get(i), amount));
        }

        try (final ExecutorService executorService = Executors.newFixedThreadPool(threads)) {
            executorService.invokeAll(tasks);
        } catch (RuntimeException | InterruptedException e) {
            LOG.error(e.getMessage(), e);
        }

        LOG.info("Bank accounts after transfers");
        for (int i = 0; i < number; i++) {
            LOG.info("source({}) = {}; target({}) = {};", i, from.get(i).getBalance(), i, to.get(i).getBalance());
        }

        final long end = System.nanoTime();
        LOG.info("Duration: %d ms".formatted((end - start) / 1_000_000));
    }


}

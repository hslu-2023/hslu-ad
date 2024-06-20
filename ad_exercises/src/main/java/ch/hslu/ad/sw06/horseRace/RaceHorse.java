package ch.hslu.ad.sw06.horseRace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class RaceHorse implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(RaceHorse.class);
    private final Sync startSignal;
    private final String name;
    private final Random random;

    /**
     * Erzeugt ein Rennpferd, das in die Starterbox eintritt.
     */
    public RaceHorse(final Sync startSignal, final String name) {
        this.startSignal = startSignal;
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void run() {
        LOG.info("Rennpferd {} geht in die Box.", name);
        try {
            startSignal.acquire();
            LOG.info("Rennpferd {} laeuft los...", name);
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException ex) {
            LOG.debug(String.valueOf(ex));
        }
        LOG.info("Rennpferd {} ist im Ziel.", name);
    }
}

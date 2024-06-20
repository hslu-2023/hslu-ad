package ch.hslu.ad.sw06.horseRace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Turf {
    private static final Logger LOG = LoggerFactory.getLogger(Turf.class);

    public static void main(final String[] args) throws InterruptedException {
        Sync starterBox = new Latch();
        for (int i = 1; i <= 5; i++) {
            Thread.ofVirtual().start(new RaceHorse(starterBox, "Horse " + i));
            //new Thread(new RaceHorse(starterBox, "Horse " + i)).start();
        }
        LOG.info("Start...");
        starterBox.release();
        Thread.sleep(4000);
    }
}

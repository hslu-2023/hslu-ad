package ch.hslu.ad.sw11.findFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import java.util.function.BiConsumer;

public class Demo {

    private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final var search = "find_file_test.txt";
        final var rootDir = new File(System.getProperty("user.home"));

        LOG.info("Start searching '{}' recursive in '{}'", search, rootDir);
        final var measuredRecursive = measure(FindFile::findFile, search, rootDir);
        LOG.info("Found in {} ns", measuredRecursive);

        LOG.info("Find '{}' concurrent in '{}'", search, rootDir);
        final var measuredConcurrent = measure(Demo::findFileConcurrent, search, rootDir);
        LOG.info("Found in {} ns", measuredConcurrent);
    }

    private static void findFileConcurrent(String search, File rootDir) {
        final var root = new FindFileTask(search, rootDir);
        LOG.info(root.invoke());
    }

    private static long measure(BiConsumer<String, File> function, String search, File rootDir) {
        final var start = System.nanoTime();
        function.accept(search, rootDir);
        final var stop = System.nanoTime();
        return (stop - start) / 1_000_000;
    }
}

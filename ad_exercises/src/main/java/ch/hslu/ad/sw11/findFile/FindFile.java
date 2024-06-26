package ch.hslu.ad.sw11.findFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public final class FindFile {

    private static final Logger LOG = LoggerFactory.getLogger(FindFile.class);

    /**
     * Sucht ein File in einem Verzeichnis.
     *
     * @param name Name des Files.
     * @param dir  Verzeichnis.
     */
    public static void findFile(final String name, final File dir) {
        final File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    findFile(name, file);
                } else if (name.equalsIgnoreCase(file.getName())) {
                    LOG.info(file.getParentFile().toString());
                    return;
                }
            }
        }
    }
}
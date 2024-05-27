package ch.hslu.ad.sw13.comparison;

import ch.hslu.ad.sw13.kmpSearch.KmpSearch;
import ch.hslu.ad.sw13.quickSearch.QuickSearch;
import ch.hslu.ad.sw13.simpleSearch.SimpleSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo {

    private static final Logger LOG =
            LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        measureAllSearchRuntime("dracula.txt","1 MB", "first");
        measureAllSearchRuntime("bible.txt","5 MB", "first");

        measureAllSearchRuntime("dracula.txt","1 MB", "aber");
        measureAllSearchRuntime("bible.txt","5 MB", "aber");

    }

    public static void measureAllSearchRuntime(String filename, String fileSize, String p) {
        long start;
        long end;

        String a = readFile(filename);

        System.out.println("File: " + filename);
        System.out.println("Size: " + fileSize);
        System.out.println("Pattern: " + p + "\n");


        System.out.println("| Algorithm | Time (ms) |");
        System.out.println("|-----------|-----------|");

        start = System.currentTimeMillis();
        SimpleSearch.simpleSearch(a, p);
        end = System.currentTimeMillis();
        System.out.printf("| Simple    |     %d     |\n", end - start);

        start = System.currentTimeMillis();
        KmpSearch.kmpSearch(a, p);
        end = System.currentTimeMillis();
        System.out.printf("| KMP       |     %d     |\n", end - start);

        start = System.currentTimeMillis();
        QuickSearch.quickSearch(a, p);
        end = System.currentTimeMillis();
        System.out.printf("| Quick     |     %d     |\n", end - start);

        start = System.currentTimeMillis();
        QuickSearch.optimalMismatch(a, p);
        end = System.currentTimeMillis();
        System.out.printf("| Mismatch  |     %d     |\n\n", end - start);
    }

    private static String readFile(String filename) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/textfiles/" + filename));
            StringBuilder asciiContent = new StringBuilder();
            for (byte b : bytes) {
                if ((b & 0xFF) < 128) { // Check if the byte represents an ASCII character
                    asciiContent.append((char) b);
                }
            }
            return asciiContent.toString();
        } catch (IOException e) {
            LOG.error("Error reading file: " + e.getMessage());
            return "";
        }
    }
}

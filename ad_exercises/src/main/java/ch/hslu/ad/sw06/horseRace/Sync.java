package ch.hslu.ad.sw06.horseRace;

public interface Sync {
    /**
     * Eintritt in einen geschützten Bereich erlangen,
     * falls kein Zutritt möglich ist warten.
     *
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     */
    public void acquire() throws InterruptedException;

    /**
     * Freigabe des geschützten Bereiches.
     */
    public void release();
}

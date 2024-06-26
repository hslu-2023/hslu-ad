package ch.hslu.ad.sw08.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class PrimeChecker implements Callable<BigInteger> {

    private BigInteger value;

    private static BigInteger newRandomNumber() {
        return new BigInteger(1024, new Random());
    }

    public PrimeChecker() {
        this.value = PrimeChecker.newRandomNumber();
    }

    @Override
    public BigInteger call() throws Exception {
        while (!value.isProbablePrime(Integer.MAX_VALUE)){
            value = PrimeChecker.newRandomNumber();
        }
        return value;
    }
}

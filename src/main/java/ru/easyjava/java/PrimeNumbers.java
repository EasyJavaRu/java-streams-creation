package ru.easyjava.java;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Example of generated streams.
 */
public class PrimeNumbers {
    /**
     * Lower range limit.
     */
    private static final Integer MIN_RANGE = 1;

    /**
     * Upper range limit.
     */
    private static final Integer MAX_RANGE = 100;

    /**
     * "Top" limit value.
     */
    private static final Integer TOP_TEN = 10;

    /**
     * Checks, is number is a prime number.
     * @param n number to check.
     * @return true is n is a prime number.
     */
    protected static boolean isPrime(final int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Searches for 10 prime numbers in random integer series.
     */
    public final void randomPrimes() {
        new Random()
                .ints()
                .filter(PrimeNumbers::isPrime)
                .limit(TOP_TEN)
                .forEach(System.out::println);
    }

    /**
     * Finds max prime number between MIN_RANG and MAX_RANGE.
     * @return 97
     */
    public final Integer rangePrimeMax() {
        return IntStream.range(MIN_RANGE, MAX_RANGE)
                .filter(PrimeNumbers::isPrime)
                .summaryStatistics()
                .getMax();
    }

    /**
     * Finds first prime number in generated random integers series.
     * @return some prime number.
     */
    public final Integer randomSeriesPrimes() {
        Random r = new Random();
        Optional<Integer> result = Stream.iterate(2, o -> o + r.nextInt())
                .filter(PrimeNumbers::isPrime)
                .findAny();
        if (!result.isPresent()) {
            return 0;
        }
        return result.get();
    }
}

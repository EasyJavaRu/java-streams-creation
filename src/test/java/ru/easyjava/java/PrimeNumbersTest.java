package ru.easyjava.java;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class PrimeNumbersTest {
    private PrimeNumbers testedObject = new PrimeNumbers();

    @Test
    public void testRandom() {
        testedObject.randomPrimes();
    }

    @Test
    public void testMaxPrime() {
        assertThat(testedObject.rangePrimeMax(), is(97));
    }

    @Test
    public void testSeriesPrime() {
        assertThat(testedObject.randomSeriesPrimes(), not(0));
    }
}
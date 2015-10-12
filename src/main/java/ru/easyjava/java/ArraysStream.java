package ru.easyjava.java;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Example of array based streams.
 */
public class ArraysStream {
    /**
     * Example integer data.
     */
    private Integer[] numbers = {
            87,
            8,
            37,
            20,
            28,
            47,
            70,
            45,
            89,
            9,
            72,
            52,
            99};

    /**
     * Calculates summary value of integer array entries.
     * @return 663L
     */
    public final long summaryArray() {
        return Arrays.stream(numbers)
                .mapToInt(i -> i)
                .summaryStatistics()
                .getSum();
    }

    /**
     * Counts average word length in 'Lorem ipsum'.
     * @return ~6
     */
    public final double avarageLorem() {
        return Stream.<String>of(
                "Lorem",
                "ipsum",
                "dolor",
                "sit",
                "amet",
                "consectetur",
                "adipiscing",
                "elit",
                "Curabitur",
                "vestibulum")
                .mapToInt(String::length)
                .summaryStatistics()
                .getAverage();
    }
}

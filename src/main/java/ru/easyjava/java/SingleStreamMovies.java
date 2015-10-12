package ru.easyjava.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Single threaded movie counter.
 */
public final class SingleStreamMovies {
    /**
     * Regexp that extract year from IMDB's movies.list.
     */
    private static final Pattern YEAR_PATTERN =
            Pattern.compile(".*\\s+(\\d{4})$");

    /**
     * Do not construct me.
     */
    private SingleStreamMovies() { }

    /**
     * Entry point.
     * @param args Os arguments
     * @throws IOException when movies.list is unreadable
     */
    public static void main(final String[] args) throws IOException {
        new BufferedReader(new InputStreamReader(SingleStreamMovies.class
                .getClassLoader()
                .getResourceAsStream("movies.list")))
                .lines()
                .map(YEAR_PATTERN::matcher)
                .filter(Matcher::matches)
                .map(m -> m.group(1))
                .map(Integer::parseInt)
                .sorted()
                .collect(
                        Collectors.groupingBy(i -> i,
                                LinkedHashMap::new,
                                Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + ":" + v));
    }
}

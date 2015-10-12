package ru.easyjava.java;

import org.junit.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.AccessDeniedException;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class CountFilesTest {
    private CountFiles testedObject = new CountFiles();


    @Test
    public void testCountTopDirectories() throws IOException {
        assertThat(testedObject.countTopDirectories(), greaterThan(0L));
    }

    @Test
    public void testCountOnlyDirectories() throws IOException {
        /**
         * / is not included into find, but included in list.
         */
        assertEquals(testedObject.countOnlyDirectories("/"), testedObject.countTopDirectories()-1);
    }

    @Test(expected = UncheckedIOException.class)
    public void testCountSFiles() throws IOException {
        assertEquals(testedObject.countFilesStartingWithS(), 1);
    }
}
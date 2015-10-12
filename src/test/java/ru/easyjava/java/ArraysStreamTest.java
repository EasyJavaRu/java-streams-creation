package ru.easyjava.java;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class ArraysStreamTest {
    private ArraysStream testedObject = new ArraysStream();

    @Test
    public void testFromArray() {
        assertThat(testedObject.summaryArray(), is(663L));
    }

    @Test
    public void testAverageLorem() {
        assertThat(testedObject.avarageLorem(), is(closeTo(6,1)));
    }
}
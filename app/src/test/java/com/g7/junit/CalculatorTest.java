package com.g7.junit;


import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {


    @InjectMocks
    Calculator mockCalculator;


    @Test
    public void inputs_addTest() {
        assertEquals(7, mockCalculator.add(3, 4));
    }

    @Test
    public void inputs_subtractTest() {
        assertEquals(1, mockCalculator.subtract(4, 3));
    }

    @Test
    public void inputs_multiplyTest() {
        assertEquals(12, mockCalculator.multiply(3, 4));
    }

    @Test
    public void inputs_divideTest() {
        assertEquals(5, mockCalculator.divide(20, 4));
    }

    @Test
    public void inputsFailed_addTest() {
        assertFalse(mockCalculator.add(3, 4) == 6);
    }

    @Test
    public void inputsFailed_subtractTest() {
        assertFalse(mockCalculator.subtract(3, 4) == 1);
    }

    @Test
    public void inputsFailed_multiplyTest() {
        assertFalse(mockCalculator.multiply(3, 4) == 10);
    }

    @Test
    public void inputsFailed_divideTest() {
        assertFalse(mockCalculator.divide(20, 4) == 7);
    }


    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        mockCalculator.divide(3, 0);
    }

}

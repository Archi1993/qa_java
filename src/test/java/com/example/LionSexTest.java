package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionSexTest {
    private final String sexTest;
    private final boolean hasManeTest;

    @Mock
    Feline feline;

    public LionSexTest(String sexTest, boolean hasManeTest) {
        this.sexTest = sexTest;
        this.hasManeTest = hasManeTest;
    }

    @Parameterized.Parameters
    public static Object[][] LionParams() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void lionSexTest() throws Exception {
        Lion lion = new Lion(sexTest, feline);
        assertEquals(hasManeTest, lion.doesHaveMane());
    }
}
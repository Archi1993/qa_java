package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void haveLionOneKittenTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittens = lion.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void haveManeTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHaveMane = true;
        boolean actualHaveMane = lion.doesHaveMane();
        assertEquals(expectedHaveMane, actualHaveMane);
    }

    @Test
    public void isLionEatFoodForPredatorTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFoodLion = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFoodLion, actualFood);
    }

    @Test(expected = Exception.class)
    public void invalidSexTest() throws Exception {
        new Lion("invalid sex", feline);
    }
}
package com.example;


import org.mockito.Mockito;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void isTheCatSaidMeowTrue() {
        Cat cat = new Cat(feline);
        String actual = "Мяу";
        assertEquals(cat.getSound(), actual);
    }

    @Test
    public void isCatEatFoodForPredatorTrue() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFoodCat = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFoodCat, actualFood);
    }
}
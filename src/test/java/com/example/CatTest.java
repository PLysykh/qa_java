package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    Feline feline;

    @Test
    public void getSoundTest(){
        cat = new Cat(feline);
        String actualSound = cat.getSound();
        assertTrue("Мяу".equals(actualSound));
    }

    @Test
    public void getFoodTest() throws Exception{
        cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}
package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;

    private static final String MALE = "Самец";

    private static final String ANOTHER = "Третий пол";

    private static final String EXCEPTION = "Используйте допустимые значения пола животного - самец или самка";


    @Mock
    private Feline feline;


    @Test
    public void getFoodTest() throws Exception{
        lion = new Lion(MALE, feline);
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void doesHaveManeTest() {
        try {
            lion = new Lion(ANOTHER, feline);
            lion.doesHaveMane();
        } catch (Exception e){
            String exception = e.getMessage();
            assertEquals(EXCEPTION, exception);
        }
    }

    @Test
    public void getKittensTest() throws Exception{
        lion = new Lion(MALE, feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }
}
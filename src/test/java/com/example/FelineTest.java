package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private final String felineExpected = "Кошачьи";
    private int numberOfKittensCheck = 3;
    private static final int mockedKittensNumber = 1;

    @Spy
    private Feline feline;

    @Test
    public void eatMeatTest() throws Exception{
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest(){
        String familyGot;
        familyGot = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertTrue(felineExpected.equals(familyGot));
    }

    @Test
    public void getKittensWithoutParametersTest(){
        int numberOfKittensActual = feline.getKittens();
        Mockito.verify(feline).getKittens(mockedKittensNumber);
        assertEquals(mockedKittensNumber, numberOfKittensActual);
    }

    @Test
    public void getKittensWithParametersTest(){
        int numberOfKittensActual = feline.getKittens(numberOfKittensCheck);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        assertEquals(numberOfKittensCheck, numberOfKittensActual);
    }
}
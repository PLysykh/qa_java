package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private Lion lion;
    private Feline feline;
    private String sex;
    private boolean haveMane;


    public LionParameterizedTest(String sex, boolean haveMane){
        this.sex = sex;
        this.haveMane = haveMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters(){
        return new Object[][]{
                {MALE, true},
                {FEMALE, false}
        };
    }

    @Test
    public void manePresentTest() throws Exception{
        feline = Mockito.mock(Feline.class);
        lion = new Lion(sex, feline);
        boolean result = lion.doesHaveMane();
        assertEquals(haveMane, result);
    }
}
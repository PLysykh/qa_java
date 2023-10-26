package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private Animal animal;
    private static final String HERBIVORE = "Травоядное";
    private static final String PREDATOR = "Хищник";
    private static final List<String> HERBIVORE_FOOD = List.of("Трава", "Различные растения");
    private static final List<String> PREDATOR_FOOD = List.of("Животные", "Птицы", "Рыба");


    private String specy;
    private List<String> foods;

    public AnimalParameterizedTest(String specy, List<String> foods){
        this.specy = specy;
        this.foods = foods;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters(){
        return new Object[][]{
                {HERBIVORE, HERBIVORE_FOOD},
                {PREDATOR, PREDATOR_FOOD}
        };
    }

    @Test
    public void getFoodTest()throws Exception{
        animal = new Animal();
        List<String> actual = animal.getFood(specy);
        assertTrue(actual.equals(foods));
    }
}
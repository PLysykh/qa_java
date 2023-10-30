package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {

    private static final String ANOTHER_ANIMAL = "Cold-blooded creature";
    private static final String EXCEPTION = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private static final String FAMILY_NAMES = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    private static final List<String> foodForPredators = List.of("Говядина", "Свинина", "Баранина");

    @Test
    public void getFamilyTest(){
        Animal animal = new Animal();
        String actualName = animal.getFamily();
        assertTrue(FAMILY_NAMES.equals(actualName));
    }

    @Test
    public void getFoodToUnknownAnimalExceptionTest() {
        Animal animal = new Animal();
        try {
            animal.getFood(ANOTHER_ANIMAL);
            fail("Exception is being expected");
        } catch (Exception e) {
            String exception = e.getMessage();
            assertTrue(EXCEPTION.equals(exception));
        }
    }

    @Mock
    Animal animal;

    @Test
    public void getFoodVerifyConstructionTest() throws Exception {
        animal.getFood("Травоядное");
        Mockito.verify(animal).getFood(Mockito.anyString());
    }

    @Test
    public void getFoodWhenThenReturnConstructionTest() throws Exception{
        Mockito.when(animal.getFood("Хищник")).thenReturn(foodForPredators); //Assuming the return type is also a List
        List<String> result = animal.getFood("Хищник"); //Calling the method with the specified argument
        Mockito.verify(animal).getFood("Хищник"); //Verifying that the method was called with the exact argument
        assertEquals(foodForPredators, result); //Asserting that the returned list of food is as it is expected
    }
}